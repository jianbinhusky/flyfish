import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyWord {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String url1 = "http://www.news.163.com";
		String url = "https://www.baidu.com";
		Map<String, String> map = new HashMap<>();
		map.put("a", "1");
		map.put("b", "2");

		final DefaultHttpClient httpClient = new DefaultHttpClient();
		final HttpPost httpPost = new HttpPost(url);
		String result = null;

		//ignore ssl
		SSLContext ctx = SSLContext.getInstance("TLS");
		X509TrustManager tm = new X509TrustManager() {
			@Override
			public void checkClientTrusted(X509Certificate[] chain,
										   String authType) throws CertificateException {
			}
			@Override
			public void checkServerTrusted(X509Certificate[] chain,
										   String authType) throws CertificateException {
			}
			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};
		ctx.init(null, new TrustManager[]{tm}, null);
		SSLSocketFactory ssf = new SSLSocketFactory(ctx, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		ClientConnectionManager ccm = httpClient.getConnectionManager();
		SchemeRegistry sr = ccm.getSchemeRegistry();
		sr.register(new Scheme("https", 443, ssf));


		List<NameValuePair> nvps = new ArrayList<>();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));

		HttpResponse response;
		try {
			response= httpClient.execute(httpPost);
		} catch (Exception e) {
			response = null;
		}
		if (response != null) {
			final HttpEntity resEntity = response.getEntity();

			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				if (resEntity != null) {
					//read response
					result = EntityUtils.toString(resEntity, "UTF-8");
				}
			} else {
				String message = EntityUtils.toString(resEntity, "UTF-8");
				if (message == null || message.trim().equals("")) {
					message = resEntity.toString();
				}

				throw new Exception("Status code:" + response.getStatusLine().getStatusCode() + ". Error:" + message);
			}

		}
	}
}

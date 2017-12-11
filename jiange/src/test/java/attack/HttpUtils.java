/**
 *
 */
package attack;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLEncoder;


/**
 * @author Young, Xue
 *
 */
public class HttpUtils
{

	private static final String CHARSET = "UTF-8";
	private static final String CONTENT_TYPE = "application/x-www-form-urlencoded";

	/**
	 * doPost
	 *
	 * @param url
	 * @param body
	 * @return String
	 * @throws Exception
	 */
	public static String doPost(final String url, final String body) throws Exception
	{

		final DefaultHttpClient httpClient = new DefaultHttpClient();
		final HttpPost httpPost = new HttpPost(url);
		String result = null;

		//Content type
		httpPost.setHeader("Content-Type", CONTENT_TYPE);

		//charset
		final HttpEntity entity = new ByteArrayEntity(body.getBytes(CHARSET));
		httpPost.setEntity(entity);

		//execute
		final HttpResponse response = httpClient.execute(httpPost);
		if (response != null)
		{
			final HttpEntity resEntity = response.getEntity();

			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
			{
				if (resEntity != null)
				{
					//read response
					result = EntityUtils.toString(resEntity, CHARSET);
				}
			}
			else
			{
				String message = EntityUtils.toString(resEntity, CHARSET);
				if (message == null || message.trim().equals(""))
				{
					message = resEntity.toString();
				}
				throw new Exception("Status code:" + response.getStatusLine().getStatusCode() + ". Error:" + message);
			}

		}
		return result;
	}

	/**
	 * doGet
	 *
	 * @param url
	 * @return String result
	 * @throws Exception
	 */
	public static String doGet(final String url) throws Exception
	{
		final URIBuilder urlBuilder = new URIBuilder(url);
		final HttpGet request = new HttpGet(urlBuilder.build());
		final HttpClient client = new DefaultHttpClient();
		final HttpResponse response = client.execute(request);
		final BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		final StringBuilder result = new StringBuilder();

		String line = null;
		while ((line = rd.readLine()) != null)
		{
			result.append(line);
		}

		return result.toString();
	}

	/**
	 * urlEncoding
	 * 
	 * @param msgToEncode
	 * @return encoded
	 */
	public static String urlEncoding(final String msgToEncode)
	{
		return URLEncoder.encode(msgToEncode);
	}
}

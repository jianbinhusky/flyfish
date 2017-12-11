import com.alibaba.fastjson.JSON;
import com.hujianbin.manage.action.HelloMongo;
import org.apache.commons.lang.StringUtils;

import java.util.*;


public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<?> list1 = new ArrayList();
		List list2 = new ArrayList();
		//List<E> list3 = new ArrayList<E>(); 
		//list1.add(1, null);
		//list1.add("str");
		list1.add(null);
		
		list2.add(1);
		list2.add("String");
		list2.add(2.28939);
		list2.add(Integer.parseInt("2"));
		for (Object object : list2) {
			System.out.println(object);
		}
		
		List<?> list4;
		
		list4 = new ArrayList<Integer>();
		//list4.add(4);

		String a = "A";
		System.out.println(a.toUpperCase());

		for (int i = 0; i < 10; i++) {
			System.out.println("tan xiao niao shi s b");
		}

		System.out.println("hello world");
		System.out.println(HelloMongo.class.getName());

		ArrayList<String> strings = new ArrayList<String>();
		strings.add("en_AU");
		strings.add("en_HK");
		strings.add("en");
//		if(strings.contains("en_HK")){
//			System.out.println("en_Hk");
//		}else if(strings.contains("en")){
//			System.out.println("en");
//		}

		String old = "en_GB";
		String isoCode = old.split("_")[0];
		System.out.println("isocode = " +isoCode);

		String str = "1213290217";
		System.out.println(str.substring(5));


		System.out.println("#############################################################################");
		System.out.println("#################   StringUtils                           ##################");
		System.out.println("#############################################################################");
		String s1 = null;
		String s2 = "";
		String s3 = " ";
		System.out.println(StringUtils.isBlank(s1));
		System.out.println(StringUtils.isBlank(s2));
		System.out.println(StringUtils.isBlank(s3));
		System.out.println(StringUtils.isNotBlank(s1));
		System.out.println(StringUtils.isNotBlank(s2));
		System.out.println(StringUtils.isNotBlank(s3));

		String[] sp = "jobyhu8@126.com".split(" ");
		System.out.println(sp.length);
		System.out.println(sp[0]);


		System.out.println(Runtime.getRuntime().availableProcessors());

		Map<String, String> map = new HashMap<>();
		map.put("NEW_ITEM-LONGTEXT-1", "1");
		map.put("NEW_ITEM-LONGTEXT-2".toLowerCase(), "2");
		map.put("NEW_item-LONGTEXT-3", "3");

		for (Map.Entry<String, String> entry : map.entrySet()) {
			String name;
			if (entry.getKey().toUpperCase().contains("NEW_ITEM-LONGTEXT".toUpperCase())) { //ContainsIgnoreCase
				System.out.println(entry.getKey() + "\t" + "Y");
			} else {
				System.out.println(entry.getKey());
			}
		}


		System.out.println("======================================================================");
		String testS = "13038293|test@gmail.com";
		String[] ts = testS.split("\\|");
		for (String t : ts) {
			System.out.println(t);
		}
		System.out.println(ts.length);
		System.out.println(ts[1]);

		System.out.println(new Date().getTime());

		String msg = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
				"\n" +
				"<cXML payloadID=\"1510039835000.4364@HUJB4XPC08QRT6\" timestamp=\"2017-11-07T15:30:35+08:00\" xml:lang=\"en-US\"> \n" +
				"  <Header> \n" +
				"    <From> \n" +
				"      <Credential domain=\"DUNS\"> \n" +
				"        <Identity>123456789</Identity> \n" +
				"      </Credential> \n" +
				"    </From>  \n" +
				"    <To> \n" +
				"      <Credential domain=\"DUNS\"> \n" +
				"        <Identity>ABCDEFGH</Identity> \n" +
				"      </Credential> \n" +
				"    </To>  \n" +
				"    <Sender> \n" +
				"      <Credential domain=\"DUNS\"> \n" +
				"        <Identity>123456789</Identity>  \n" +
				"        <SharedSecret>VerySecret1234</SharedSecret> \n" +
				"      </Credential>  \n" +
				"      <UserAgent>CatalogTester</UserAgent> \n" +
				"    </Sender> \n" +
				"  </Header>  \n" +
				"  <Request> \n" +
				"    <PunchOutSetupRequest operation=\"create\"> \n" +
				"      <BuyerCookie>2wSeTGXpJOJLhFpl0gsbQsYlSuDoiLvV0.3969344609624768632</BuyerCookie>  \n" +
				"      <BrowserFormPost> \n" +
				"        <URL>http://localhost:9001/nemopunchouttool/ariba/handlePunchOutOrder?token=bba45c3016df4ce9a3c59599f450adb0</URL> \n" +
				"      </BrowserFormPost>  \n" +
				"      <SupplierSetup> \n" +
				"        <URL>http://www.lenovo.com</URL> \n" +
				"      </SupplierSetup>  \n" +
				"      <ShipTo> \n" +
				"        <Address addressID=\"26\"> \n" +
				"          <Name xml:lang=\"en-US\">Catalog Tester</Name>  \n" +
				"          <PostalAddress name=\"_5uicbb\"> \n" +
				"            <DeliverTo>Catalog Tester</DeliverTo>  \n" +
				"            <Street>1234 Catalog Tester Way</Street>  \n" +
				"            <City>Sunnyvale</City>  \n" +
				"            <State>CA</State>  \n" +
				"            <PostalCode>94089</PostalCode>  \n" +
				"            <Country isoCountryCode=\"US\">United States</Country> \n" +
				"          </PostalAddress> \n" +
				"        </Address> \n" +
				"      </ShipTo>  \n" +
				"      <SelectedItem> \n" +
				"        <ItemID> \n" +
				"          <SupplierPartID/>  \n" +
				"          <SupplierPartAuxiliaryID/> \n" +
				"        </ItemID> \n" +
				"      </SelectedItem>  \n" +
				"      <Extrinsic name=\"nemo\">hello</Extrinsic> \n" +
				"    </PunchOutSetupRequest> \n" +
				"  </Request> \n" +
				"</cXML>\n";
		System.out.println("msg length = " + msg.length());
		String json1 = "{\"catalogUrl\":\"https://localhost:9002/le/punchout/oxml/login\",\"loginRequest\":\"hello\"}";
		String json = "{catalogUrl:\"https://localhost:9002/le/punchout/oxml/login\",loginRequest:\"hello\"}";
		String josn2 = "{\"catalogUrl\":\"https://localhost:9002/le/punchout/oxml/login\",\"loginRequest\":<?xml version = '1.0' encoding = 'UTF-8'?>\n" +
				"<request>\n" +
				"\t<header version=\"1.0\">\n" +
				"\t\t<login>\n" +
				"\t\t\t<username>joby</username>\n" +
				"\t\t\t<password>welcome</password>\n" +
				"\t\t</login>\n" +
				"\t\t<action>shopping</action>\n" +
				"\t\t<language>EN</language>\n" +
				"\t\t<searchLanguage />\n" +
				"\t\t<userArea>\n" +
				"\t\t\t<operatingUnit>204</operatingUnit>\n" +
				"\t\t\t<shipTo>V1 - New York City</shipTo>\n" +
				"\t\t\t<deliverTo>V1 - New York City</deliverTo>\n" +
				"\t\t</userArea>\n" +
				"\t</header>\n" +
				"\t<body>\n" +
				"\t\t<loginInfo>\n" +
				"\t\t\t<exchangeInfo>\n" +
				"\t\t\t\t<exchangeName>Oracle iProcurement</exchangeName>\n" +
				"\t\t\t</exchangeInfo>\n" +
				"\t\t\t<userInfo>\n" +
				"\t\t\t\t<userName>Stock, Pat</userName>\n" +
				"\t\t\t\t<userContactInfo>\n" +
				"\t\t\t\t\t<userPhone />\n" +
				"\t\t\t\t\t<userEmail>pat.stock@vision.com</userEmail>\n" +
				"\t\t\t\t</userContactInfo>\n" +
				"\t\t\t\t<appUserName>OPERATIONS</appUserName>\n" +
				"\t\t\t\t<userCompany>\n" +
				"\t\t\t\t\t<companyName>Buyer Corp.</companyName>\n" +
				"\t\t\t\t\t<companyDUNS>144709193</companyDUNS>\n" +
				"\t\t\t\t\t<contactName />\n" +
				"\t\t\t\t\t<contactPhone />\n" +
				"\t\t\t\t</userCompany>\n" +
				"\t\t\t</userInfo>\n" +
				"\t\t\t<returnURL>https://localhost:9002/nemopunchouttool/oxml/handlePunchOutOrder</returnURL>\n" +
				"\t\t</loginInfo>\n" +
				"\t\t<partySiteId />\n" +
				"\t\t<searchKeywords />\n" +
				"\t\t<icxSessionCallBackURL />\n" +
				"\t</body>\n" +
				"</request>\n" +
				"}";

		Object oxmlParam = JSON.parse(json);

	}

	class OxmlParam{
		private String loginRequest;
		private String catalogUrl;

		public String getLoginRequest() {
			return loginRequest;
		}

		public void setLoginRequest(String loginRequest) {
			this.loginRequest = loginRequest;
		}

		public String getCatalogUrl() {
			return catalogUrl;
		}

		public void setCatalogUrl(String catalogUrl) {
			this.catalogUrl = catalogUrl;
		}
	}

}

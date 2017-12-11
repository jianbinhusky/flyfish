package attack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hujb4 on 2016/7/20.
 */
public class TestPost {
    public static final String URL = "http://127.0.0.1:8080/admin/addCategory.json";

    public static void main(String[] args) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("categoryName", "sexyff");

//        String response = HttpUtil.doPost(URL, map);

        StringBuffer sb = new StringBuffer();
        if(map!=null){

            for (Map.Entry<String, String> e : map.entrySet()) {
                sb.append("&");
                sb.append(e.getKey());
                sb.append("=");
                sb.append(e.getValue());
            }
            sb.substring(0, sb.length() - 1);
        }
        for (int i = 0; i < 100000000; i++) {
            String response = HttpUtils.doPost(URL, sb.toString());
            System.out.println(response);
            Thread.sleep(1000);
        }

    }
}

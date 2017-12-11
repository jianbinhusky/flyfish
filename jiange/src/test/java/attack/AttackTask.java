package attack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hujb4 on 2016/7/20.
 */
public class AttackTask implements Runnable {
    public static final String URL = "http://121.40.27.64/index.php?a=add";

    @Override
    public void run() {
        Map<String, String> map=new HashMap();
        map = RandomValue.getAddress();
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

        System.out.println("send_data:"+sb.toString());
        System.out.println(map);
        String response = null;
        try {
            while(true){
                response = HttpUtil.doPost(URL, map);
                System.out.println(response);
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

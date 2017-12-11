package json;

import java.io.*;

/**
 * Created by hujb4 on 2016/11/7.
 */
public class JsonFormat {

    public static String formatJson(String jsonStr) {
        if (null == jsonStr || "".equals(jsonStr)) return "";
        StringBuilder sb = new StringBuilder();
        char last = '\0';
        char current = '\0';
        int indent = 0;
        for (int i = 0; i < jsonStr.length(); i++) {
            last = current;
            current = jsonStr.charAt(i);
            switch (current) {
                case '{':
                case '[':
                    sb.append(current);
                    sb.append('\n');
                    indent++;
                    addIndentBlank(sb, indent);
                    break;
                case '}':
                case ']':
                    sb.append('\n');
                    indent--;
                    addIndentBlank(sb, indent);
                    sb.append(current);
                    break;
                case ',':
                    sb.append(current);
                    if (last != '\\') {
                        sb.append('\n');
                        addIndentBlank(sb, indent);
                    }
                    break;
                default:
                    sb.append(current);
            }
        }

        return sb.toString();
    }


    private static void addIndentBlank(StringBuilder sb, int indent) {
        for (int i = 0; i < indent; i++) {
            sb.append('\t');
        }
    }

    public static String fileToString(String filePath){
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader reader = null;
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(filePath);
            String line;
            reader = new BufferedReader(new InputStreamReader(inputStream));
            line = reader.readLine();
            while (line != null) {
                stringBuffer.append(line);
                stringBuffer.append("\n");
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                reader.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return stringBuffer.toString();
    }

    public static void main(String[] args) throws IOException {
        String filePath = "D:\\temp\\ctoConfigDetail.txt";
        String htmlString = fileToString(filePath);
        String jsonString = formatJson(htmlString);
        File file = new File("D:\\temp\\ctoConfigDetailFormat.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(jsonString.getBytes());
        fileOutputStream.close();
        System.out.println(jsonString);
    }
}

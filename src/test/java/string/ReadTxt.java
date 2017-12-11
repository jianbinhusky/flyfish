package string;

import java.io.*;

public class ReadTxt {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("C:\\Users\\hujb4\\Desktop\\B2BUnit.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = reader.readLine();
        StringBuffer stringBuffer = new StringBuffer();
        while (line != null) {
            stringBuffer.append(line);
            stringBuffer.append("\n");
            line = reader.readLine();
        }
        System.out.println(stringBuffer.toString().replaceAll("\t",","));
    }
}

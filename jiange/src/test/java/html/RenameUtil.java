package html;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**

 */
public class RenameUtil {
    public static final String DISK = "D:";
    public static final String DIR = "D:\\template\\omega.oxygenna.com";
    public static final String newDir = "D:\\Users\\hujb4\\other eclipse workspace\\workspace\\jiange\\WebContent\\html\\rohitink\\demo.rohitink.com";
    public static final String dir2 = "D:\\Users\\hujb4\\other eclipse workspace\\workspace\\jiange\\WebContent\\html\\charisma-master";
    public static final String dir3 = "D:\\tinyuiweb\\joby\\page";
    public static void mkDir(File file){
        if(file.getParentFile().exists()){
            file.mkdir();
        }else{
            mkDir(file.getParentFile());
            file.mkdir();
        }
    }

    public static void writeFile(String file , String fileString){
        FileOutputStream fileOutputStream = null;
        try {
            String path = file.substring(0, file.lastIndexOf("/"));
            File dir = new File(DISK + path);
            if(!dir.exists()){
                mkDir(dir);
            }
            File newFile = new File(DISK + file.replace(".page",".html"));
            if(!newFile.exists()){
                newFile.createNewFile();
                fileOutputStream = new FileOutputStream(newFile);
                fileOutputStream.write(fileString.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileOutputStream != null){
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void populator(File file, List<String> list) {
        File[] files = file.listFiles();
        for (File file1 : files) {
            if(file1.isFile()){
                if(file1.getName().endsWith(".htm") || file1.getName().endsWith(".html") || file1.getName().endsWith(".jsp")){
                    System.out.println(file1.getPath());
                    list.add(file1.getPath());
                }
            }else if(file1.isDirectory()){
                populator(file1, list);
            }
        }
    }

    public static void batchRenameHtmToHtml(List<String> list){
        for (String s : list) {
            renameFile(s, s.replace(".html",".jsp"));
            File file1 = new File(s);
            if (file1.isFile() && file1.exists()) {
                file1.delete();
            }
        }
    }

    public static void renameFile(String source, String target) {
        File file = null;
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            file = new File(source);
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(target);
            byte[] buffer = new byte[1024];
            while (fileInputStream.read(buffer, 0, buffer.length) != -1) {
                fileOutputStream.write(buffer, 0, buffer.length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void batchFormatHtml(List<String> list){
        for (String s : list) {
            formatHtml(s);
        }
    }

    public static void formatHtml(String path){
//        String path = "D:\\template\\omega.oxygenna.com\\tag\\audio\\index.html";
        String mex = "<!-- Performance optimized by W3 Total Cache. Learn more: http://www.w3-edge.com/wordpress-plugins/";
        BufferedReader reader = null;
        InputStream inputStream = null;
        StringBuffer stringBuffer = new StringBuffer();
        String fomatHtml = null;
        try {
            inputStream = new FileInputStream(path);
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = reader.readLine();
            while (line != null && !line.equals(mex) ) {
                line = line.replace("http://omega.oxygenna.com/","");
                line = line.replace("http://demo.rohitink.com/","");
                if(line.contains("<script") && line.contains("src=")){
                    String regex1 = "tppabs=\"([\\s\\S]*?)\"";
                    line = line.replaceAll(regex1, "");
                    String regex2 = "-ver=([\\s\\S]*?)\"";
                    line = line.replaceAll(regex2, "\"");
                }else if(line.contains("<link") && line.contains("href=")){
                    String regex1 = "tppabs=\"([\\s\\S]*?)\"";
                    line = line.replaceAll(regex1, "");
                    String regex2 = "-ver=([\\s\\S]*?)\"";
                    line = line.replaceAll(regex2, "\"");
                }else if(line.contains("<a") && line.contains("href=")){
                    String regex1 = "tppabs=\"([\\s\\S]*?)\"";
                    line = line.replaceAll(regex1, "");
                    line = line.replace(".htm\"", ".html\"");
                }else if(line.contains("<img") && line.contains("src=")){
                    String regex1 = "tppabs=\"([\\s\\S]*?)\"";
                    line = line.replaceAll(regex1, "");
                    String regex2 = "srcset=\"([\\s\\S]*?)\"";
                    line = line.replaceAll(regex2, "");
                }else if(line.contains("<meta") && line.contains("charset=")){
                    String regex1 = "charset=\"([\\s\\S]*?)\"";
                    line = line.replaceAll(regex1, "charset=\"UTF-8\"");
                }
                stringBuffer.append(line);
                stringBuffer.append("\n");
                line = reader.readLine();
            }
//            System.out.println(stringBuffer.toString());
//            System.out.println("===========================================================================================================================================================================");
//            System.out.println("===========================================================================================================================================================================");
//            System.out.println("###########################################################################################################################################################################");
//            System.out.println("===========================================================================================================================================================================");
//            System.out.println("===========================================================================================================================================================================");

            Document doc = Jsoup.parse(stringBuffer.toString());
            fomatHtml = doc.html();
//            System.out.println(fomatHtml);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileOutputStream fileOutputStream = null;
        try {
            File newFile = new File(path);
            fileOutputStream = new FileOutputStream(newFile);
            fileOutputStream.write(fomatHtml.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileOutputStream != null){
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void formatJSP(){
        String path = "D:\\tinyuiweb\\joby\\page\\addBlog.jsp";
        BufferedReader reader = null;
        InputStream inputStream = null;

        StringBuffer sb = new StringBuffer();
        sb.append("<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\"%>");
        sb.append("\n");
        sb.append("<%@ taglib uri=\"http://java.sun.com/jsp/jstl/core\" prefix=\"c\"%>");
        sb.append("\n");
        sb.append("<%@ taglib prefix=\"fmt\" uri=\"http://java.sun.com/jsp/jstl/fmt\" %>");
        sb.append("\n");

        StringBuffer stringBuffer = new StringBuffer();
        try {
            inputStream = new FileInputStream(path);
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = reader.readLine();
            while (line != null) {
                if(line.contains("<script") && line.contains("src=")){
                    line = line.replace("src=\"/tinyuiweb/org/tinygroup/", "src=\"<c:url value='/joby/org/monkey/").replace("\"></script>","'/>\"></script>");
                    line = line.replace("src=\"/tinyuiweb/js/setting.js", "src=\"<c:url value='/joby/js/setting.js").replace("\"></script>","'/>\"></script>");
                }else if(line.contains("<link") && line.contains("href=")){
                    line = line.replace("href=\"/tinyuiweb/org/tinygroup/", "href=\"<c:url value='/joby/org/monkey/").replace("\" rel=\"stylesheet\" />","' />\" rel=\"stylesheet\" />");
                }else if(line.contains("<a") && line.contains("href=")){

                }else if(line.contains("<img") && line.contains("src=")){

                }
                stringBuffer.append(line);
                stringBuffer.append("\n");
                line = reader.readLine();
            }
            sb.append(stringBuffer);
            System.out.println(sb.toString());
//            System.out.println("===========================================================================================================================================================================");
//            System.out.println("===========================================================================================================================================================================");
//            System.out.println("###########################################################################################################################################################################");
//            System.out.println("===========================================================================================================================================================================");
//            System.out.println("===========================================================================================================================================================================");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        FileOutputStream fileOutputStream = null;
//        try {
//            File newFile = new File(path);
//            fileOutputStream = new FileOutputStream(newFile);
//            fileOutputStream.write(stringBuffer.toString().getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if(fileOutputStream != null){
//                    fileOutputStream.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

    }


    public static void main(String[] args) {
        File file = new File(dir3);
        List<String> list = new ArrayList<String>();
        populator(file, list);
        System.out.println(list.size());

        formatJSP();

//        batchFormatHtml(list);

//      batchRenameHtmToHtml(list);

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Duang~~~!!!~~~Duang~~~!!!~~~Duang~~~!!!~~~Duang~~~!!!~~~Duang~~~!!!~~~Duang~~~!!!~~~Duang~~~!!!~~~Duang~~~!!!");
    }
}

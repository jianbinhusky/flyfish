//package file;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by hujb4 on 2016/5/17.
// */
//public class GetGirlFileName {
//    public static void main(String[] args) {
//        List<String> girls = new ArrayList<String>();
//        File file = new File("D://Program Files//MM");
//        if(file.exists()){
//            File[] files = file.listFiles();
//            int count = 0;
//            for (File file1 : files) {
//                String yearMonth = file1.getName();
//                String[] filenames = file1.list();
//                for (String filename : filenames) {
//                    String path = "MM" + "/" + yearMonth + "/" + filename;
//                    System.out.println(path);
//                    count++;
//                }
//            }
//            System.out.println("Total = " +count);
//        }
//    }
//}

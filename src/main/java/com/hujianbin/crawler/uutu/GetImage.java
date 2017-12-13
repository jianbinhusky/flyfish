package com.hujianbin.crawler.uutu;

import org.apache.log4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by hujianbin on 17/12/2.
 */
public class GetImage {
    private static Logger logger = Logger.getLogger(GetImage.class);

    private static String PATH = "/Users/hujianbin/uutuu/";
    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        String url = "http://d.kancaijing.com.cn/attach/2017-12-02/1512187189qHks.jpg";
        byte[] btImg = getImageFromNetByUrl(url);
        if(null != btImg && btImg.length > 0){
            logger.info("读取到：" + btImg.length + " 字节");
            String fileName = "SS.jpg";
            writeImageToDisk(btImg,"", fileName);
        }else{
            logger.warn("没有从该连接获得内容");
        }
    }

    public static void download(String path, String fileName, String url) {
        File file = new File(PATH + path + fileName);
        if (file.exists()) {
            return;
        }
        byte[] btImg = getImageFromNetByUrl(url);
        if (null != btImg && btImg.length > 0) {
            logger.info("Read ：" + btImg.length + " byte" + " from " + url);
            writeImageToDisk(btImg, path ,fileName);
        } else {
            logger.error("Could not download current image " + url);
        }
    }

    /**
     * 将图片写入到磁盘
     * @param img 图片数据流
     * @param fileName 文件保存时的名称
     */
    private static void writeImageToDisk(byte[] img, String path, String fileName){
        try {
            File dictory = new File(PATH + path);
            if (!dictory.exists()) {
                dictory.mkdirs();
            }
            File file = new File(PATH + path + fileName);
            FileOutputStream fops = new FileOutputStream(file);
            fops.write(img);
            fops.flush();
            fops.close();
        } catch (Exception e) {
            logger.error("Write Image To Disk Exception ", e);
        }
    }
    /**
     * 根据地址获得数据的字节流
     * @param strUrl 网络连接地址
     * @return
     */
    private static byte[] getImageFromNetByUrl(String strUrl){
        try {
            URL url = new URL(strUrl);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(10 * 1000);
            InputStream inStream = conn.getInputStream();//通过输入流获取图片数据
            byte[] btImg = readInputStream(inStream);//得到图片的二进制数据
            return btImg;
        } catch (Exception e) {
            logger.error("[Connect Timed Out] Get Image From Net By Url Failure : " + strUrl);
        } finally {

        }
        return null;
    }
    /**
     * 从输入流中获取数据
     * @param inStream 输入流
     * @return
     * @throws Exception
     */
    private static byte[] readInputStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int len = 0;
        while( (len=inStream.read(buffer)) != -1 ){
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }
}

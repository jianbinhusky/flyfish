package com.hujianbin.crawler.uutu;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hujianbin on 17/12/2.
 */
public class ImagesDownLoader implements Runnable {

    private static Logger logger = Logger.getLogger(ImagesDownLoader.class);

    ExecutorService downloadpool = Executors.newFixedThreadPool(6);

    private Girl girl;

    public ImagesDownLoader(Girl girl) {
        this.girl = girl;
    }

    @Override
    public void run() {
        String cdir =  girl.getCategory();
        String dir = girl.getTitle().replaceAll(" ","_");
        try {
            cdir = new String(cdir.getBytes("UTF-8"),"UTF-8");
            dir = new String(dir.getBytes("UTF-8"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            dir = girl.getUrl().substring(girl.getUrl().lastIndexOf("=")+1);
        }
        String path = cdir +  "/" +dir+ "/";
        for (int i = 1; i <= girl.getTotalCount(); i++) {
            String url = girl.getUrl() + "&p=" + i;
            try {
                Document document = Jsoup.connect(url).timeout(60000).get();
                Elements elements2 = document.select("div#wrap > div.dd_top > div.row  div.panel-body img.img-responsive");
                String source = elements2.attr("src");
                logger.info(girl.getTitle() + "<---- Parse ---> " + url);
                String fileName = source.substring(source.lastIndexOf("/")+1, source.length());
                DownloadImageTask task = new DownloadImageTask(path,fileName, source);
                downloadpool.execute(task);
            } catch (Exception e) {
                logger.error(">[Read timed out]  Could not get url : " + url);
            }
        }
    }
}

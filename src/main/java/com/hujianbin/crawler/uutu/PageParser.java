package com.hujianbin.crawler.uutu;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.Vector;
import java.util.concurrent.Callable;

/**
 * Created by hujianbin on 17/12/2.
 */
public class PageParser implements Callable<Elements> {

    private static Logger logger = Logger.getLogger(PageParser.class);

    private String url;

    private Vector<String> pages;

    public PageParser(String url , Vector<String> pages) {
        this.url = url;
        this.pages = pages;
    }
    @Override
    public Elements call() throws Exception {
        try {
            Document doc = Jsoup.connect(url).timeout(10000).get();
            Elements elements = doc.select("div.row.dd_top > div");
            return  elements;
        } catch (Exception e) {
            logger.error("Could not get url : " + url);
            pages.add(url);
        }

        return null;
    }

}

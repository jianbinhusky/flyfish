package com.hujianbin.crawler.uutu;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Vector;
import java.util.concurrent.Callable;

/**
 * Created by hujianbin on 17/12/2.
 */
public class LevelTwoParser implements Callable<Girl> {

    private static Logger logger = Logger.getLogger(LevelTwoParser.class);

    private Girl girl;
    private Vector<Girl> failGirls;

    public LevelTwoParser(Girl girl,Vector<Girl> failGirls) {
        this.girl = girl;
        this.failGirls = failGirls;
    }

    @Override
    public Girl call() throws Exception {
        try {
            parse();
            return girl;
        } catch (Exception e) {
            logger.error("Could not get url : " + girl.getUrl());
            failGirls.add(girl);
        }

        return null;
    }

    private void parse() throws IOException {
        Document idoc = Jsoup.connect(girl.getUrl()).timeout(20000).get();
        //for category
        Elements elements1 = idoc.select("div#wrap > div.dd_top > ol > li > a");
        String categoryUrl = elements1.get(1).attr("href");
        String category = elements1.get(1).text().trim();
        Elements elements2 = idoc.select("div#wrap > div.dd_top > div.row  div.panel-body img.img-responsive");
        Elements elements3 = idoc.select("div#wrap > div.dd_top > div.row  div.page div.page-show > a");
        String currentImgUrl = elements2.attr("src");
        Integer totalCount = Integer.valueOf(elements3.get(elements3.size() - 1 - 1).text().trim());

        String path = category +  "/" + girl.getTitle() + "/";
        
        girl.setCategory(category);
        girl.setTotalCount(totalCount);
        girl.setRelativePath(path);

        for (int i = 1; i <= totalCount; i++) {
            String url = girl.getUrl() + "&p=" + i;
            girl.getImgSrc().add(url);

        }

    }
}

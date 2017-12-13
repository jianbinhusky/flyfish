package com.hujianbin.crawler.uutu;

import org.apache.log4j.Logger;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.concurrent.Callable;

/**
 * Created by hujianbin on 17/12/2.
 */
public class LevelOneParser implements Callable<Girl> {

    private static Logger logger = Logger.getLogger(LevelOneParser.class);

    private Element element;

    private String task;

    public LevelOneParser(Element element , String task) {
        this.element = element;
        this.task = task;
    }

    @Override
    public Girl call() throws Exception {
        Girl girl = new Girl();
        Elements isNew = element.select("div.thumbnail > img.img-new-logo");
        if (task.equalsIgnoreCase("new")) {
            if (isNew != null && isNew.size() > 0) {
                parse(girl);
                logger.info("Is new girl ---> " + element.select("div.thumbnail > a > img").attr("alt"));
            } else {
                girl = null;
                logger.info("Not new girl.");
            }
        } else {
            parse(girl);
        }

        return girl;
    }

    private void parse(Girl girl) {
        String iurl = element.select("div.thumbnail > a").attr("href");
        String title = element.select("div.thumbnail > a > img").attr("alt");
        String thumbnail = element.select("div.thumbnail > a > img").attr("src");

        girl.setUrl(iurl);
        girl.setTitle(title);
        girl.setThumbnail(thumbnail);
    }
}

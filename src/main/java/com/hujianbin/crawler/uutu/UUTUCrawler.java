package com.hujianbin.crawler.uutu;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.*;

/**
 * Created by hujianbin on 17/12/2.
 */
@Component(value = "taskJob")
public class UUTUCrawler {

    private static Logger logger = Logger.getLogger(UUTUCrawler.class);

//    private static String ENTRY_URL = "http://www.uutu.me/index.php?c=New&p=1";
    //30,29,28,27,26,25,16
    private static String ENTRY_URL = "http://www.uutu.me/index.php?c=Cate&cid=27&p=";
    private static String COMMON_URL = "http://www.uutu.me/index.php?c=New&p=";

    private static ExecutorService poolOne = Executors.newFixedThreadPool(4);
    private static ExecutorService poolTwo = Executors.newFixedThreadPool(6);

    static {
        System.setProperty("sun.jnu.encoding","utf-8");
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            throw new Exception("NO arguments entered, please enter [cid] number");
        }
        String url = "http://www.uutu.me/index.php?c=Cate&cid="+args[0] +"&p=";
        if (args.length > 3) {
            url = "http://www.uutu.me/index.php?c=New&p=";
        }
        logger.info("url = " + url);
//        execute(url, args);
    }

    public static void execute() {
        String url = "http://www.uutu.me/index.php?c=New&p=";
        String[] args = {"1","1","1","new"};
        logger.info("[Start] Current Time is : " + new Date());
        long t1 = System.currentTimeMillis();
        Document doc = null;
        try {
            doc = Jsoup.connect(url).timeout(10000).get();
        } catch (IOException e) {
            logger.error("Could not parse entry url doc, connect timeout or error.");
        }
        Elements elements = doc.select("div.page.mt20 > div.page-show > a");
        String totalPageSize = elements.get(elements.size() - 1 - 1).text().trim();
        logger.info("Total page size : " + totalPageSize);

        Vector<String> failPages = new Vector<String>();
        CompletionService<Elements> service = new ExecutorCompletionService<Elements>(poolOne);
        Integer number = Integer.valueOf(totalPageSize);
        int start = 1;
        int sec = 1;
        int end = number.intValue();
        if (args.length > 2) {
            start = Integer.valueOf(args[1]).intValue();
            sec = start;
            end = Integer.valueOf(args[2]).intValue();
        }
        logger.info("Start = " + start);
        logger.info("End = " + end) ;
        for (; start <= end; start++) {
            PageParser pageParserTask = new PageParser(url + start, failPages);
            service.submit(pageParserTask);
            logger.info("submit " + start);
        }
        List<Elements> elementsList = new ArrayList<Elements>();
        for (; sec <= end; sec++) {
            try {
                Elements temp = service.take().get();
                if (temp != null) {
                    elementsList.add(temp);
                }
                logger.info("[ last " + (end - sec) + " ]");
            } catch (InterruptedException e) {
                logger.error(e);
            } catch (ExecutionException e) {
                logger.error(e);
            }
        }

        logger.info("Elements List Size is : " + elementsList.size());
        logger.warn("Have " + failPages.size() + " pages parse fail.");

        long t2 = System.currentTimeMillis();
        logger.info("[Parse Total Page] Current Time is : " + new Date());
        logger.info("Take " + (t2 - t1) / 1000 + " s");

        String task = "all";
        if (args.length > 3) {
            task = args[3];
        }
        logger.info("task is " + task);
        List<Girl> girlList = parseLevelOne(elementsList , task);

        logger.info("Have " + girlList.size() + " girls");
        long t3 = System.currentTimeMillis();
        logger.info("[Level One Parse Complete] Current Time is : " + new Date());
        logger.info("Take " + (t3 - t2) / 1000 + " s");

        Vector<Girl> failGirls = new Vector<Girl>();
        List<Girl> targets = parseLevelTwo(girlList, failGirls);

        int count = 0;
        for (Girl target : targets) {
            count += target.getTotalCount();
        }

        logger.info("Have " + targets.size() + " girls parse successful");
        logger.info("#################################################################################");
        logger.info("#############################   Total " + (count) + " Pictures ##################");
        logger.info("#################################################################################");
        logger.info("Have " + failGirls.size() + " girls parse failure");
        long t4 = System.currentTimeMillis();
        logger.info("[Level Two Parse Complete] Current Time is : " + new Date());
        logger.info("Take " + (t4 - t3) / 1000 + " s");

        List<Girl> totalFailGirls = new ArrayList<Girl>();
//        download(targets, totalFailGirls);
        downloadMulThread(targets, totalFailGirls);

        long t5 = System.currentTimeMillis();
        logger.info("[Download All Images] Current Time is : " + new Date());
        logger.info("Take " + (t5 - t4) / 1000 + " s");

        logger.info("Total use " + (t5 - t1) / 1000 + " s");
    }

    public static List<Girl> parseLevelOne(List<Elements> elementsList , String task) {
        List<Girl> girlList = new ArrayList<Girl>();
        CompletionService<Girl> service1 = new ExecutorCompletionService<Girl>(poolOne);
        for (Elements elements1 : elementsList) {
            for (Element element : elements1) {
                LevelOneParser taskOne = new LevelOneParser(element , task);
                service1.submit(taskOne);
            }
            for (int i = 0; i < elements1.size(); i++) {
                try {
                    Girl girl = service1.take().get();
                    if (girl != null) {
                        girlList.add(girl);
                    }
                } catch (InterruptedException e) {
                    logger.error(e);
                } catch (ExecutionException e) {
                    logger.error(e);
                }
            }
        }

        return  girlList;
    }

    public static List<Girl> parseLevelTwo(List<Girl> girlList , Vector<Girl> failGirls) {
        List<Girl> targets = new ArrayList<Girl>();
        CompletionService<Girl> service2 = new ExecutorCompletionService<Girl>(poolOne);
        for (Girl girl : girlList) {
            LevelTwoParser taskTwo = new LevelTwoParser(girl , failGirls);
            service2.submit(taskTwo);
        }
        for (int i = 0; i < girlList.size(); i++) {
            try {
                Girl girl = service2.take().get();
                if (girl != null) {
                    targets.add(girl);
                }
                logger.info("[ " + (girlList.size() - i) + " ]");
            } catch (InterruptedException e) {
                logger.error(e);
            } catch (ExecutionException e) {
                logger.error(e);
            }
        }

        return targets;
    }

    public static void downloadMulThread(List<Girl> targets , List<Girl> failGirls) {
        for (Girl target : targets) {
            ImagesDownLoader imagesDownLoader = new ImagesDownLoader(target);
            poolTwo.execute(imagesDownLoader);
        }
        logger.info("Waiting ... Waiting ... Waiting ...");

    }

    public static void download(List<Girl> targets , List<Girl> failGirls) {
        for (int k = 0; k < targets.size(); k++) {
            logger.info("#################################################################################");
            logger.info("#############################   Handle "+ (k+1)+ " Girl ##########################");
            logger.info("#################################################################################");
//            String path = targets.get(k).getCategory() +  "/" + targets.get(k).getTitle() + "/";
            Girl girl = targets.get(k);
            String cdir =  girl.getCategory();
            String dir = girl.getTitle().replaceAll(" ","_");
            try {
                cdir = new String(cdir.getBytes("UTF-8"),"UTF-8");
                dir = new String(dir.getBytes("UTF-8"),"UTF-8");
            } catch (UnsupportedEncodingException e) {
                dir = girl.getUrl().substring(girl.getUrl().lastIndexOf("=")+1);
            }
            String path = cdir +  "/" +dir+ "/";
            for (int i = 1; i <= targets.get(k).getTotalCount(); i++) {
                String url = targets.get(k).getUrl() + "&p=" + i;
                try {
                    Document idoc = Jsoup.connect(url).timeout(10000).get();
                    Elements elements2 = idoc.select("div#wrap > div.dd_top > div.row  div.panel-body img.img-responsive");
                    String source = elements2.attr("src");
                    logger.info("Parse ---> " + url);
                    String fileName = source.substring(source.lastIndexOf("/")+1, source.length());
                    DownloadImageTask task = new DownloadImageTask(path,fileName, source);
                    poolTwo.execute(task);
                } catch (Exception e) {
                    logger.error("Could not get url : " + url);
                    failGirls.add(targets.get(k));
                }
            }
        }
    }
}

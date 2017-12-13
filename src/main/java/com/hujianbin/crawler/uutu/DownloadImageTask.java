package com.hujianbin.crawler.uutu;

/**
 * Created by hujianbin on 17/12/3.
 */
public class DownloadImageTask implements Runnable {

    private String path;
    private String fileName;
    private String url;

    public DownloadImageTask(String path, String fileName, String url) {
        this.path = path;
        this.fileName = fileName;
        this.url = url;
    }

    @Override

    public void run() {
        GetImage.download(path, fileName, url);
    }
}

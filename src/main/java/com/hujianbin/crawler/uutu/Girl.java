package com.hujianbin.crawler.uutu;

import lombok.Data;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by hujianbin on 17/11/30.
 */
@Data
public class Girl {
    private String id;
    private String title;
    private String category;
    private String url;
    private String thumbnail;
    private Integer totalCount;
    private String relativePath;
    private ConcurrentLinkedQueue<String> imgSrc = new ConcurrentLinkedQueue<String>();
}

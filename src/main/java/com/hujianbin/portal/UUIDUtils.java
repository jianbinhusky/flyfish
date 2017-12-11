package com.hujianbin.portal;

import java.util.UUID;

/**
 * Created by hujb4 on 2016/5/20.
 */
public class UUIDUtils {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}

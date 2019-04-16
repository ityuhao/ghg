package com.n2o2l.ghg.util;

import com.mzlion.easyokhttp.request.GetRequest;
import okhttp3.HttpUrl;
import okhttp3.Request;

public class HttpGetUtil extends GetRequest {


    /**
     * 构造GET请求对象
     *
     * @param url 请求的URL地址
     */
    public HttpGetUtil(String url) {
        super(url);
    }

}

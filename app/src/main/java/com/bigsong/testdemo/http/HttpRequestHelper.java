package com.bigsong.testdemo.http;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by Administrator on 2016/8/12.
 */
public class HttpRequestHelper {

    private static AsyncHttpClient client;
    private static HttpRequestHelper mInstance;

    private HttpRequestHelper() {
        if (client == null) {
            client = new AsyncHttpClient();
            client.setTimeout(5000);
        }
    }

    public static HttpRequestHelper getInstance() {
        if (mInstance == null) {
            synchronized (HttpRequestHelper.class) {
                if (mInstance == null) {
                    mInstance = new HttpRequestHelper();
                }
            }
        }
        return mInstance;
    }

    public void getHttpRequestAsync(String mRequestURL,
                                    AsyncHttpResponseHandler mHandler) {
        client.get(mRequestURL, mHandler);
    }

    public void postHttpRequestAsync(String mRequestURL, RequestParams mParams,
                                     AsyncHttpResponseHandler mHandler) {
        client.post(mRequestURL, mParams, mHandler);
    }
}

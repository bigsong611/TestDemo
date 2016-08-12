package com.bigsong.testdemo;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.bigsong.testdemo.adapter.NewsFragmentPagerAdapter;
import com.bigsong.testdemo.bean.ChannelBean;
import com.bigsong.testdemo.bean.ChannelJsonEntity;
import com.bigsong.testdemo.fragment.NewsFragment;
import com.bigsong.testdemo.http.HttpRequestHelper;
import com.google.gson.Gson;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private static final String URL = "http://202.108.16.229/cntv/resource/cltv2/channel.jsp?nodeId=442&uuid=147028889447637&clientId=&userId=26";

    private List<ChannelBean> channelBeans;
    private ViewPager mViewPager;
    private List<NewsFragment> fragments = new ArrayList<NewsFragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        mViewPager = (ViewPager) findViewById(R.id.vp_news);
    }

    private void initData() {
        HttpRequestHelper.getInstance().getHttpRequestAsync(URL, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Gson gson = new Gson();
                ChannelJsonEntity channelEntity = gson.fromJson(responseString, ChannelJsonEntity.class);
                channelBeans = channelEntity.getCommonChannel();
                /*for (ChannelBean channelBean : channelBeans){
                    Log.d("Main", channelBean.getName());
                }*/
                for ( ChannelBean channelBean :channelBeans){
                    NewsFragment newsFragment = NewsFragment.newInstance(channelBean);
                    fragments.add(newsFragment);
                }
                NewsFragmentPagerAdapter adapter = new NewsFragmentPagerAdapter(getSupportFragmentManager(),fragments);
                mViewPager.setAdapter(adapter);
            }
        });
    }
}

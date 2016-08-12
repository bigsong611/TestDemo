package com.bigsong.testdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bigsong.testdemo.R;
import com.bigsong.testdemo.adapter.NewsListViewAdapter;
import com.bigsong.testdemo.bean.ChannelBean;
import com.bigsong.testdemo.bean.NewBean;
import com.bigsong.testdemo.bean.NewJsonEntity;
import com.bigsong.testdemo.http.HttpRequestHelper;
import com.google.gson.Gson;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Administrator on 2016/8/12.
 */
public class NewsFragment extends Fragment {

    private static final String ARGUMENT ="argument";
    private ChannelBean channelBean;
//    private TextView tvChannelName;
    private ListView mListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        channelBean = (ChannelBean) bundle.getSerializable(ARGUMENT);
    }

    public static NewsFragment newInstance(ChannelBean channelBean){
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARGUMENT, channelBean);
        NewsFragment newsFragment = new NewsFragment();
        newsFragment.setArguments(bundle);
        return newsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news,container,false);
//        tvChannelName = (TextView) view.findViewById(R.id.tv_channelname);
//        tvChannelName.setText(channelBean.getName());
        mListView = (ListView) view.findViewById(R.id.lv_news);
        initListView();
        return view;
    }

    private void initListView() {
        HttpRequestHelper.getInstance().getHttpRequestAsync(channelBean.getRequestURL(), new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Gson gson = new Gson();
                NewJsonEntity newJsonEntity = gson.fromJson(responseString,NewJsonEntity.class);
                List<NewBean> newBeans = newJsonEntity.getPosterList();
                NewsListViewAdapter adapter = new NewsListViewAdapter(getActivity(),newBeans);
                mListView.setAdapter(adapter);
            }
        });
    }
}

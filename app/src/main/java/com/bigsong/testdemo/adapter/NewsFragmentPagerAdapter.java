package com.bigsong.testdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bigsong.testdemo.fragment.NewsFragment;

import java.util.List;


/**
 * Created by Administrator on 2016/8/12.
 */
public class NewsFragmentPagerAdapter extends FragmentPagerAdapter {

    private FragmentManager fm;
    private List<NewsFragment>  fragments;

    public NewsFragmentPagerAdapter(FragmentManager fm,List<NewsFragment> fragments) {
        super(fm);
        this.fm = fm;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}

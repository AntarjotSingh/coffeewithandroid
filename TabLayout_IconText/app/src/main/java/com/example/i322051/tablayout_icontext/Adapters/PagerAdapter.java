package com.example.i322051.tablayout_icontext.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Antarjot on 7/11/2016.
 */
public class PagerAdapter extends FragmentPagerAdapter {

    /*
    * Arraylist used to contain the fragments and it's respective titles
    * */
    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> fragmentTitleList = new ArrayList<>();

    /*
    * Public Constructor of our PagerAdapter
    * */
    public PagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        //will return 3 as three tabs are added.
        return fragmentList.size();
    }

    //Adds the fragment and it's title. Called in MainActivity to setup the same
    public void addFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        fragmentTitleList.add(title);
    }

    //Retrieves the title of the tab which we defined in MainActivity in setupViewPager() method
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitleList.get(position);
    }
}

package com.example.i322051.tablayout_icontext;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.i322051.tablayout_icontext.Adapters.PagerAdapter;
import com.example.i322051.tablayout_icontext.Fragments.FragmentOne;
import com.example.i322051.tablayout_icontext.Fragments.FragmentThree;
import com.example.i322051.tablayout_icontext.Fragments.FragmentTwo;


public class MainActivity extends AppCompatActivity {

    /*
    * Variables for toolbar, tablayout and Viewpager
    * */
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    /*
    * Defining int array to store the reference to icons for tabs
    * */
    private int[] tabIcons = {
            R.drawable.ic_account_balance,
            R.drawable.ic_add_shopping_cart,
            R.drawable.ic_announcement
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting up Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Setting up ViewPager which helps to navigate between tabs using fragments
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        //Calling method that links different fragments within ViewPager
        setupViewPager(viewPager);

        //Setting up TabLayout with ViewPager
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);

        //Calling Method used to set icons in the tabs
        setupTabIcons();
    }

    //Method used to set icons in the tabs
    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }

    //Method that links different fragments within ViewPager
    private void setupViewPager(ViewPager viewPager) {
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentOne(), "ONE");
        adapter.addFragment(new FragmentTwo(), "TWO");
        adapter.addFragment(new FragmentThree(), "THREE");
        viewPager.setAdapter(adapter);
    }
}

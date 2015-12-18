package com.google.samples.quickstart.signin;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by NILESH on 19-12-2015.
 */
public class PagerAdapter2 extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter2(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                FTabFragment1 tab1 = new FTabFragment1();
                return tab1;
            case 1:
                FTabFragment2 tab2 = new FTabFragment2();
                return tab2;
            case 2:
                FTabFragment3 tab3 = new FTabFragment3();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}

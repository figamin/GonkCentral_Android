package com.figdev.gonkcentraldroid1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Ian Anderson
 * 7/21/19
 */

public class TabAdapter extends FragmentPagerAdapter {

    private int tabNum;

    public TabAdapter(FragmentManager manager, int numOTabs)
    {
        super(manager);
        tabNum = numOTabs;
    }

    @Override
    public Fragment getItem(int pos)
    {
        switch (pos)
        {
            case 0:
                return new StudentInfoTab();
            case 1:
                return new ScheduleTab();
            case 2:
                return new AttendanceTab();
            case 3:
                return new GradesTab();
            default:
                return null;
        }
    }
    @Override
    public int getCount()
    {
        return tabNum;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        switch (position)
        {
            case 0: return "Student Info";
            case 1: return "Schedule";
            case 2: return "Attendance";
            case 3: return "Grades";
            default: return "";
        }
    }
}

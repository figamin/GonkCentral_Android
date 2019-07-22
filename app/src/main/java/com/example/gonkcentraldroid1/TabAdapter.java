package com.example.gonkcentraldroid1;

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
                StudentInfoTab studentInfoTab = new StudentInfoTab();
                return studentInfoTab;
            case 1:
                ScheduleTab scheduleTab = new ScheduleTab();
                return scheduleTab;
            case 2:
                AttendanceTab attendanceTab = new AttendanceTab();
                return attendanceTab;
            case 3:
                GradesTab gradesTab = new GradesTab();
                return gradesTab;
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

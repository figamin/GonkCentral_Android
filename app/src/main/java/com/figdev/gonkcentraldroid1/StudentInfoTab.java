package com.figdev.gonkcentraldroid1;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.List;

/**
 * Ian Anderson
 * 7/21/19
 */

public class StudentInfoTab extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.studentinfotab, container, false);
        new StudentInfoTask(StudentInfoTab.this).execute();
        return view;
    }

    private void studentInfoPlacer(Document info)
    {
        List<String> ageInfo = info.select(".DataMBl").eachText();
        List<String> bioText = info.select(".Datal").eachText();
        TextView box1 = getView().findViewById(R.id.sbox1);
        TextView box2 = getView().findViewById(R.id.sbox2);
        TextView box3 = getView().findViewById(R.id.sbox3);
        TextView box4 = getView().findViewById(R.id.sbox4);
        TextView box5 = getView().findViewById(R.id.sbox5);
        TextView box6 = getView().findViewById(R.id.sbox6);
        TextView box7 = getView().findViewById(R.id.sbox7);
        TextView box8 = getView().findViewById(R.id.sbox8);
        TextView box9 = getView().findViewById(R.id.sbox9);
        TextView box10 = getView().findViewById(R.id.sbox10);
        TextView box11 = getView().findViewById(R.id.sbox11);
        box1.setText(bioText.get(4));
        box2.setText(ageInfo.get(0));
        box3.setText(bioText.get(6));
        box4.setText(bioText.get(7));
        box5.setText(bioText.get(8));
        box6.setText(bioText.get(9));
        box7.setText(bioText.get(10));
        box8.setText(bioText.get(11));
        box9.setText(bioText.get(25));
        box10.setText(bioText.get(44));
        box11.setText(bioText.get(2));
    }
    private static class StudentInfoTask extends AsyncTask<String, Void, Document>{

        private WeakReference<StudentInfoTab> reference;

        StudentInfoTask(StudentInfoTab context)
        {
            reference = new WeakReference<>(context);
        }
        @Override
        protected Document doInBackground(String... strings)
        {
            Document info = null;
            try
            {
                info = Jsoup.parse(new URL("https://ipassweb.harrisschool.solutions/school/nsboro/istudentbio.htm"), 0);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return info;
        }

        @Override
        protected void onPostExecute(Document result)
        {
            StudentInfoTab aliveTab = reference.get();
            if(aliveTab == null)
            {
                return;
            }
            aliveTab.studentInfoPlacer(result);
        }
    }
}
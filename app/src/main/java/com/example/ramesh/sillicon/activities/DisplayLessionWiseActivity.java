package com.example.ramesh.sillicon.activities;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ExpandableListView;

import com.example.ramesh.sillicon.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorCompletionService;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DisplayLessionWiseActivity extends AppCompatActivity {
    @BindView(R.id.displayLessionwiseReport)
    ExpandableListView expandableListView;
    ExpandableListviewAdapter expandableListviewAdapter;
    List<String> headerData = new ArrayList<>();
    HashMap<String, List<String>> childData = new HashMap<>();
    ArrayList<String> firstLession = new ArrayList<>();
    ArrayList<String> secondLession = new ArrayList<>();
    ArrayList<String> thirdLession = new ArrayList<>();
    Typeface teluguTf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_lession_wise);
        ButterKnife.bind(this);
        teluguTf = Typeface.createFromAsset(getAssets(), "fonts/TimmanaRegular.ttf");
        readingData();
        expandableListView.setAdapter(new ExpandableListviewAdapter(this, headerData, childData, teluguTf));
    }

    private void readingData() {
        try {
            headerData.clear();
            childData.clear();
            firstLession.clear();
            secondLession.clear();
            thirdLession.clear();
            headerData.add("మొదటి లెషన్");
            headerData.add("రెండవ లెషన్");
            headerData.add("మూడో లెషన్");

            firstLession.add("అమ్మ ");
            firstLession.add("ఆవు");

            secondLession.add("ఇల్లు  ");
            secondLession.add("ఈగ ");
            thirdLession.add("ఉడుత ");
            thirdLession.add("ఉంగరం");
            childData.put(headerData.get(0), firstLession);
            childData.put(headerData.get(1), secondLession);
            childData.put(headerData.get(2), thirdLession);

        } catch (Exception ex) {

        }
    }


}





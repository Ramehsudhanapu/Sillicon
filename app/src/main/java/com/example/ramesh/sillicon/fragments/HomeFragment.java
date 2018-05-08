package com.example.ramesh.sillicon.fragments;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.ramesh.sillicon.R;
import com.example.ramesh.sillicon.adapters.TeluguLettersDisplayAdapter;
import java.util.Locale;
import butterknife.BindView;
import butterknife.ButterKnife;
@SuppressLint("ValidFragment")
public class HomeFragment extends android.support.v4.app.Fragment {
    Typeface Telugu;
    @BindView(R.id.displayletters_recyclerview)
    RecyclerView displayletters_recyclerview;
    String[] telugu_Alphabets_stores = new String[]{"పుస్తకం1", "పుస్తకం2 ", "పుస్తకం3", "పుస్తకం4", "పుస్తకం5", "పుస్తకం6", "పుస్తకం7", "పుస్తకం1", "పుస్తకం1", "పుస్తకం2 ", "పుస్తకం3", "పుస్తకం4", "పుస్తకం5", "పుస్తకం6", "పుస్తకం7", "పుస్తకం  1"};
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = null;
        try {
            view = inflater.inflate(R.layout.fragment_home, null);
            ButterKnife.bind(this, view);
            Telugu = Typeface.createFromAsset(getActivity().getAssets(), "fonts/TimmanaRegular.ttf");
            displayletters_recyclerview.setLayoutManager(new GridLayoutManager(getContext(), 4));
            displayletters_recyclerview.setAdapter(new TeluguLettersDisplayAdapter(this, telugu_Alphabets_stores, Telugu));
        } catch (Exception ex) {
        }
        return view;
    }
}

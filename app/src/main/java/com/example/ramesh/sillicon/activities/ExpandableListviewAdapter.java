package com.example.ramesh.sillicon.activities;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.ramesh.sillicon.R;

import java.util.HashMap;
import java.util.List;

class ExpandableListviewAdapter extends BaseExpandableListAdapter {
    Context context;
    List<String> _headerData;
    HashMap<String, List<String>> _childData;
    Typeface _teluguTf;
    public ExpandableListviewAdapter(DisplayLessionWiseActivity displayLessionWiseActivity, List<String> headerData, HashMap<String, List<String>> childData, Typeface teluguTf) {
        this.context=displayLessionWiseActivity;
        this._headerData=headerData;
        this._childData=childData;
        this._teluguTf=teluguTf;
    }
    @Override
    public int getGroupCount() {
        return _headerData.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return _childData.get(i).size();
    }
    @Override
    public Object getGroup(int grouposition) {
        return _headerData.get(grouposition);
    }
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return _childData.get(_headerData.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean b, View convertView, ViewGroup viewGroup) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.header_group, null);
        }
        TextView header_txt = (TextView) convertView
                .findViewById(R.id.header_group);
        header_txt.setTypeface(null, Typeface.BOLD);
        header_txt.setText(headerTitle);
        header_txt.setTypeface(_teluguTf);
        return convertView;
    }
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean b, View childview, ViewGroup viewGroup) {
        final String childText = (String) getChild(groupPosition, childPosition);
        if (childview == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            childview = infalInflater.inflate(R.layout.child_list_view, null);
        }
        TextView child_txt = (TextView)  childview
                .findViewById(R.id.child_group);
        child_txt.setTypeface(null, Typeface.BOLD);
        child_txt.setText(childText);
        child_txt.setTypeface(_teluguTf);
        return  childview;

    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}

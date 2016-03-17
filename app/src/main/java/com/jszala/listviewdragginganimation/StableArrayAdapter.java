package com.jszala.listviewdragginganimation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class StableArrayAdapter extends BaseAdapter {

    final int INVALID_ID = -1;

    private Context context;
    private List<String> list;

    private HashMap<String, Integer> mIdMap = new HashMap<>();
    private LayoutInflater inflater;

    public StableArrayAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        for (int i = 0; i < list.size(); ++i) {
            mIdMap.put(list.get(i), i);
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public String getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        if (position < 0 || position >= mIdMap.size()) {
            return INVALID_ID;
        }
        String item = getItem(position);
        return mIdMap.get(item);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getView(int i, View rowView, ViewGroup viewGroup) {
        Holder holder;
        if (rowView == null) {
            holder = new Holder();
            rowView = inflater.inflate(R.layout.text_view, null);
            holder.txtTitle = (TextView) rowView.findViewById(R.id.txtTitle);
            rowView.setTag(holder);
        } else {
            holder = (Holder) rowView.getTag();
        }
        holder.txtTitle.setText(list.get(i));
        return rowView;
    }

    private class Holder {
        public TextView txtTitle;
    }
}

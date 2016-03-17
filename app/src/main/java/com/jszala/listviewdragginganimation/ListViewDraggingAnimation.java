package com.jszala.listviewdragginganimation;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * This application creates a listview where the ordering of the data set
 * can be modified in response to user touch events.
 * <p/>
 * An item in the listview is selected via a long press event and is then
 * moved around by tracking and following the movement of the user's finger.
 * When the item is released, it animates to its new position within the listview.
 */
public class ListViewDraggingAnimation extends Activity {

    private ArrayList<String> mCheeseList;
    private StableArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        mCheeseList = new ArrayList<>();
        for (int i = 0; i < ListItem.sCheeseStrings.length; ++i) {
            mCheeseList.add(ListItem.sCheeseStrings[i]);
        }

        adapter = new StableArrayAdapter(this, mCheeseList);
        DynamicListView listView = (DynamicListView) findViewById(R.id.listview);

        listView.setCheeseList(mCheeseList);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setOnItemDragDropListListener(new OnItemDragDropListListener() {
            @Override
            public void onItemSwap(ArrayList arrayList, int indexOne, int indexTwo) {
                // this method will be called when elements swapped.
                Log.e("index", "indexOne : " + indexOne + ", indexTwo : " + indexTwo);
                String temp = mCheeseList.get(indexOne);
                mCheeseList.set(indexOne, mCheeseList.get(indexTwo));
                mCheeseList.set(indexTwo, temp);
                adapter.notifyDataSetChanged();
            }
        });
        // enable disable drag drop as per need.
        listView.setIsDragDopEnabled(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListViewDraggingAnimation.this, mCheeseList.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

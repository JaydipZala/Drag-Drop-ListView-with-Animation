Drag Drop ListView with Animation
=================================

This is demo app for listview with drag drop animation functionality.

Drag Drop Listener
------------------
```listView.setOnItemDragDropListListener(new OnItemDragDropListListener() {
            @Override
            public void onItemSwap(ArrayList arrayList, int indexOne, int indexTwo) {
                // this method will be called when elements swapped.
                Log.e("index", "indexOne : " + indexOne + ", indexTwo : " + indexTwo);
                String temp = mCheeseList.get(indexOne);
                mCheeseList.set(indexOne, mCheeseList.get(indexTwo));
                mCheeseList.set(indexTwo, temp);
                adapter.notifyDataSetChanged();
            }
        });```


enable/disable Drag Drop as per need
------------------------------------
```listView.setIsDragDopEnabled(true);```
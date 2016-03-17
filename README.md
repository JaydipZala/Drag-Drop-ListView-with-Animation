Drag Drop ListView with Animation
=================================

This is demo app for listview with drag drop animation functionality.

Drag Drop Listener
------------------
```
listView.setOnItemDragDropListListener(new OnItemDragDropListListener() {
            @Override
            public void onItemSwap(int indexOne, int indexTwo) {
                // this method will be called when elements swapped.
                Log.e("index", "indexOne : " + indexOne + ", indexTwo : " + indexTwo);
            }
        });
```


Enable/Disable Drag Drop as per need
------------------------------------
```
listView.setIsDragDopEnabled(true);
```

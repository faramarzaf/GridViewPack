package com.faramarz.tictacdev.gridviewapp.sample3;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.faramarz.tictacdev.gridviewapp.R;

import java.util.ArrayList;

public class GridSample3Activity extends AppCompatActivity {

    public static View.OnClickListener myOnClickListener;
    private static RecyclerView.Adapter adapter;
    private static RecyclerView recyclerView;
    private static ArrayList<Customer3Model> data;
    private static ArrayList<Integer> removedItems;

    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_sample3);

        recyclerView = findViewById(R.id.my_recycler_view3);
        myOnClickListener = new MyOnClickListener(this);
        data = new ArrayList<>();

        linearLayoutManager = new GridLayoutManager(GridSample3Activity.this, 1, RecyclerView.HORIZONTAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        for (int i = 0; i < MyData3.nameArray.length; i++) {
            data.add(new Customer3Model(
                    MyData3.nameArray[i],
                    MyData3.versionArray[i],
                    MyData3.id_[i],
                    MyData3.drawableArray[i]
            ));
        }
        removedItems = new ArrayList<>();
        adapter = new CustomerAdapter3(data);
        recyclerView.setAdapter(adapter);


    }


    public static class MyOnClickListener implements View.OnClickListener {
        private final Context context;

        private MyOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            removeItem(v);
        }

        private void removeItem(View v) {
            int selectedItemPosition = recyclerView.getChildPosition(v);
            RecyclerView.ViewHolder viewHolder = recyclerView.findViewHolderForPosition(selectedItemPosition);
            if (viewHolder != null) {
                TextView textViewName = viewHolder.itemView.findViewById(R.id.textViewName3);
                String selectedName = (String) textViewName.getText();
                int selectedItemId = -1;
                for (int i = 0; i < MyData3.nameArray.length; i++) {
                    if (selectedName.equals(MyData3.nameArray[i])) {
                        selectedItemId = MyData3.id_[i];
                    }
                }
                removedItems.add(selectedItemId);
                data.remove(selectedItemPosition);
                //Toast.makeText(context, selectedName + " Removed", Toast.LENGTH_SHORT).show();
                adapter.notifyItemRemoved(selectedItemPosition);
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.add_item_2) {
            //check if any items to add
            if (removedItems.size() != 0) {
                addRemovedItemToList();
            } else {
                Toast.makeText(this, "Nothing to add", Toast.LENGTH_SHORT).show();
            }
        }
        return true;
    }

    private void addRemovedItemToList() {
        int addItemAtListPosition = 0;
        data.add(addItemAtListPosition, new Customer3Model(
                MyData3.nameArray[removedItems.get(0)],
                MyData3.versionArray[removedItems.get(0)],
                MyData3.id_[removedItems.get(0)],
                MyData3.drawableArray[removedItems.get(0)]));
        adapter.notifyItemInserted(addItemAtListPosition);
        removedItems.remove(0);
    }


}

package com.faramarz.tictacdev.gridviewapp.sample1;

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


public class GridSample1Activity extends AppCompatActivity {

    public static View.OnClickListener myOnClickListener;
    private static RecyclerView.Adapter adapter;
    private static RecyclerView recyclerView;
    private static ArrayList<CustomerModel> data;
    private static ArrayList<Integer> removedItems;

    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_sample1);

        recyclerView = findViewById(R.id.my_recycler_view);
        myOnClickListener = new MyOnClickListener(this);
        data = new ArrayList<>();

        linearLayoutManager = new GridLayoutManager(GridSample1Activity.this, 2, RecyclerView.VERTICAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        for (int i = 0; i < MyData.nameArray.length; i++) {
            data.add(new CustomerModel(
                    MyData.nameArray[i],
                    MyData.versionArray[i],
                    MyData.id_[i],
                    MyData.drawableArray[i]
            ));
        }
        removedItems = new ArrayList<>();
        adapter = new CustomerAdapter(data);
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
                TextView textViewName = viewHolder.itemView.findViewById(R.id.textViewName);
                String selectedName = (String) textViewName.getText();
                int selectedItemId = -1;
                for (int i = 0; i < MyData.nameArray.length; i++) {
                    if (selectedName.equals(MyData.nameArray[i])) {
                        selectedItemId = MyData.id_[i];
                    }
                }
                removedItems.add(selectedItemId);
                data.remove(selectedItemPosition);
                Toast.makeText(context, selectedName + " Removed", Toast.LENGTH_SHORT).show();
                adapter.notifyItemRemoved(selectedItemPosition);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.add_item) {
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
        data.add(addItemAtListPosition, new CustomerModel(
                MyData.nameArray[removedItems.get(0)],
                MyData.versionArray[removedItems.get(0)],
                MyData.id_[removedItems.get(0)],
                MyData.drawableArray[removedItems.get(0)]));
        adapter.notifyItemInserted(addItemAtListPosition);
        removedItems.remove(0);
    }


}



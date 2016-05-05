package com.ananth.bottomsheetsample;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class PersistentBottomSheet extends AppCompatActivity {

    private Toolbar toolbar;
    private BottomSheetBehavior<View> behavior;
    private CoordinatorLayout mCoordinateLayout;
    String[] versions = {"Cupcake", "Donut", "Eclair",
            "Froyo", "Gingerbread", "Honeycomb",
            "Icecream Sandwich", "Jelly Bean", "Kitkat", "Lollipop","Marshmellow"};
    private RecyclerView mVersionsList;
    private SimpleRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persistent_bottom_sheet);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_arrow);
        mVersionsList = (RecyclerView) findViewById(R.id.scrollableview);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(PersistentBottomSheet.this);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Welcome to android", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        mCoordinateLayout=(CoordinatorLayout)findViewById(R.id.main_content);
        View bottomSheet = mCoordinateLayout.findViewById(R.id.bottom_sheet);
        behavior = BottomSheetBehavior.from(bottomSheet);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                // React to state change
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                // React to dragging events
            }
        });

        mVersionsList.setLayoutManager(linearLayoutManager);
        mVersionsList.setHasFixedSize(true);
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < versions.length; i++) {
            list.add(versions[i]);
        }

        adapter = new SimpleRecyclerAdapter(list);
        mVersionsList.setAdapter(adapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return true;
    }
}

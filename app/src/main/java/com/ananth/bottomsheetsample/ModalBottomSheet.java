package com.ananth.bottomsheetsample;

import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.ananth.bottomsheetsample.model.Apps;
import com.ananth.bottomsheetsample.model.ModalSheetAdapter;

import java.util.ArrayList;
import java.util.List;

public class ModalBottomSheet extends AppCompatActivity {

    private Toolbar toolbar;
    private BottomSheetDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modal_bottom_sheet);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_arrow);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createDialog();
            }
        });
    }

    private void createDialog() {
        List<Apps> list = new ArrayList<>();
        list.add(new Apps(R.string.facebook, R.drawable.facebook));
        list.add(new Apps(R.string.googleplus, R.drawable.google_plus));
        list.add(new Apps(R.string.instagram, R.drawable.instagram));
        list.add(new Apps(R.string.linkedin, R.drawable.linkedin));
        list.add(new Apps(R.string.pinterest, R.drawable.pinterest));
        list.add(new Apps(R.string.twitter, R.drawable.twitter));
        list.add(new Apps(R.string.youtube, R.drawable.youtube));
        list.add(new Apps(R.string.spotify, R.drawable.spotify));

        ModalSheetAdapter adapter = new ModalSheetAdapter(list);
        adapter.setOnItemClickListener(new ModalSheetAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ModalSheetAdapter.ItemHolder item, int position) {
                //dismissDialog();
            }
        });

        View view = getLayoutInflater().inflate(R.layout.modal_sheet, null);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setAdapter(adapter);


        dialog = new BottomSheetDialog(this);
        dialog.setContentView(view);
        dialog.show();
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

package com.alfredkondoro.mybookapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.alfredkondoro.mybookapp.Adapter.TitleAdapter;
import com.alfredkondoro.mybookapp.Interface.TitleClickListener;
import com.alfredkondoro.mybookapp.Model.Constants;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Context nContext;
    private ArrayList<String> titleList;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        nContext = MainActivity.this;

        titleList = new ArrayList<> ();
        titleList.add(Constants.TITLEA);
        titleList.add(Constants.TITLEB);
        titleList.add(Constants.TITLEC);
        titleList.add(Constants.TITLED);
        titleList.add(Constants.TITLEE);

        recyclerView = findViewById (R.id.recyview1);
        recyclerView.setHasFixedSize (true);
        LinearLayoutManager layoutManager = new LinearLayoutManager (nContext, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager (layoutManager);

        TitleAdapter titleAdapter = new TitleAdapter (nContext, titleList, new TitleClickListener () {
            @Override
            public void onItemClick(int position) {
                Toast.makeText (nContext, "Title clicker position" + position,Toast.LENGTH_SHORT).show ();
            }
        });
        recyclerView.setAdapter (titleAdapter);

    }
}
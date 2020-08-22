package com.alfredkondoro.mybookapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        titleList.add(Constants.TITLEF);
        titleList.add(Constants.TITLEG);
        titleList.add(Constants.TITLEH);
        titleList.add(Constants.TITLEI);
        titleList.add(Constants.TITLEJ);
        titleList.add(Constants.TITLEK);
        titleList.add(Constants.TITLEL);
        titleList.add(Constants.TITLEM);
        titleList.add(Constants.TITLEN);
        titleList.add(Constants.TITLEO);
        titleList.add(Constants.TITLEP);
        titleList.add(Constants.TITLEQ);
        titleList.add(Constants.TITLER);
        titleList.add(Constants.TITLEZ);
        titleList.add(Constants.TITLET);
        titleList.add(Constants.TITLEU);
        titleList.add(Constants.TITLEV);
        titleList.add(Constants.TITLEW);
        titleList.add(Constants.TITLEX);



        recyclerView = findViewById(R.id.recyview1);
        recyclerView.setHasFixedSize (true);
        LinearLayoutManager layoutManager = new LinearLayoutManager (nContext, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager (layoutManager);

        TitleAdapter titleAdapter = new TitleAdapter (nContext, titleList, new TitleClickListener () {
            @Override
            public void onItemClick(View itemView, int position) {
                Intent detailIntent = new Intent (MainActivity.this, DetailActivity.class);
                detailIntent.putExtra("titles", titleList.get (position));
                startActivity(detailIntent);
            }
        });
        recyclerView.setAdapter (titleAdapter);

    }
}
package com.alfredkondoro.mybookapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alfredkondoro.mybookapp.R;
import com.alfredkondoro.mybookapp.Interface.TitleClickListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.MyviewHolder> {

    private Context nContex;
    private ArrayList<String> titleList;
    private TitleClickListener clickListener;

    public TitleAdapter(Context nContex, ArrayList<String> titleList, TitleClickListener clickListener) {
        this.nContex = nContex;
        this.titleList = titleList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public TitleAdapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from (nContex).inflate (R.layout.title_layout,parent,false);

        final MyviewHolder holder = new MyviewHolder (view);
        view.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                clickListener.onItemClick (holder.getPosition ());
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TitleAdapter.MyviewHolder holder, int i) {
        holder.title.setText(titleList.get (i).replace ("_",""));
    }

    @Override
    public int getItemCount() {
        return titleList.size ();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        public MyviewHolder(@NonNull View itemView) {
            super (itemView);
            title = itemView.findViewById (R.id.title);
        }
    }
}

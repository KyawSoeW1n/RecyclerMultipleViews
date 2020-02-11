package com.example.recyclermultipleview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclermultipleview.R;
import com.example.recyclermultipleview.adapter.RecyclerAdapter;
import com.example.recyclermultipleview.decorator.RecyclerDotLineDecorator;
import com.example.recyclermultipleview.model.Chat;
import com.example.recyclermultipleview.model.Video;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    private RecyclerAdapter recyclerAdapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<Object> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        setUpDecorationForRecyclerView();
        loadData();
    }

    private void loadData() {
        list.add(new Chat("Nurat", "1:00 AM"));
        list.add(new Chat("Wisdom", "2:00 AM"));
        list.add(new Chat("Tope", "3:00 AM"));
        list.add(new Video("Tope", "Lagos", "3:30 AM"));
        list.add(new Chat("Peter", "4:00 AM"));
        list.add(new Chat("Ayomide", "5:00 AM"));
        list.add(new Chat("Korede", "6:00 AM"));
        list.add(new Chat("Wizkid", "7:00 AM"));
        list.add(new Video("Wizkid", "Abuja", "7:05 AM"));
        list.add(new Video("Wizkid", "Abuja", "7:10 AM"));
        list.add(new Chat("Davido", "8:00 AM"));
        list.add(new Chat("Olamide", "9:00 AM"));
        list.add(new Chat("Funke", "10:00 AM"));
        list.add(new Video("Funke", "Sweden", "10:10 AM"));
        list.add(new Chat("Samuel", "11:00 AM"));
        list.add(new Chat("Opeyemi", "12:00 AM"));
        recyclerAdapter.updateData(list);
    }

    private void setUpDecorationForRecyclerView() {
        recyclerAdapter = new RecyclerAdapter(this);
        layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        //dot-line Decorator
//        recyclerView.addItemDecoration(new RecyclerDotLineDecorator(ContextCompat.getDrawable(this, R.drawable.line_dashed)));

        //line decorator
//        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerAdapter);
    }
}

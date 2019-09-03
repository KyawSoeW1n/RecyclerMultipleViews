package com.example.recyclermultipleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    private RecyclerAdapter recyclerAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        ArrayList<Object> list = new ArrayList<>();
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
        recyclerAdapter = new RecyclerAdapter(this, list);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        recyclerView.setAdapter(recyclerAdapter);
    }
}

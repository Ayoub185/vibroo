package com.example.vibro;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Notif extends AppCompatActivity {
    private RecyclerView recyclerView;
    private NotificationAdapter adapter;
    private List<Notification> notifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notif_center);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        notifications = new ArrayList<>();
        // add notifications to the list here

        // sort the notifications based on your desired criteria
        Collections.sort(notifications, new Comparator<Notification>() {
            @Override
            public int compare(Notification n1, Notification n2) {
                // implement your sorting logic here
                return 0;
            }
        });

        adapter = new NotificationAdapter(notifications);
        recyclerView.setAdapter(adapter);
    }
}
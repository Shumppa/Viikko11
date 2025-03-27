package com.example.viikko11;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addContactButton = findViewById(R.id.AddContactActivityButton);
        ImageButton sortAlphabeticallyButton = findViewById(R.id.SortAlphabeticallyButton);
        ImageButton sortByGroupButton = findViewById(R.id.SortByGroupButton);

        recyclerView = findViewById(R.id.ListContactsRV);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ContactAdapter(ContactStorage.getInstance().getContacts());
        recyclerView.setAdapter(adapter);

        addContactButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddContactActivity.class);
            startActivity(intent);
        });

        sortAlphabeticallyButton.setOnClickListener(v -> {
            ContactStorage.getInstance().sortAlphabetically();
            adapter.notifyDataSetChanged();
        });

        sortByGroupButton.setOnClickListener(v -> {
            ContactStorage.getInstance().sortByGroup();
            adapter.notifyDataSetChanged();
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
};


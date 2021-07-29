package com.example.linkedlistimplementation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;

import com.example.linkedlistimplementation.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    static int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<>();
        LinkedListAdapter adapter = new LinkedListAdapter(doublyLinkedList);
        binding.queueRecyclerView.setAdapter(adapter);
        binding.addFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doublyLinkedList.addFirst("Person " + (++counter));
                adapter.notifyDataSetChanged();
            }
        });
        binding.addLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doublyLinkedList.addLast("Person " + (++counter));
                adapter.notifyDataSetChanged();
            }
        });
        binding.first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String element = doublyLinkedList.first();
                Snackbar.make(
                        binding.getRoot(),
                        "The first item in the queue is " + element,
                        Snackbar.LENGTH_LONG
                ).show();
            }
        });
        binding.last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String element = doublyLinkedList.last();
                Snackbar.make(
                        binding.getRoot(),
                        "The last item in the queue is " + element,
                        Snackbar.LENGTH_LONG
                ).show();
            }
        });
        binding.removeFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    doublyLinkedList.removeFirst();
                } catch (NullPointerException npe) {
                    Snackbar.make(binding.getRoot(), "There was a null pointer exception. The linked list is empty", Snackbar.LENGTH_LONG).show();
                }
                adapter.notifyDataSetChanged();
            }
        });
        binding.removeLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    doublyLinkedList.removeLast();
                } catch (NullPointerException npe) {
                    Snackbar.make(binding.getRoot(), "There was a null pointer exception. The linked list is empty", Snackbar.LENGTH_LONG).show();
                }
                adapter.notifyDataSetChanged();
            }
        });
        binding.isEmpty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isEmpty = doublyLinkedList.isEmpty();
                Snackbar.make(binding.getRoot(), Boolean.toString(isEmpty), Snackbar.LENGTH_LONG).show();
            }
        });
        binding.size.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int size = doublyLinkedList.size();
                Snackbar.make(binding.getRoot(), Integer.toString(size), Snackbar.LENGTH_LONG).show();
            }
        });
    }
}
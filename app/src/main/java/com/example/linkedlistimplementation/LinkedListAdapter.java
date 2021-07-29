package com.example.linkedlistimplementation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.linkedlistimplementation.databinding.ListItemPersonBinding;

import java.util.ArrayList;

public class LinkedListAdapter extends RecyclerView.Adapter<LinkedListAdapter.ViewHolder> {
    private DoublyLinkedList<String> linkedList;

    public LinkedListAdapter(DoublyLinkedList<String> linkedList){
        this.linkedList = linkedList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListItemPersonBinding binding = ListItemPersonBinding.inflate(layoutInflater);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ArrayList<DoublyLinkedList.Node<String>> arrayList = linkedList.getArray();
        DoublyLinkedList.Node<String> currentNode = arrayList.get(position);
        holder.bind(currentNode.getElement());
    }


    @Override
    public int getItemCount() {
        return linkedList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ListItemPersonBinding binding;
        public ViewHolder(@NonNull ListItemPersonBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(String name){
            binding.personText.setText(name);
        }
    }
}

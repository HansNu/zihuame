package com.example.zihuame.ui.events;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.zihuame.databinding.FragmentEventsBinding;
import com.example.zihuame.databinding.FragmentHomeBinding;
import com.example.zihuame.ui.Event;
import com.example.zihuame.ui.EventsArrayAdapter;

import java.util.ArrayList;

public class EventsFragment extends Fragment {

    private EventsViewModel eventsViewModel;
    private FragmentEventsBinding binding;

    private Event copy[];

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        eventsViewModel =
                new ViewModelProvider(this).get(EventsViewModel.class);

        binding = FragmentEventsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        final SearchView sv = binding.searchView;
        final ListView lv = binding.listView;

        ArrayList<Event> eventos = new ArrayList<>();

        EventsArrayAdapter adapter = new EventsArrayAdapter(getActivity(), eventos);
        lv.setAdapter(adapter);

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if(!s.isEmpty()) {
                    adapter.getFilter().filter(s);
                }else{
                    adapter.clear();
                    adapter.addAll(copy);
                    adapter.getFilter().filter("");
                }
                adapter.notifyDataSetChanged();
                return false;
            }
        });

        final TextView textView;
        eventsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<Event[]>() {
            @Override
            public void onChanged(Event[] events) {
                adapter.clear();
                adapter.addAll(events);
                adapter.notifyDataSetChanged();
                copy=events;
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
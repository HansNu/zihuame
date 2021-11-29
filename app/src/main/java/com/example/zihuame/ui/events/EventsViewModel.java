package com.example.zihuame.ui.events;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.zihuame.ui.Event;

public class EventsViewModel extends ViewModel {

    private MutableLiveData<Event[]> mEvents;

    public EventsViewModel() {
        mEvents = new MutableLiveData<>();

        Event[] events = {
                new Event("Titulo 1", "Tipo 1", "01/12/2021","Mty"),
                new Event("Titulo 2", "Tipo 2", "02/12/2021","Mty"),
                new Event("Titulo 3", "Tipo 3", "03/12/2021","Mty"),
                new Event("Titulo 4", "Tipo 4", "04/12/2021","Mty"),
                new Event("Titulo 5", "Tipo 5", "05/12/2021","Mty"),
                new Event("Titulo 6", "Tipo 6", "06/12/2021","Mty")
        };

        mEvents.setValue(events);

    }

    public LiveData<Event[]> getText() {
        return mEvents;
    }
}
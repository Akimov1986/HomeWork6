package com.example.homework6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DescriptionOfNotesFragment extends Fragment {
    public static DescriptionOfNotesFragment newInstance(Note currentNote) {
        return new DescriptionOfNotesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_description_of_notes, container, false);
        return view;
    }
}

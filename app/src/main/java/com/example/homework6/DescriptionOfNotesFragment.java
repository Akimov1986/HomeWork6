package com.example.homework6;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DescriptionOfNotesFragment extends Fragment {

    public static String ARG_NOTE = "note";
    private Note note;
    public static DescriptionOfNotesFragment newInstance(Note note) {
        DescriptionOfNotesFragment fragment = new DescriptionOfNotesFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_NOTE, note);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!= null) {
            this.note = getArguments().getParcelable(ARG_NOTE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_description_of_notes, container, false);
        TextView textView = view.findViewById(R.id.textView);
        textView.setText(this.note.getName());

        TypedArray typedArray = getResources().obtainTypedArray(R.array.description);
        return view;

    }
}

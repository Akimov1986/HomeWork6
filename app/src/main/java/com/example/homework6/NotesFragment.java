package com.example.homework6;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class NotesFragment extends Fragment {

    public static String ARG_NOTE = "note";
    Note currentNote;
    boolean isLandScape;


    public static NotesFragment newInstance() {
        return new NotesFragment();

//        Bundle bundle = new Bundle();
//        bundle.putParcelable(ARG_NOTE, note);
//        fragment.setArguments(bundle);
//        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isLandScape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        if (savedInstanceState != null) {
            currentNote = savedInstanceState.getParcelable(ARG_NOTE);
        }
        if (isLandScape)
            if (currentNote != null) {
                showDescriptionOfNotes(currentNote.describeContents());
            } else {
                showDescriptionOfNotes(0);
            }

//        if(getArguments()!= null) {
//            this.note = getArguments().getParcelable(ARG_NOTE);
//        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(ARG_NOTE, currentNote);
        super.onSaveInstanceState(outState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes, container, false);
        LinearLayout linearLayout = (LinearLayout) view;

        String[] notes = getResources().getStringArray(R.array.notes);
        //TextView textView = view.findViewById(R.id.textView);
        //textView.setText(this.note.getName());
        for (int i = 0; i < notes.length; i++) {
            String name = notes[i];

            TextView textView = new TextView(getContext());
            textView.setText(name);
            textView.setTextSize(30);
            linearLayout.addView(textView);
            int finaly = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDescriptionOfNotes(finaly);
                }
            });
        }
        return view;
    }

    private void showDescriptionOfNotes(int index) {
        currentNote = new Note(getResources().getStringArray(R.array.notes)[index]);
        if (isLandScape) {
            showDescriptionOfNotesLand();
        } else {
            showDescriptionOfNotesPort();
        }

    }

    private void showDescriptionOfNotesPort() {
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.notes_container, DescriptionOfNotesFragment.newInstance(currentNote))
                .addToBackStack("")
                .commit();
    }

    private void showDescriptionOfNotesLand() {
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.characteristic_notes_container, DescriptionOfNotesFragment.newInstance(currentNote))
                .commit();
    }


//        TypedArray typedArray = getResources().obtainTypedArray(R.array.Notes);
//        return view;
}


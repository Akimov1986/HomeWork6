package com.example.homework6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        if (getArguments() != null) {
            this.note = getArguments().getParcelable(ARG_NOTE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_description_of_notes, container, false);
        TextView text_notes = view.findViewById(R.id.textView);
        TextView text_discr = view.findViewById(R.id.textViewDescript);
        text_notes.setText(this.note.getName());
        //LinearLayout linearLayout = (LinearLayout) view;


        String[] descriptArr = getResources().getStringArray(R.array.description);
        text_discr.setText(descriptArr[this.note.getDescript()]);
//
//        for (int i = 0; i < description.length; i++) {
//            String dname = description[i];
//
//
//        TextView textView1 = new TextView(getContext());
//        textView1.setText(dname);
//
//        textView1.setTextSize(30);
//        linearLayout.addView(textView);
//    }

        //TypedArray typedArray = getResources().obtainTypedArray(R.array.description);
        return view;
    }

}





package com.example.homework6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.notes_container, NotesFragment.newInstance())
//                .commit();
//        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if(savedInstanceState==null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.notes_container, NotesFragment.newInstance())
                    .commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Fragment backStackFragment = (Fragment)getSupportFragmentManager()
                .findFragmentById(R.id.notes_container);

        if(backStackFragment!=null&&backStackFragment instanceof DescriptionOfNotesFragment) {
            onBackPressed();
        }
    }
}
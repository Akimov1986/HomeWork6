package com.example.homework6;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.notes_container, NotesFragment.newInstance())
                .commit();
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if (savedInstanceState == null) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.characteristic_notes_container, NotesFragment.newInstance())
                        .commit();
            }
        }


//    @Override
//    protected void onResume() {
//        super.onResume();
//        Fragment backStackFragment = (Fragment)getSupportFragmentManager()
//                .findFragmentById(R.id.notes_container);
//
//        if(backStackFragment!=null&&backStackFragment instanceof DescriptionOfNotesFragment) {
//            onBackPressed();
//        }
    }
}
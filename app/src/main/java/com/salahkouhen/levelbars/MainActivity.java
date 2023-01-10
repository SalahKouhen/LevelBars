package com.salahkouhen.levelbars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView skillList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<Skill> skills = new ArrayList<>();
        skills.add(new Skill("Push-ups"));
        skills.add(new Skill("Plank"));
        skills.add(new Skill("Tri Push-up"));

        skillList = findViewById(R.id.listView);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplicationContext(), skills);
        skillList.setAdapter(customBaseAdapter);

    }
}
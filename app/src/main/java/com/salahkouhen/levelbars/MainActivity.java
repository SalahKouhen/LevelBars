package com.salahkouhen.levelbars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView skillList;
    private FloatingActionButton newSkillBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadSkills();

//        skills.add(new Skill("Push-ups"));
//        skills.add(new Skill("Plank"));
//        skills.add(new Skill("Tri Push-up"));
//
//        saveSkills(skills);


        skillList = findViewById(R.id.listView);
        newSkillBtn = findViewById(R.id.newSkillBtn);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplicationContext(), SkillList.getInstance().getList());
        skillList.setAdapter(customBaseAdapter);

        newSkillBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //skills.add(new Skill("New Skill"));

                openSkillEdit();
            }
        });


    }

    @Override
    protected void onResume()
    {
        super.onResume();
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplicationContext(), SkillList.getInstance().getList());
        skillList.setAdapter(customBaseAdapter);
    }

    public void openSkillEdit(){
        Intent intent = new Intent(this,EditSkillActivity.class);
        startActivity(intent);
    }

    public void deleteAllSkills() {
        ArrayList<Skill> skills = new ArrayList<>();
        saveSkills();
    }

    public void saveSkills() {
        SharedPreferences sharedPreferences = getSharedPreferences("SharedPref",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(SkillList.getInstance().getList());
        editor.putString("SkillList", json);
        editor.apply();
    }

    public void loadSkills(){
        SharedPreferences sharedPreferences = getSharedPreferences("SharedPref", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("SkillList", null);
        Type type = new TypeToken<ArrayList<Skill>>() {}.getType();
        SkillList.getInstance().setList(gson.fromJson(json, type));

    }
}
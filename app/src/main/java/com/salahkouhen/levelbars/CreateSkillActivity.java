package com.salahkouhen.levelbars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.util.ArrayList;

public class CreateSkillActivity extends AppCompatActivity {

    public EditText edtSkillName, edtSkillDesc, currentLevel, expDesc, currentExp, reqExp;
    public Button saveBtn, cnclBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_skill);

        edtSkillName = findViewById(R.id.edtSkillName);
        edtSkillDesc = findViewById(R.id.edtSkillDesc);
        currentLevel = findViewById(R.id.currentLevel);
        expDesc = findViewById(R.id.expDesc);
        currentExp = findViewById(R.id.currentExp);
        reqExp = findViewById(R.id.reqExp);

        saveBtn = (Button) findViewById(R.id.saveBtn);
        cnclBtn = (Button) findViewById(R.id.cnclBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Skill newSkill = new Skill(edtSkillName.getText().toString());
                newSkill.setSkillDescription(edtSkillDesc.getText().toString());
                try{
                    newSkill.setLvl(Integer.parseInt(currentLevel.getText().toString()));
                }catch(NumberFormatException nfe){
                    // they put the number in wrong or not at all, don't change it
                }
                newSkill.setExpDescription(expDesc.getText().toString());
                try{
                    newSkill.setExp(Integer.parseInt(currentExp.getText().toString()));
                }catch(NumberFormatException nfe){
                    // they put the number in wrong or not at all, don't change it
                }
                try{
                    newSkill.setExpToNxtLvl(Integer.parseInt(reqExp.getText().toString()));
                }catch(NumberFormatException nfe){
                    // they put the number in wrong or not at all, don't change it
                }

                SkillList.getInstance().getList().add(newSkill);
                saveSkills();
                finish();
            }
        });

        cnclBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    public void saveSkills() {
        SharedPreferences sharedPreferences = getSharedPreferences("SharedPref",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(SkillList.getInstance().getList());
        editor.putString("SkillList", json);
        editor.apply();
    }
}
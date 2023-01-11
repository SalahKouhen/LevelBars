package com.salahkouhen.levelbars;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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


    }
}
package com.salahkouhen.levelbars;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

public class EditSkillActivity extends AppCompatActivity {

    public EditText edtSkillName, edtSkillDesc, currentLevel, expDesc, currentExp, reqExp;
    public Button saveBtn, cnclBtn, delBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_skill);

        edtSkillName = findViewById(R.id.edtSkillName);
        edtSkillDesc = findViewById(R.id.edtSkillDesc);
        currentLevel = findViewById(R.id.currentLevel);
        expDesc = findViewById(R.id.expDesc);
        currentExp = findViewById(R.id.currentExp);
        reqExp = findViewById(R.id.reqExp);

        saveBtn = (Button) findViewById(R.id.saveBtn);
        cnclBtn = (Button) findViewById(R.id.cnclBtn);
        delBtn = (Button) findViewById(R.id.delBtn);

        //fetch the skill we are working with
        Intent intent = getIntent();
        int i = intent.getIntExtra("SkillIndex",0);
        Skill skill = SkillList.getInstance().getList().get(i);

        //populate fields
        edtSkillName.setText(skill.getSkillName());
        if (skill.getSkillDescription() != null) {
            edtSkillDesc.setText(skill.getSkillDescription());
        }
        currentLevel.setText(""+skill.getLvl());
        if (skill.getExpDescription() != null){
            expDesc.setText(skill.getExpDescription());
        }
        currentExp.setText(""+skill.getExp());
        reqExp.setText(""+skill.getExpToNxtLvl());

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                skill.setSkillName(edtSkillName.getText().toString());
                skill.setSkillDescription(edtSkillDesc.getText().toString());
                skill.setLvl(Integer.parseInt(currentLevel.getText().toString()));
                skill.setExpDescription(expDesc.getText().toString());
                skill.setExp(Integer.parseInt(currentExp.getText().toString()));
                skill.setExpToNxtLvl(Integer.parseInt(reqExp.getText().toString()));

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

        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

                builder.setTitle("Confirm");
                builder.setMessage("Are you sure?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        SkillList.getInstance().getList().remove(i);
                        saveSkills();
                        finish();
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // Do nothing
                        dialog.dismiss();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
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
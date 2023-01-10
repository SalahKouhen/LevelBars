package com.salahkouhen.levelbars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EditSkillActivity extends AppCompatActivity {

    private TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_skill);
        Intent intent = getIntent();
        int i = intent.getIntExtra("SkillIndex",0);

        test = findViewById(R.id.skillnametest);
        test.setText(SkillList.getInstance().getList().get(i).getSkillName());

    }
}
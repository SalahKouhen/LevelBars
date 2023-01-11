package com.salahkouhen.levelbars;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class CustomBaseAdapter extends BaseAdapter {

    Context context;
    ArrayList<Skill> skillList;
    LayoutInflater inflater;

    public CustomBaseAdapter(Context context, ArrayList<Skill> skillList) {
        this.context = context;
        this.skillList = skillList;
        inflater = LayoutInflater.from(context);
    }

    public void saveSkills(ArrayList<Skill> skills) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("SharedPref",0); //since getSha.. is a method of context and subclasses (such as activity) but not view need to use context.
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(skills);
        editor.putString("SkillList", json);
        editor.apply();
    }

    public void openSkillEdit(int i){
        Intent intent = new Intent(this.context,EditSkillActivity.class);
        intent.putExtra("SkillIndex", i);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }


    @Override
    public int getCount() {
        return skillList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.activity_skill_list_view, null);
        TextView skillNameLvl = (TextView) view.findViewById(R.id.skillnameandlvl);
        ProgressBar progBar = (ProgressBar) view.findViewById(R.id.progbar);
        TextView expTxt = (TextView) view.findViewById(R.id.exptxt);
        Button addExp = (Button) view.findViewById(R.id.addexpbtn);
        Button minExp = (Button) view.findViewById(R.id.rmvexpbtn);
        Button editSkill = (Button) view.findViewById(R.id.editbtn);
        Skill skill = skillList.get(i);

        skillNameLvl.setText(skill.getSkillName() + " Lvl: " + skill.getLvl());
        expTxt.setText("Exp: " + skill.getExp());
        progBar.setMax(skill.getExpToNxtLvl());
        progBar.setProgress(skill.getExp());


        addExp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                skill.plsExp();

                skillNameLvl.setText(skill.getSkillName() + " Lvl: " + skill.getLvl());
                expTxt.setText("Exp: " + skill.getExp());
                progBar.setProgress(skill.getExp());

                saveSkills(skillList);

            }
        });

        minExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                skill.minExp();

                skillNameLvl.setText(skill.getSkillName() + " Lvl: " + skill.getLvl());
                expTxt.setText("Exp: " + skill.getExp());
                progBar.setProgress(skill.getExp());

                saveSkills(skillList);
            }
        });

        editSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSkillEdit(i);
            }
        });

        return view;
    }
}

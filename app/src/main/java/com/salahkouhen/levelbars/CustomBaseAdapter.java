package com.salahkouhen.levelbars;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

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
        Skill skill = skillList.get(i);

        skillNameLvl.setText(skill.getSkillName() + " Lvl: " + skill.getLvl());
        expTxt.setText("Exp: " + skill.getExp());

        addExp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                skill.setExp(skill.getExp() + 1);
                if (skill.getExp() > 9){
                    skill.setLvl(skill.getLvl() + 1);;
                    skill.setExp(0);
                }

                skillNameLvl.setText(skill.getSkillName() + " Lvl: " + skill.getLvl());
                expTxt.setText("Exp: " + skill.getExp());
                progBar.setProgress(skill.getExp());
            }
        });

        minExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(skill.getExp() < 1 && skill.getLvl() == 0)){
                    skill.setExp(skill.getExp() - 1);
                }
                if (skill.getExp() < 0 && skill.getLvl() > 0){
                    skill.setLvl(skill.getLvl() - 1);
                    skill.setExp(9);
                }

                skillNameLvl.setText(skill.getSkillName() + " Lvl: " + skill.getLvl());
                expTxt.setText("Exp: " + skill.getExp());
                progBar.setProgress(skill.getExp());
            }
        });

        return view;
    }
}

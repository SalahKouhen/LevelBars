package com.salahkouhen.levelbars;

import java.util.ArrayList;

public class SkillList {

    private static SkillList instance;
    private ArrayList<Skill> list;

    public ArrayList<Skill> getList() {
        return list;
    }

    public void setList(ArrayList<Skill> list) {
        this.list = list;
    }

    private SkillList() {}

    public static SkillList getInstance(){
        if (instance == null){
            instance = new SkillList();
        }
        return instance;
    }
}

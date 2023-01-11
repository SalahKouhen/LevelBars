package com.salahkouhen.levelbars;

import android.content.SharedPreferences;

import com.google.gson.Gson;

public class Skill {
    private String skillName;
    private String skillDescription;
    private int expToNxtLvl = 10;
    private int lvl = 0;
    private int exp = 0;
    private String expDescription;

    public void plsExp(){
        this.exp++;
        if (this.exp > this.expToNxtLvl-1){
            this.lvl++;
            this.exp = 0;
        }
    }

    public void minExp(){
        if (!(this.exp < 1 && this.lvl == 0)){
            this.exp --;
        }
        if (this.exp < 0 && this.lvl > 0){
            this.lvl --;
            this.exp = this.expToNxtLvl-1;
        }
    }

    public Skill(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillDescription() {
        return skillDescription;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }

    public int getExpToNxtLvl() {
        return expToNxtLvl;
    }

    public void setExpToNxtLvl(int expToNxtLvl) {
        if (expToNxtLvl < 1){
            this.expToNxtLvl = 1;
        }else {
            this.expToNxtLvl = expToNxtLvl;
        }
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getExpDescription() {
        return expDescription;
    }

    public void setExpDescription(String expDescription) {
        this.expDescription = expDescription;
    }
}

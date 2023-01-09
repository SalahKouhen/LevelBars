package com.salahkouhen.levelbars;

public class Skill {
    private String skillName;
    private String skillDescription;
    private int expToNxtLvl;
    private int lvl;
    private int exp;
    private String expDescription;

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
        this.expToNxtLvl = expToNxtLvl;
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

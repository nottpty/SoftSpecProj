package com.mygdx.game.skills;

import com.mygdx.game.sprites.*;

/**
 * Created by SAS-Maxnot19 on 28/5/2559.
 */
public class Stone_Skill implements SkillHero {
    private int level;
    private boolean check = false;
    private String name;
    private int damage;

    public Stone_Skill(){
        check = false;
        name = "Stone";
        this.level = 0;
        this.damage = 150;
    }

    @Override
    public void doAction(Player player) {
        player.setDmg(damage);
    }

    @Override
    public boolean check() {
        return check;
    }

    @Override
    public void buySkill() {
        this.check = true;
    }

    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public String getText() {
        return this.name+"\nLevel : "+this.level;
    }

    @Override
    public void upLevel() {
        this.damage = (int)(damage*1.5);
        level++;
    }

}

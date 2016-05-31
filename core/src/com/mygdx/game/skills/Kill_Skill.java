package com.mygdx.game.skills;

import com.mygdx.game.sprites.Player;

/**
 * Created by mind on 30/05/2016.
 */
public class Kill_Skill implements SkillHero{
    private boolean check;
    private String name;
    private int level;
    public Kill_Skill(){
        this.check = false;
        this.name = "Kill";
        this.level = 0;
    }
    @Override
    public void doAction(Player player) {

    }

    @Override
    public boolean check() {
        return false;
    }

    @Override
    public void buySkill() {

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

    }

}

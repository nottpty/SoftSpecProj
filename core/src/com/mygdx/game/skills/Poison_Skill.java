package com.mygdx.game.skills;

import com.mygdx.game.sprites.Player;

/**
 * Created by SAS-Maxnot19 on 28/5/2559.
 */
public class Poison_Skill implements SkillHero {
    private boolean check;
    private String name;
    private int level;
    private double dps;

    public Poison_Skill(){
        check = false;
        name = "Poison";
        this.level = 0;
        this.dps = 0.4;
    }
    @Override
    public void doAction(Player player) {
        player.setDmg(player.getDmg()+((int)(player.getDmg()*dps)));
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
        dps += dps+0.1;
        level++;
    }

}

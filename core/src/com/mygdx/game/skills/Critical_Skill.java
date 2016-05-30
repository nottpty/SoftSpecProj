package com.mygdx.game.skills;

import com.mygdx.game.sprites.Player;
/**
 * Created by SAS-Maxnot19 on 28/5/2559.
 */
public class Critical_Skill implements SkillHero {
    private boolean check;
    private String name;
    private int level;
    public Critical_Skill(){
        check = false;
        this.name = "Critical";
        this.level = 0;
    }

    @Override
    public void doAction(Player player) {
        player.setDmg(player.getDmg()*7);
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


}

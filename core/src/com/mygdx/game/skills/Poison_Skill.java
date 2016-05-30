package com.mygdx.game.skills;

import com.mygdx.game.sprites.Player;

/**
 * Created by SAS-Maxnot19 on 28/5/2559.
 */
public class Poison_Skill implements SkillHero {
    private boolean check;
    public Poison_Skill(){
        check = false;
    }
    @Override
    public void doAction(Player player) {
        player.setDmg(player.getDmg()+((int)(player.getDmg()*0.4)));
    }

    @Override
    public boolean check() {
        return check;
    }

    @Override
    public void buySkill() {
        this.check = true;
    }
}

package com.mygdx.game.skills;

import com.mygdx.game.sprites.Player;

/**
 * Created by SAS-Maxnot19 on 28/5/2559.
 */
public class Frost_Skill implements SkillHero {
    private boolean check;

    public Frost_Skill(){
        check = false;
    }

    @Override
    public void doAction(Player player) {
        player.setDmg(200);
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

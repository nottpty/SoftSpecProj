package com.mygdx.game.skills;

import com.mygdx.game.sprites.Player;

/**
 * Created by SAS-Maxnot19 on 28/5/2559.
 */
public class DoubleDamage_Skill implements com.mygdx.game.skills.SkillHero {
    private boolean check;

    public DoubleDamage_Skill(){
        check = false;
    }

    @Override
    public void doAction(Player player) {
        player.setDmg(player.getDmg()*2);
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

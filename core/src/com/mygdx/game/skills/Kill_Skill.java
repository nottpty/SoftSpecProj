package com.mygdx.game.skills;

import com.mygdx.game.sprites.Player;

/**
 * Created by mind on 30/05/2016.
 */
public class Kill_Skill implements SkillHero{
    private boolean check;
    @Override
    public void doAction(Player player) {
        check = false;
    }

    @Override
    public boolean check() {
        return false;
    }

    @Override
    public void buySkill() {

    }
}

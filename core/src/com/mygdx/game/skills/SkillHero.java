package com.mygdx.game.skills;

import com.mygdx.game.sprites.Player;

/**
 * Created by SAS-Maxnot19 on 28/5/2559.
 */
public interface SkillHero {

    public void doAction(Player player);
    public boolean check();
    public void buySkill();
    public String getName();
    public String getText();

}

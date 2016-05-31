package com.mygdx.game.skills;

import com.mygdx.game.sprites.Player;

/**
 * Created by SAS-Maxnot19 on 28/5/2559.
 */
public class DoubleDamage_Skill implements SkillHero {
    private boolean check;
    private int level,price;
    private String name;

    public DoubleDamage_Skill(){
        check = false;
        name = "x2 Damage";
        this.level = 0;
        price = 200;
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
        if(check)
            upgrade();
        if(!check) {
            this.check = true;
            levelUp();
        }
    }
    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public String getText() {
        return this.name+"\nLevel : "+this.level+"\nPrice : "+this.price;
    }

    @Override
    public void levelUp() {
        level++;
        price += (int)(price*1.7);
    }
    public void upgrade() {
        if(check) {
            levelUp();
        }
    }

    @Override
    public int getPrice() {
        return this.price;
    }

}

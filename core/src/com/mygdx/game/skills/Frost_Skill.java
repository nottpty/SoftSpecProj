package com.mygdx.game.skills;

import com.mygdx.game.sprites.Player;

/**
 * Created by SAS-Maxnot19 on 28/5/2559.
 */
public class Frost_Skill implements SkillHero {
    private boolean check;
    private String name;
    private int level,price;
    private int damage;

    public Frost_Skill(){
        check = false;
        name = "Frost";
        this.level = 0;
        this.damage = 200;
        price = 250;
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
        this.damage = (int)(damage*1.5);
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

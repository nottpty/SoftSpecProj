package com.mygdx.game.skills;

import com.mygdx.game.sprites.Player;

/**
 * Created by SAS-Maxnot19 on 28/5/2559.
 */
public class Poison_Skill implements SkillHero {
    private boolean check;
    private String name;
    private int level,price;
    private double dps;

    public Poison_Skill(){
        check = false;
        name = "Poison";
        this.level = 0;
        this.dps = 0.4;
        price = 300;
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
        dps += dps+0.1;
        level++;
        price+=(int)(price*1.7);
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

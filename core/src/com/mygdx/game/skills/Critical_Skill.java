package com.mygdx.game.skills;

import com.mygdx.game.sprites.Player;
/**
 * Created by SAS-Maxnot19 on 28/5/2559.
 */
public class Critical_Skill implements SkillHero {
    private boolean check;
    private String name;
    private int level,price;
    private int critical;
    public Critical_Skill(){
        check = false;
        this.name = "Critical";
        this.level = 0;
        price = 120;
    }

    @Override
    public void doAction(Player player) {
        player.setDmg(player.getDmg()*critical);
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
        this.critical++;
        price += (int)(price*1.7);
        level++;
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

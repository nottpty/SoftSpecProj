package com.mygdx.game.skills;

import com.mygdx.game.sprites.*;

/**
 * Created by SAS-Maxnot19 on 28/5/2559.
 */
public class Stone_Skill implements SkillHero {
    private int level,price;
    private boolean check,canUse;
    private String name;
    private int damage;
    private Player player;
    private float duration;

    public Stone_Skill(Player player){
        check = false;
        this.player = player;
        name = "Stone";
        this.level = 0;
        this.damage = 150;
        price = 170;
    }

    @Override
    public void doAction(Player player) {
        if(canUse){
            player.setDmg(damage);
            canUse = false;
        }
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

    @Override
    public void update(float dt) {
        duration += dt;
        System.out.print(duration);
        if(duration >= 2){
            duration = 0;
            player.setDmg(player.getNormalDamage());
            canUse = true;
        }
    }
}

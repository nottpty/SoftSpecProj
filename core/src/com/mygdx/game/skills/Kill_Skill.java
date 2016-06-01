package com.mygdx.game.skills;

import com.mygdx.game.sprites.Player;

/**
 * Created by mind on 30/05/2016.
 */
public class Kill_Skill implements SkillHero{
    private boolean check,canUse;
    private String name;
    private int level,price;
    private Player player;
    private final int DAMAGE = 999999999;
    private float duration;

    public Kill_Skill(Player player){
        this.check = false;
        this.player = player;
        this.name = "Kill";
        this.level = 0;
        price = 500;
    }
    @Override
    public void doAction(Player player) {
        if(canUse){
            player.setDmg(DAMAGE);
            canUse = false;
        }
    }

    @Override
    public boolean check() {
        return this.check;
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

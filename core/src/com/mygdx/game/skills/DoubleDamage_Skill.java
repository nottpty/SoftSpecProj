package com.mygdx.game.skills;

import com.mygdx.game.sprites.Player;

/**
 * Created by SAS-Maxnot19 on 28/5/2559.
 */
public class DoubleDamage_Skill implements SkillHero {
    private boolean check,canUse;
    private int level,price;
    private String name;
    private Player player;
    private float duration;
    private int cooldown;

    public DoubleDamage_Skill(Player player){
        canUse = true;
        check = false;
        this.player = player;
        name = "x2 Damage";
        this.level = 0;
        price = 400;
        duration = 0;
        cooldown = 90;
    }

    @Override
    public void doAction(Player player) {
        if(canUse) {
            player.setDmg(player.getDmg() * 2);
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
        level++;
        cooldown -= 5;
        price += (int)(price*1.2);
    }
    public void upgrade() {
        if(check) {
            levelUp();
        }
    }

    public boolean canUse(){
        return canUse;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    public void update(float dt){
        duration += dt;
        if(duration >= 10){
            player.setDmg(player.getNormalDamage());
            checkCooldown();
        }
    }

    public void checkCooldown(){
        if(duration >= cooldown) {
            duration = 0;
            canUse = true;
        }
    }
}

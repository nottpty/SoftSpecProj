package com.mygdx.game.skills;

import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.sprites.Player;
/**
 * Created by SAS-Maxnot19 on 28/5/2559.
 */
public class Critical_Skill implements SkillHero {
    private boolean check,canUse;
    private String name;
    private int level,price;
    private int critical;
    private float duration;
    private Player player;
    public Critical_Skill(Player player){
        check = false;
        canUse = true;
        this.player = player;
        this.name = "Critical";
        this.level = 0;
        price = 400;
        critical = 7;
        duration = 0;
    }

    @Override
    public void doAction(Player player) {
        if(canUse) {
            player.setDmg(player.getDmg() * critical);
            canUse = false;
        }
        System.out.print(player.getDmg()+"xxxx");
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

    public void update(float dt){
        duration += dt;
        System.out.print(duration);
        if(duration >= 10){
            duration = 0;
            player.setDmg(player.getNormalDamage());
            canUse = true;
        }
    }

}

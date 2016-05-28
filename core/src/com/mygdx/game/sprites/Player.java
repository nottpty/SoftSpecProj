package com.mygdx.game.sprites;

import java.util.List;
import java.util.Map;

/**
 * Created by tannatanon on 5/28/2016 AD.
 */
public class Player {
    private int dmg;
    private List<SkillHero> skillHeros;

    public Player(int dmg){
        this.dmg = dmg;
        skillHeros.add(new Critical_Skill());
        skillHeros.add(new DoubleDamage_skill());
        skillHeros.add(new Frost_skill());
        skillHeros.add(new Poison_skill());
        skillHeros.add(new Stone_skill());
    }

    public int getDmg(){
        return dmg;
    }

    public void setDmg(int dmg) { this.dmg = dmg; }

    public void useSkill(int index){
        if(checkSkill(index)){
            skillHeros.get(index).doAction(this);
        }
    }

    public boolean checkSkill(int index){
        return skillHeros.get(index).check();
    }

    public void buySkill(int index){
        skillHeros.get(index).buySkill();
    }

    public void upDmg(){
        this.dmg = dmg+((int)(dmg*0.5));
    }

}

package com.mygdx.game.sprites;

import com.mygdx.game.skills.Critical_Skill;
import com.mygdx.game.skills.DoubleDamage_Skill;
import com.mygdx.game.skills.Frost_Skill;
import com.mygdx.game.skills.Kill_Skill;
import com.mygdx.game.skills.Poison_Skill;
import com.mygdx.game.skills.SkillHero;
import com.mygdx.game.skills.Stone_Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tannatanon on 5/28/2016 AD.
 */
public class Player {
    private int dmg,money;
    private List<SkillHero> skillHeros;
    private FriendFactory friendFactory;
    private int normalDamage;


    public Player(int dmg){
        skillHeros = new ArrayList<SkillHero>();
        friendFactory = new FriendFactory();
        this.dmg = dmg;
        buildSkill();
        buildFriend();
        money = 0;
        normalDamage = dmg;
    }

    public void buildSkill(){
        skillHeros.add(new DoubleDamage_Skill(this));
        skillHeros.add(new Critical_Skill(this));
        skillHeros.add(new Stone_Skill(this));
        skillHeros.add(new Poison_Skill(this));
        skillHeros.add(new Frost_Skill(this));
        skillHeros.add(new Kill_Skill(this));

    }
    public void buildFriend(){
        friendFactory.initList();
    }
    public int getDmg(){
        return dmg;
    }
    public void minusMoney(int price){
        this.money = money-price;
    }
    public void addMoney(int money){ this.money += money; }

    public int getMoney(){return this.money;}

    public int getNormalDamage(){
        return normalDamage;
    }

    public void setDmg(int dmg) { this.dmg = dmg; }

    public void useSkill(int index){
        if(checkSkill(index)){
            skillHeros.get(index).doAction(this);
        }
    }

    public List<SkillHero> getSkillList(){return this.skillHeros;};

    public FriendFactory getFriendFactory(){
        return this.friendFactory;
    }

    public boolean checkSkill(int index){
        return skillHeros.get(index).check();
    }

    public void buySkill(int index){
        skillHeros.get(index).buySkill();
    }

    public void upLevelSkill(int index) {
        skillHeros.get(index).levelUp();
    }

    public void upDmg(){
        this.dmg = dmg+((int)(dmg*0.5));
        this.normalDamage = dmg;
    }

    public void updateSkillList(float dt){
        for(SkillHero skill : skillHeros){
            skill.update(dt);
        }
    }

}

package com.mygdx.game.sprites;

import com.mygdx.game.friends.Aragorn;
import com.mygdx.game.friends.Frodo;
import com.mygdx.game.friends.Gandalf;
import com.mygdx.game.friends.Gimli;
import com.mygdx.game.friends.Legolas;
import com.mygdx.game.friends.MyFriend;
import com.mygdx.game.friends.Saruman;
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
    private int dmg;
    private List<SkillHero> skillHeros;
    private List<MyFriend> friendList;


    public Player(int dmg){
        skillHeros = new ArrayList<SkillHero>();
        friendList = new ArrayList<MyFriend>();
        this.dmg = dmg;
        buildSkill();
        buildFriend();
    }

    public void buildSkill(){
        skillHeros.add(new DoubleDamage_Skill());
        skillHeros.add(new Critical_Skill());
        skillHeros.add(new Stone_Skill());
        skillHeros.add(new Poison_Skill());
        skillHeros.add(new Frost_Skill());
        skillHeros.add(new Kill_Skill());
        skillHeros.add(new Kill_Skill());

    }
    public void buildFriend(){
        friendList.add(new Saruman());
        friendList.add(new Frodo());
        friendList.add(new Gandalf());
        friendList.add(new Aragorn());
        friendList.add(new Gimli());
        friendList.add(new Legolas());

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

    public List<SkillHero> getSkillList(){return this.skillHeros;};
    public List<MyFriend> getFriendList(){return this.friendList;};

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

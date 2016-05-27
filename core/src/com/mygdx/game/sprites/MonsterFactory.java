package com.mygdx.game.sprites;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mind on 27/05/2016.
 */
public class MonsterFactory {

    List<Monsters> monstersList;

    public MonsterFactory(){
        monstersList = new ArrayList<Monsters>();
        createMonsterList();
    }

    public void createMonsterList(){
        for(int i = 1;i <= 10;i++){
            Monsters monster = new Monsters(i,50*i);
            monstersList.add(monster);
        }
    }

    public Monsters createMonster(int index){
        return monstersList.get(index);
    }
}

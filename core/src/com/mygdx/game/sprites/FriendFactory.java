package com.mygdx.game.sprites;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tannatanon on 5/30/2016 AD.
 */
public class FriendFactory {

    List<Friend> friendList;

    public FriendFactory(){
        friendList = new ArrayList<Friend>();
        initList();
    }

    public void initList(){
        for(int i = 0;i <= 5;i++){
            Friend friend = new Friend(i+1);
            friendList.add(friend);
        }
    }

    public Friend getFriend(int index){
        return friendList.get(index);
    }

    public void upgrade(int index,int dmg){
        friendList.get(index).setDmg(dmg);
    }

    public void bought(int index){
        friendList.get(index).bought();
    }
}

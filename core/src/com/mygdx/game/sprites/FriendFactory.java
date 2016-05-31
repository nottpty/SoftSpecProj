package com.mygdx.game.sprites;

import com.mygdx.game.friends.Aragorn;
import com.mygdx.game.friends.Frodo;
import com.mygdx.game.friends.Gandalf;
import com.mygdx.game.friends.Gimli;
import com.mygdx.game.friends.Legolas;
import com.mygdx.game.friends.MyFriend;
import com.mygdx.game.friends.Saruman;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tannatanon on 5/30/2016 AD.
 */
public class FriendFactory {

    List<MyFriend> friendList;

    public FriendFactory(){
        friendList = new ArrayList<MyFriend>();
        initList();
    }

    public void initList(){
        friendList.add(new Saruman());
        friendList.add(new Frodo());
        friendList.add(new Gandalf());
        friendList.add(new Aragorn());
        friendList.add(new Gimli());
        friendList.add(new Legolas());
    }

    public MyFriend getFriend(int index){
        return friendList.get(index);
    }

    public void upgrade(int index,int dmg){
        friendList.get(index).setDamage(dmg);
    }

    public void bought(int index){
        friendList.get(index).bought();
    }
}

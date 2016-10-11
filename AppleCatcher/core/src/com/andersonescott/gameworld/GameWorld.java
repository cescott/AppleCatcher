package com.andersonescott.gameworld;


import com.andersonescott.Apple;
import com.andersonescott.Player;

import java.util.ArrayList;

public class GameWorld {

    protected ArrayList<Apple> apples= new ArrayList<Apple>();
    protected Player player;

    public GameWorld(){
        player = new Player(new double[] {300, 0}, 0);
        apples.add(new Apple(new double[] {(Math.random()*740), 600}));
    }

    public void update(float delta){
        //update player
        player.update(delta);
        //update all the apples
        for (int i=0; i<apples.size();i++){
            apples.get(i).update(delta);
        }
    }

    public Player getPlayer(){
        return player;
    }

    public ArrayList<Apple> getApples(){
        return apples;
    }

}

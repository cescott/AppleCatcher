package com.andersonescott.gameworld;


import com.andersonescott.Apple;
import com.andersonescott.Player;

public class GameWorld {

    protected Apple apple;
    protected Player player;

    public GameWorld(){
        player = new Player(new double[] {300, 0}, 0);
        apple = new Apple(new double[] {(Math.random()*800), 600});
    }
    public void update(float delta){
        player.update(delta);

    }
}

package com.andersonescott.gameworld;


import com.andersonescott.objects.Apple;
import com.andersonescott.objects.Player;

import java.util.ArrayList;

public class GameWorld {

    protected ArrayList<Apple> apples= new ArrayList<Apple>();
    protected Player player;
    protected int score;
    protected int counter;

    public GameWorld(){
        player = new Player(new double[] {350, 0}, 0);
        score = 0;
    }

    public void update(float delta){
        //update player
        player.update(delta);
        //update all the apples
        if (appleCount()) {
            apples.add(new Apple(new double[]{(Math.random() * 700) + 10, 520}));
        }
        for (int i=0; i<apples.size();i++){
            apples.get(i).update(delta);
        }
        //update collisions
        collisionUpdate();
    }

    public Player getPlayer(){
        return player;
    }

    public ArrayList<Apple> getApples(){
        return apples;
    }

    public boolean appleCount() {
        counter++;
        if ((double)counter/30 >= (20/(score + 5)) + 0.25) {
            counter = 0;
            return true;
        }
        return false;
    }

    public void collisionUpdate() {
        for (int i = 0; i < apples.size(); i++) {
            if ((apples.get(i).x() <= 0 && apples.get(i).getVelocity()[0] < 0)
                    || (apples.get(i).x() >= 720 && apples.get(i).getVelocity()[0] > 0)) {
                apples.get(i).setVelocity(new double[]{apples.get(i).getVelocity()[0] * -1, apples.get(i).getVelocity()[1]});
            }
            if (apples.get(i).y() <= 2) {
                apples.remove(i);
            }
        }
    }

}

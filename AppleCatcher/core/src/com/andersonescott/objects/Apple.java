package com.andersonescott.objects;

import com.badlogic.gdx.graphics.Texture;

public class Apple extends Entity {

    public Apple(double[] tempCoords){

        super(tempCoords);
        image = new Texture("applecatcher_apple.png");
        acceleration = new double[]{0, -1200};
        velocity = new double[]{Math.random()*200 - 100, 200};//this adds the cool bit of random movement when the apple spawns
    }

}

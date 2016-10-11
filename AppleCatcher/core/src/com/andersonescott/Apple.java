package com.andersonescott;

import com.badlogic.gdx.graphics.Texture;

public class Apple extends Entity{

    static int counter;

    public Apple(double[] tempCoords){
        super(tempCoords);
        image = new Texture("applecatcher_apple.png");
        acceleration = new double[]{0, -400};
    }



}

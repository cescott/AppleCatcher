package com.andersonescott;

import com.badlogic.gdx.graphics.Texture;

public class Apple extends Entity{

    public Apple(double[] tempCoords, double[] tempVelocity){
        super(tempCoords, tempVelocity);
        image = new Texture("apple.jpg");
    }

}

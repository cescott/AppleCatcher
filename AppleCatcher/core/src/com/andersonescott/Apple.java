package com.andersonescott;

import com.badlogic.gdx.graphics.Texture;

public class Apple extends Entity{

    public Apple(double[] tempCoords){
        super(tempCoords);
        image = new Texture("applecatcher_apple.jpg");
        acceleration = new double[]{0, 400};
    }

}

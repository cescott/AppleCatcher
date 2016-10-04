package com.andersonescott;

import com.badlogic.gdx.graphics.Texture;

public abstract class Entity {
    protected double[] coords = new double[2];
    protected double[] velocity = new double[2];
    protected Texture image;
    public Entity (double[] tempCoords, double[] tempVelocity){
        coords = tempCoords;
        velocity = tempVelocity;
    }

    public double x() {
        return coords[0];
    }

    public double y(){
        return coords[1];
    }

    public void setCoords(double[] coords) {
        this.coords = coords;
    }

    public int[] getVelocity() {
        return new int[] {(int)velocity[0], (int)velocity[1]};
    }

    public void setVelocity(double[] velocity) {
        this.velocity = velocity;
    }

    public Texture getImage(){
        return image;
    }
}

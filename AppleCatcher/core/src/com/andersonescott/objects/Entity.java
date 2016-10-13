package com.andersonescott.objects;

import com.badlogic.gdx.graphics.Texture;

public abstract class Entity {
    protected double[] coords = new double[2];
    protected double[] velocity = new double[2];
    protected double[] acceleration = new double[2];
    protected Texture image;

    public Entity (double[] tempCoords){
        coords = tempCoords;
    }

    public void update(float delta){
        velocity[0] = velocity[0]+(acceleration[0]*delta);
        velocity[1] = velocity[1]+(acceleration[1]*delta);

        coords[0] += velocity[0]*delta;
        coords[1] += velocity[1]*delta;
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

    public double[] getVelocity() {
        return velocity;
    }

    public void setVelocity(double[] velocity) {
        this.velocity = velocity;
    }

    public double[] getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double[] accel) {
        acceleration = accel;
    }

    public Texture getImage(){
        return image;
    }
}

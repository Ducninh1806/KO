package io.github.ducninh.ko.world.sprites.fighters.power.impl;

import com.jogamp.opengl.util.texture.Texture;
import io.github.ducninh.ko.graphics.Graphics;
import io.github.ducninh.ko.graphics.Renderer;
import io.github.ducninh.ko.world.World;
import io.github.ducninh.ko.world.sprites.fighters.power.AbstractPowerup;
import io.github.ducninh.ko.engine.GameLoop;

/**
 * @author ducninh1806
 */
public class PowerupBee extends AbstractPowerup {

    public PowerupBee(float x, float y, int width, int height) {
        super(x, y, width, height);
    }

    public PowerupBee(float x, float y, int width, int height, Texture texture) {
        this(x,y,width,height);
        currentTexture = texture;
    }

    @Override
    public void update() {
        float xIn = 0;
        x+= --xIn * movementSpeed * GameLoop.getDelta();

        if(tookHit || x < -(Renderer.tileSize / 2 + 0.5f)){
            World.removeGameObject(this);
        }
    }

    @Override
    public void render() {
        Graphics.createObjectTexture(currentTexture,x,y,0.8f,0.8f,180);
    }

    @Override
    public String toString() {
        return "PowerupBee";
    }
}

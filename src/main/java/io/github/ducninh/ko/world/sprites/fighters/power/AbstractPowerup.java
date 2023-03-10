package io.github.ducninh.ko.world.sprites.fighters.power;

import io.github.ducninh.ko.graphics.Renderer;
import io.github.ducninh.ko.inputs.KeyEventListener;
import io.github.ducninh.ko.world.World;
import io.github.ducninh.ko.world.sprites.BasicGameObject;
import io.github.ducninh.ko.world.sprites.fighters.AbstractFighter;

/**
 * @author ducninh1806
 */
public abstract class AbstractPowerup extends BasicGameObject {

    protected float movementSpeed = 6;
    protected AbstractFighter enemy = null;
    protected AbstractFighter owner = null;
    protected boolean tookHit = false;

    public AbstractPowerup(float x, float y, int width, int height) {
        super(x, y, width, height);
    }

    public AbstractFighter getEnemy() {
        return enemy;
    }

    public void setEnemy(AbstractFighter enemy) {
        this.enemy = enemy;
    }

    public void setOwner(AbstractFighter owner) {
        this.owner = owner;
    }

    @Override
    public void collided() {
        if(this.x > enemy.getX() - 1 && this.x < enemy.getX() + 1 && this.y > enemy.getY()-0.4f && this.y < enemy.getY() + 0.4f) {
            enemy.setCurrentAnimation(enemy.getAnimations().get("hit"));
            enemy.setHealth(enemy.getHealth() - 10);
            this.currentTexture = owner.getPowerHitTexture();
            tookHit = true;
            if(enemy.getHealth() <= 0) {
                World.setWinner(owner);
                enemy.setDefeated(true);
                KeyEventListener.clearKeys();
                Renderer.getGLWindow().removeKeyListener(Renderer.getGLWindow().getKeyListener(0));
            }
        }
    }

}

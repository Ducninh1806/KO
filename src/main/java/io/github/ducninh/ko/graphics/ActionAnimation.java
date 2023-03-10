package io.github.ducninh.ko.graphics;

import com.jogamp.opengl.util.texture.Texture;
import io.github.ducninh.ko.world.sprites.fighters.AbstractFighter;

import java.util.List;

/**
 * @author ducninh1806
 */
public class ActionAnimation extends Animation {

    private AbstractFighter registeredFighter = null;

    public ActionAnimation(AbstractFighter registeredFighter) {
        this.registeredFighter = registeredFighter;
    }

    public ActionAnimation(List<Texture> sprites, AbstractFighter registeredFighter) {
        super(sprites);
        this.registeredFighter = registeredFighter;
    }

    public ActionAnimation() {
        currentFrame = 2;
    }

    public void setRegisteredFighter(AbstractFighter registeredFighter) {
        this.registeredFighter = registeredFighter;
    }

    @Override
    public void play() {
        long currentTime = System.nanoTime();

        if(currentTime > lastFrameTime + (1000000000/(getFps()))) {
            currentFrame++;

            if(currentFrame >= sprites.size()) {
                currentFrame = 0;
                registeredFighter.setCurrentAnimation(registeredFighter.getAnimations().get("idle"));
            }

            lastFrameTime = currentTime;
        }
    }
}

package io.github.ducninh.ko.world.sprites.fighters;

/**
 * @author ducninh1806
 */
public interface Fighter {
    void lowPunch();
    void lowKick();
    void highKick();
    void highPunch();
    void block();

    void jump();
    void crouch();
    void move(boolean isMovingRight);

    int getHealth();

}

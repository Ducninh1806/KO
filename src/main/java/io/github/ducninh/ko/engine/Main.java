package io.github.ducninh.ko.engine;

import io.github.ducninh.ko.graphics.Renderer;

/**
 * @author ducninh1806
 */
public class Main {
    public static void main(String[] args) {
        Renderer.init();
        GameLoop.getInstance().start();
    }
}

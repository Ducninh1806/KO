package io.github.ducninh.ko.resources;

import io.github.ducninh.ko.graphics.Renderer;

/**
 * @author ducninh1806
 */
public class UnitsConverter {
    public static float convertWidth(float width) {
        return width / Renderer.tileSize;
    }

    public static float convertHeight(float height) {
        return height / Renderer.vTileSize;
    }

}

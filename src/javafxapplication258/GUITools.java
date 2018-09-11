/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication258;

import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.ZoomEvent;

/**
 *
 * @author blj0011
 */
public class GUITools
{

    /**
     * Allow to zoom/scale any node with pivot at scene (x,y) coordinates.
     *
     * @param node
     * @param factor
     * @param delta
     * @param x
     * @param y
     */
    public static void zoom(Node node, double factor, double x, double y)
    {
        double oldScale = node.getScaleX();
        double scale = oldScale * factor;
        if (scale < 0.05) {
            scale = 0.05;
        }
        if (scale > 50) {
            scale = 50;
        }
        node.setScaleX(scale);
        node.setScaleY(scale);

        double f = (scale / oldScale) - 1;
        Bounds bounds = node.localToScene(node.getBoundsInLocal());
        double dx = (x - (bounds.getWidth() / 2 + bounds.getMinX()));
        double dy = (y - (bounds.getHeight() / 2 + bounds.getMinY()));

        node.setTranslateX(node.getTranslateX() - f * dx);
        node.setTranslateY(node.getTranslateY() - f * dy);
    }

    public static void zoom(Node node, ScrollEvent event)
    {
        zoom(node, Math.pow(1.01, event.getDeltaY()), event.getSceneX(), event.getSceneY());
    }

    public static void zoom(Node node, ZoomEvent event)
    {
        zoom(node, event.getZoomFactor(), event.getSceneX(), event.getSceneY());
    }
}

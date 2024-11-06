package ru.vsu.cs.dorofeyeva_s_v;

import java.awt.*;
import java.awt.geom.*;

public class Laptop {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public Laptop(final int x, final int y, final int width, final int height, final Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    void draw(final Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        g.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(color);


        //экран
        int screenX = (int)(x + width * 0.05);
        int screenY = y;
        int screenWidth = (int)(width * 0.9);
        int screenHeight = (int)(height * 0.93);
        RoundRectangle2D.Double screen1 = new RoundRectangle2D.Double(screenX, screenY, screenWidth, screenHeight, 7, 7);
        g.draw(screen1);
        RoundRectangle2D.Double screen2 = new RoundRectangle2D.Double(screenX + screenWidth * 0.03, screenY + screenWidth * 0.03, screenWidth * 0.94, screenHeight - screenWidth * 0.06, 7, 7);
        g.draw(screen2);


        //окно
        int windowX = (int)(x + screenWidth * 0.2);
        int windowY = (int)(y + screenHeight * 0.25);
        int windowWidth = (int)(screenWidth * 0.6);
        int windowHeight = (int)(screenHeight * 0.5);
        RoundRectangle2D.Double window = new RoundRectangle2D.Double(windowX, windowY, windowWidth, windowHeight, 7, 7);
        g.draw(window);


        //содержимое окна
        Ellipse2D.Double point1 = new Ellipse2D.Double(windowX + windowWidth * 0.04, windowY + windowHeight * 0.08, 3, 3);
        g.draw(point1);
        g.fill(point1);
        Ellipse2D.Double point2 = new Ellipse2D.Double(windowX + windowWidth * 0.1, windowY + windowHeight * 0.08, 3, 3);
        g.draw(point2);
        g.fill(point2);
        Ellipse2D.Double point3 = new Ellipse2D.Double(windowX + windowWidth * 0.16, windowY + windowHeight * 0.08, 3, 3);
        g.draw(point3);
        g.fill(point3);
        g.draw(new Line2D.Double(windowX + windowWidth * 0.33, windowY + windowHeight * 0.22, windowX + windowWidth * 0.9, windowY + windowHeight * 0.22));
        g.draw(new Line2D.Double(windowX + windowWidth * 0.1, windowY + windowHeight * 0.4, windowX + windowWidth * 0.4, windowY + windowHeight * 0.4));
        g.draw(new Line2D.Double(windowX + windowWidth * 0.1, windowY + windowHeight * 0.6, windowX + windowWidth * 0.4, windowY + windowHeight * 0.6));
        g.draw(new Line2D.Double(windowX + windowWidth * 0.1, windowY + windowHeight * 0.8, windowX + windowWidth * 0.4, windowY + windowHeight * 0.8));


        //низ
        int footingX = x;
        int footingY = y + screenHeight;
        int footingWidth = width;
        int footingHeight = height - screenHeight;
        int[] footingXs = new int[] {footingX + footingWidth, footingX, (int)(footingX + 0.03 * footingWidth), (int)(footingX + 0.97 * footingWidth)};
        int[] footingYs = new int[] {footingY, footingY, footingY + footingHeight, footingY + footingHeight};
        Polygon footing = new Polygon(footingXs, footingYs, 4);
        g.draw(footing);


        int[] touchpadXs = new int[] {(int)(footingX + footingWidth * 0.65), (int)(footingX + footingWidth * 0.35), (int)(footingX + footingWidth * 0.4), (int)(footingX + footingWidth * 0.6)};
        int[] touchpadYs = new int[] {footingY, footingY, (int)(footingY + footingHeight * 0.6), (int)(footingY + footingHeight * 0.6)};
        Polygon touchpad = new Polygon(touchpadXs, touchpadYs, 4);
        g.draw(touchpad);
    }
}


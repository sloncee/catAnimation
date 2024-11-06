package ru.vsu.cs.dorofeyeva_s_v;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Path2D;

public class Vase {

    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public Vase(final int x, final int y, final int width, final int height, final Color color) {
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


        //ваза
        Path2D.Double vase = new Path2D.Double();
        vase.moveTo(x + 0.264 * width, y + height);
        vase.quadTo(x + 0.076 * width, y + 0.726 * height, x + 0.21 * width, y + 0.59 * height);
        vase.lineTo(x + 0.57 * width, y + 0.59 * height);
        vase.quadTo(x + 0.71 * width, y + 0.726 * height, x + 0.52 * width, y + height);
        vase.closePath();


        //листики
        Path2D.Double leaf1 = new Path2D.Double();
        leaf1.moveTo(x + 0.31 * width, y + 0.6 * height);
        leaf1.curveTo(x - 0.38 * width, y + 0.175 * height, x + 0.31 * width, y + 0.075 * height, x + 0.4 * width, y + 0.6 * height);
        leaf1.closePath();

        Path2D.Double leaf2 = new Path2D.Double();
        leaf2.moveTo(x + 0.412 * width, y + 0.394 * height);
        leaf2.curveTo(x + 0.086 * width, y - 0.16 * height, x + 1.043 * width, y - 0.09 * height, x + 0.412 * width, y + 0.394 * height);
        leaf2.closePath();

        Path2D.Double leaf3 = new Path2D.Double();
        leaf3.moveTo(x + 0.41 * width, y + 0.594 * height);
        leaf3.curveTo(x + 0.74 * width, y - 0.016 * height, x + 1.5 * width, y - 0.008 * height, x + 0.5 * width, y + 0.594 * height);
        leaf3.closePath();

        Area areaVase = new Area(vase);
        areaVase.add(new Area(leaf1));
        areaVase.add(new Area(leaf2));
        areaVase.add(new Area(leaf3));
        g.draw(areaVase);
        g.draw(vase);


        //ветки
        Path2D.Double branch1 = new Path2D.Double();
        branch1.moveTo(x + 0.345 * width, y + 0.59 * height);
        branch1.lineTo(x + 0.126 * width, y + 0.314 * height);
        g.draw(branch1);

        Path2D.Double branch2 = new Path2D.Double();
        branch2.moveTo(x + 0.39 * width, y + 0.585 * height);
        branch2.lineTo(x + 0.45 * width, y + 0.087 * height);
        g.draw(branch2);

        Path2D.Double branch3 = new Path2D.Double();
        branch3.moveTo(x + 0.456 * width, y + 0.585 * height);
        branch3.lineTo(x + 0.87 * width, y + 0.226 * height);
        g.draw(branch3);

//        Area areaBranches = new Area(branch1);
//        areaBranches.add(new Area(branch2));
//        areaBranches.add(new Area(branch3));
//        areaBranches.exclusiveOr(new Area(vase));
//        g.draw(areaBranches);
    }
}


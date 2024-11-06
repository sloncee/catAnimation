package ru.vsu.cs.dorofeyeva_s_v;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Path2D;

public class Cup {

    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public Cup(final int x, final int y, final int width, final int height, final Color color) {
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


        //основа кружки
        int[] cupXs = new int[]{x + width, (int)(x + 0.3 * width), (int)(x + 0.4 * width), (int)(x + 0.9 * width)};
        int[] cupYs = new int[]{y, y, y + height, y + height};
        Polygon cup = new Polygon(cupXs, cupYs, 4);


        //ручка
        Path2D.Double handle = new Path2D.Double();
        handle.moveTo(x + 0.4 * width, y + 0.25 * height);
        handle.curveTo(x - 0.05 * width, y + 0.05 * height, x - 0.2 * width, y + 0.7 * height, x + 0.45 * width, y + 0.9 * height);
        handle.lineTo(x + 0.45 * width, y + 0.9 * height - 0.12 * width);
        handle.curveTo(x, y + 0.7 * height, x + 0.05 * width, y + 0.05 * height + 0.1 * width, x + 0.4 * width, y + 0.2 * height + 0.2 * width);
        handle.closePath();
        
        Area areaCup = new Area(cup);
        areaCup.add(new Area(handle));
        g.draw(areaCup);


        //чайный пакетик
        Path2D.Double teaBag = new Path2D.Double();
        teaBag.moveTo(x + 0.56 * width, y);
        teaBag.curveTo(x + 0.759 * width, y - 0.2 * height, x + 0.764 * width, y + 0.193 * height, x + 0.7 * width, y + 0.25 * height);
        teaBag.lineTo(x + 0.59 * width, y + 0.26 * height);
        teaBag.lineTo(x + 0.5 * width, y + 0.41 * height);
        teaBag.lineTo(x + 0.64 * width, y + 0.54 * height);
        teaBag.lineTo(x + 0.752 * width, y + 0.38 * height);
        teaBag.lineTo(x + 0.7 * width, y + 0.25 * height);
        g.draw(teaBag);
    }
}

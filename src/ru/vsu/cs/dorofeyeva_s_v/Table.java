package ru.vsu.cs.dorofeyeva_s_v;

import java.awt.*;
import java.awt.geom.Path2D;

public class Table {

    private int x;
    private int y;
    private int width;
    private Color color;

    public Table(final int x, final int y, final int width, final Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.color = color;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    void draw(final Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        g.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(color);


        Path2D.Double table = new Path2D.Double();
        table.moveTo(x, y);
        table.lineTo(x + 0.002 * width, y);
        table.moveTo(x + 0.01 * width, y);
        table.lineTo(x + 0.013 * width, y);
        table.moveTo(x + 0.021 * width, y);
        table.lineTo(x + 0.03 * width, y);
        table.moveTo(x + 0.04 * width, y);
        table.lineTo(x + 0.96 * width, y);
        table.moveTo(x + 0.97 * width, y);
        table.lineTo(x + 0.98 * width, y);
        table.moveTo(x + 0.995 * width, y);
        table.lineTo(x + width, y);
        g.draw(table);
    }
}
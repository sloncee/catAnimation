package ru.vsu.cs.dorofeyeva_s_v;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;

public class Cat {
    private int x;
    private int y;
    private int width;
    private int height;
    private double eyeHeightCoeff;
    private double pawHeightCoeff;


    public Cat(final int x, final int y, final int width, final int height, final double eyeHeightCoeff, double pawHeightCoeff) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.eyeHeightCoeff = eyeHeightCoeff;
        this.pawHeightCoeff = pawHeightCoeff;
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
    public void setEyeHeightCoeff(double eyeHeightCoeff) {
        this.eyeHeightCoeff = eyeHeightCoeff;
    }
    public void setPawHeightCoeff(double pawHeightCoeff) {
        this.pawHeightCoeff = pawHeightCoeff;
    }


    void draw(final Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        Color cb = new Color(79, 41, 7);
        Color cr = new Color(247, 120, 54);
        Color co = new Color(227, 153, 10);
        Color c0 = new Color(251, 179, 3); //теневой
        Color c1 = new Color(251, 187, 3);
        Color c2 = new Color(251, 211,31);
        Color c3 = new Color(250, 234, 103);


        double bodyWidth = width * 0.66;
        double bodyHeight = height * 0.93;
        double bodyX = x + 0.23 * bodyWidth;
        double bodyY = y + 0.07 * bodyHeight;


        //левое ухо
        g.setColor(c1);
        Path2D.Double leftEar = new Path2D.Double();
        leftEar.moveTo(bodyX + 0.258 * bodyWidth, bodyY + 0.005 * bodyHeight);
        leftEar.quadTo(bodyX + 0.292 * bodyWidth, bodyY - 0.187 * bodyHeight, bodyX + 0.418 * bodyWidth, bodyY + 0.119 * bodyHeight);
        leftEar.closePath();
        g.draw(leftEar);
        g.fill(leftEar);


        //правое ухо
        Path2D.Double rightEar = new Path2D.Double();
        rightEar.moveTo(bodyX + 0.2 * bodyWidth, bodyY + 0.037 * bodyHeight);
        rightEar.quadTo(bodyX + 0.046 * bodyWidth, bodyY - 0.143 * bodyHeight, bodyX + 0.091 * bodyWidth, bodyY + 0.093 * bodyHeight);
        rightEar.closePath();
        g.draw(rightEar);
        g.fill(rightEar);


        //левое ухо внутри
        g.setColor(co);
        Path2D.Double leftEarInner = new Path2D.Double();
        leftEarInner.moveTo(bodyX + 0.101 * bodyWidth, bodyY + 0.059 * bodyHeight);
        leftEarInner.quadTo(bodyX + 0.075 * bodyWidth, bodyY - 0.075 * bodyHeight, bodyX + 0.159 * bodyWidth, bodyY + 0.026 * bodyHeight);
        leftEarInner.closePath();
        g.fill(leftEarInner);


        //правое ухо внутри
        Path2D.Double rightEarInner = new Path2D.Double();
        rightEarInner.moveTo(bodyX + 0.284 * bodyWidth, bodyY + 0.026 * bodyHeight);
        rightEarInner.quadTo(bodyX + 0.293 * bodyWidth, bodyY - 0.13 * bodyHeight, bodyX + 0.378 * bodyWidth, bodyY + 0.083 * bodyHeight);
        rightEarInner.closePath();
        g.fill(rightEarInner);


        //хвост
        GradientPaint gradient1 = new GradientPaint(
                (float)(bodyX + 0.91 * bodyWidth), (float)(bodyY + 0.919 * bodyHeight), c0,
                (float)(bodyX + 1.2 * bodyWidth), (float)(bodyY + 0.757 * bodyHeight), c2
        );
        g.setPaint(gradient1);
        Path2D.Double tail = new Path2D.Double();
        tail.moveTo(bodyX + 0.639 * bodyWidth, bodyY + bodyHeight);
        tail.curveTo(bodyX + 1.338 * bodyWidth, bodyY + 1.05 * bodyHeight, bodyX + 1.33 * bodyWidth, bodyY + 0.72 * bodyHeight, bodyX + 1.24 * bodyWidth, bodyY + 0.678 * bodyHeight);
        tail.curveTo(bodyX + 1.12 * bodyWidth, bodyY + 0.642 * bodyHeight, bodyX + 1.096 * bodyWidth, bodyY + 0.88 * bodyHeight, bodyX + 0.88 * bodyWidth, bodyY + 0.85 * bodyHeight);
        tail.closePath();
        g.fill(tail);


        //подвижная лапа
        g.setColor(c0);
        double deltaY = bodyHeight * 0.15;
        double deltaX = -bodyWidth * 0.07;
        double k1 = deltaY * pawHeightCoeff;
        double k2 = deltaY * pawHeightCoeff * 0.8;
        double k3 = deltaY * pawHeightCoeff * 0.5;
        double k4 = deltaX * pawHeightCoeff;
        double k5 = deltaX * pawHeightCoeff * 0.8;
        double k6 = deltaX * pawHeightCoeff * 0.5;

        Path2D.Double movingPaw = new Path2D.Double();
        movingPaw.moveTo(bodyX + 0.03 * bodyWidth, bodyY + 0.544 * bodyHeight);
        movingPaw.quadTo(bodyX + 0.014 * bodyWidth + k6, bodyY + 0.64 * bodyHeight + k3, bodyX - 0.024 * bodyWidth + k5, bodyY + 0.66 * bodyHeight + k2);

        movingPaw.lineTo(bodyX - 0.157 * bodyWidth + k4, bodyY + 0.709 * bodyHeight + k1);

        movingPaw.curveTo(bodyX - 0.236 * bodyWidth + k4, bodyY + 0.685 * bodyHeight + k1, bodyX - 0.253 * bodyWidth + k4, bodyY + 0.814 * bodyHeight + k1, bodyX - 0.193 * bodyWidth + k4, bodyY + 0.781 * bodyHeight + k1);
        movingPaw.curveTo(bodyX - 0.173 * bodyWidth + k4, bodyY + 0.778 * bodyHeight + k1, bodyX - 0.153 * bodyWidth + k4, bodyY + 0.803 * bodyHeight + k1, bodyX - 0.143 * bodyWidth + k4, bodyY + 0.776 * bodyHeight + k1);

        movingPaw.lineTo(bodyX - 0.004 * bodyWidth + k5, bodyY + 0.79 * bodyHeight + k2);

        movingPaw.quadTo(bodyX + 0.082 * bodyWidth + k6, bodyY + 0.787 * bodyHeight + k3, bodyX + 0.15 * bodyWidth, bodyY + 0.646 * bodyHeight + k1);
        movingPaw.closePath();
        g.fill(movingPaw);


        //тело
        g.setColor(c1);
        Path2D.Double body = new Path2D.Double();
        body.moveTo(bodyX + 0.295 * bodyWidth, bodyY + bodyHeight);
        body.curveTo(bodyX + 0.073 * bodyWidth, bodyY + bodyHeight, bodyX - 0.182 * bodyWidth, bodyY + 0.037 * bodyHeight, bodyX + 0.196 * bodyWidth, bodyY);
        body.curveTo(bodyX + 0.482 * bodyWidth, bodyY, bodyX + 0.428 * bodyWidth, bodyY + 0.183 * bodyHeight, bodyX + 0.565 * bodyWidth, bodyY + 0.36 * bodyHeight);
        body.curveTo(bodyX + bodyWidth, bodyY + 0.569 * bodyHeight, bodyX + 0.924 * bodyWidth, bodyY + bodyHeight, bodyX + 0.746 * bodyWidth, bodyY + bodyHeight);
        body.closePath();
        g.fill(body);


        //верх левой лапы
        GradientPaint gradient2 = new GradientPaint(
                (float)(bodyX + 0.268 * bodyWidth), (float)(bodyY + 0.685 * bodyHeight), c1,
                (float)(bodyX + 0.227 * bodyWidth), (float)(bodyY + 0.908 * bodyHeight), c2
        );
        g.setPaint(gradient2);

        Path2D.Double leftPawTop = new Path2D.Double();
        leftPawTop.moveTo(bodyX + 0.185 * bodyWidth, bodyY + 0.643 * bodyHeight);
        leftPawTop.lineTo(bodyX + 0.18 * bodyWidth, bodyY + 0.96 * bodyHeight);
        leftPawTop.lineTo(bodyX + 0.257 * bodyWidth, bodyY + 0.96 * bodyHeight);
        leftPawTop.lineTo(bodyX + 0.333 * bodyWidth, bodyY + 0.643 * bodyHeight);
        leftPawTop.closePath();
        g.fill(leftPawTop);


        //низ левой лапы
        g.setColor(c3);
        Path2D.Double leftPawBottom = new Path2D.Double();
        leftPawBottom.moveTo(bodyX + 0.175 * bodyWidth, bodyY + bodyHeight);
        leftPawBottom.curveTo(bodyX + 0.126 * bodyWidth, bodyY + 0.937 * bodyHeight, bodyX + 0.319 * bodyWidth, bodyY + 0.923 * bodyHeight, bodyX + 0.255 * bodyWidth, bodyY + bodyHeight);
        leftPawBottom.closePath();
        g.draw(leftPawBottom);
        g.fill(leftPawBottom);


        //задняя лапа
        GradientPaint gradient3 = new GradientPaint(
                (float)(bodyX + 0.862 * bodyWidth), (float)(bodyY + 0.669 * bodyHeight), c1,
                (float)(bodyX + 0.417 * bodyWidth), (float)(bodyY + 0.953 * bodyHeight), c2
        );
        g.setPaint(gradient3);

        Path2D.Double hindPaw = new Path2D.Double();
        hindPaw.moveTo(bodyX + 0.845 * bodyWidth, bodyY + 0.625 * bodyHeight);
        hindPaw.curveTo(bodyX + 0.354 * bodyWidth, bodyY + 0.432 * bodyHeight, bodyX + 0.293 * bodyWidth, bodyY + 0.77 * bodyHeight, bodyX + 0.445 * bodyWidth, bodyY + 0.937 * bodyHeight);
        hindPaw.curveTo(bodyX + 0.4 * bodyWidth, bodyY + 0.897 * bodyHeight, bodyX + 0.318 * bodyWidth, bodyY + 0.944 * bodyHeight, bodyX + 0.37 * bodyWidth, bodyY + bodyHeight);
        hindPaw.lineTo(bodyX + bodyWidth, bodyY + bodyHeight);
        hindPaw.closePath();

        Area areaHindPaw = new Area(hindPaw);
        areaHindPaw.intersect(new Area(body));
        g.fill(areaHindPaw);


        //усы
        g.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g.setColor(cb);
        Path2D whiskers = new Path2D.Double();
        whiskers.moveTo(bodyX + 0.104 * bodyWidth, bodyY + 0.243 * bodyHeight);
        whiskers.lineTo(bodyX - 0.06 * bodyWidth, bodyY + 0.2 * bodyHeight);
        whiskers.moveTo(bodyX + 0.097 * bodyWidth, bodyY + 0.262 * bodyHeight);
        whiskers.lineTo(bodyX - 0.085 * bodyWidth, bodyY + 0.264 * bodyHeight);
        whiskers.moveTo(bodyX + 0.104 * bodyWidth, bodyY + 0.277 * bodyHeight);
        whiskers.lineTo(bodyX - 0.06 * bodyWidth, bodyY + 0.32 * bodyHeight);
        whiskers.moveTo(bodyX + 0.252 * bodyWidth, bodyY + 0.248 * bodyHeight);
        whiskers.lineTo(bodyX + 0.445 * bodyWidth, bodyY + 0.207 * bodyHeight);
        whiskers.moveTo(bodyX + 0.257 * bodyWidth, bodyY + 0.267 * bodyHeight);
        whiskers.lineTo(bodyX + 0.467 * bodyWidth, bodyY + 0.264 * bodyHeight);
        whiskers.moveTo(bodyX + 0.25 * bodyWidth, bodyY + 0.282 * bodyHeight);
        whiskers.lineTo(bodyX + 0.447 * bodyWidth, bodyY + 0.33 * bodyHeight);
        g.draw(whiskers);


        //нос
        g.setColor(cr);
        int[] noseXs = new int[]{(int)(bodyX + 0.168 * bodyWidth), (int)(bodyX + 0.15 * bodyWidth), (int)(bodyX + 0.186 * bodyWidth)};
        int[] noseYs = new int[]{(int)(bodyY + 0.266 * bodyHeight), (int)(bodyY + 0.24 * bodyHeight), (int)(bodyY + 0.24 * bodyHeight)};
        Polygon nose = new Polygon(noseXs, noseYs, 3);
        g.fill(nose);

        g.setColor(cb);
        Path2D noseLine = new Path2D.Double();
        noseLine.moveTo(bodyX + 0.153 * bodyWidth, bodyY + 0.288 * bodyHeight);
        noseLine.lineTo(bodyX + 0.168 * bodyWidth, bodyY + 0.276 * bodyHeight);
        noseLine.lineTo(bodyX + 0.183 * bodyWidth, bodyY + 0.288 * bodyHeight);
        noseLine.moveTo(bodyX + 0.168 * bodyWidth, bodyY + 0.276 * bodyHeight);
        noseLine.lineTo(bodyX + 0.168 * bodyWidth, bodyY + 0.266 * bodyHeight);
        noseLine.lineTo(bodyX + 0.15 * bodyWidth, bodyY + 0.244 * bodyHeight);
        noseLine.moveTo(bodyX + 0.168 * bodyWidth, bodyY + 0.266 * bodyHeight);
        noseLine.lineTo(bodyX + 0.186 * bodyWidth, bodyY + 0.244 * bodyHeight);
        g.draw(noseLine);


        //левый глаз
        g.setColor(Color.WHITE);
        Ellipse2D.Double eyeLeft = new Ellipse2D.Double(bodyX + 0.07 * bodyWidth, bodyY + 0.134 * bodyHeight, 0.08 * height, 0.08 * height);

        Area eyeLeftCopy = new Area(eyeLeft);
        double centerX = eyeLeftCopy.getBounds2D().getX() + eyeLeftCopy.getBounds2D().getWidth() * 0.5;
        double centerY = eyeLeftCopy.getBounds2D().getY() + eyeLeftCopy.getBounds2D().getHeight() * 0.5;

        AffineTransform atL = new AffineTransform();
        atL.translate(-centerX, -centerY);
        eyeLeftCopy = new Area(atL.createTransformedShape(eyeLeftCopy));
        atL.setToScale(1.0, eyeHeightCoeff);
        eyeLeftCopy = new Area(atL.createTransformedShape(eyeLeftCopy));
        atL.setToTranslation(centerX, centerY);
        eyeLeftCopy = new Area(atL.createTransformedShape(eyeLeftCopy));

        g.fill(eyeLeftCopy);

        g.setColor(cb);
        Ellipse2D.Double pupilLeft = new Ellipse2D.Double(bodyX + 0.063 * bodyWidth, bodyY + 0.164 * bodyHeight, 0.052 * height, 0.052 * height);

        Area areaEyeLeft = new Area(eyeLeftCopy);
        areaEyeLeft.intersect(new Area(pupilLeft));
        g.fill(areaEyeLeft);


        //правый глаз
        g.setColor(Color.WHITE);
        Ellipse2D.Double eyeRight = new Ellipse2D.Double(bodyX + 0.205 * bodyWidth, bodyY + 0.134 * bodyHeight, 0.08 * height, 0.08 * height);

        Area eyeRightCopy = new Area(eyeRight);
        centerX = eyeLeftCopy.getBounds2D().getX() + eyeLeftCopy.getBounds2D().getWidth() * 0.5;
        centerY = eyeLeftCopy.getBounds2D().getY() + eyeLeftCopy.getBounds2D().getHeight() * 0.5;

        AffineTransform atR = new AffineTransform();
        atR.translate(-centerX, -centerY);
        eyeRightCopy = new Area(atR.createTransformedShape(eyeRightCopy));
        atR.setToScale(1.0, eyeHeightCoeff);
        eyeRightCopy = new Area(atR.createTransformedShape(eyeRightCopy));
        atR.setToTranslation(centerX, centerY);
        eyeRightCopy = new Area(atR.createTransformedShape(eyeRightCopy));

        g.fill(eyeRightCopy);

        g.setColor(cb);
        Ellipse2D.Double pupilRight = new Ellipse2D.Double(bodyX + 0.2 * bodyWidth, bodyY + 0.164 * bodyHeight, 0.052 * height, 0.052 * height);

        Area areaEyeRight = new Area(eyeRightCopy);
        areaEyeRight.intersect(new Area(pupilRight));
        g.fill(areaEyeRight);
    }
}

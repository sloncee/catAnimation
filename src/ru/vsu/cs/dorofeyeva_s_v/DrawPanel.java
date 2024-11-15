package ru.vsu.cs.dorofeyeva_s_v;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class DrawPanel extends JPanel implements ActionListener, KeyListener {
    private final int PANEL_WIDTH;
    private final int PANEL_HEIGHT;
    private final int TIMER_DELAY;
    private Timer timer;
    private Timer blinkTimer;
    private Timer delayTimer;
    private Timer pawTimer;
    private double eyeHeightCoeff = 1.0;
    private double pawHeightCoeff = 0.0;
    private boolean isClosing = true;
    private boolean isPawDown = false;
    private Cup cup;
    private Laptop laptop;
    private Vase vase;
    private Cat cat;
    private Table table;

    public DrawPanel(final int width, final int height, final int timerDelay) {
        this.PANEL_WIDTH = width;
        this.PANEL_HEIGHT = height;
        this.TIMER_DELAY = timerDelay;
        timer = new Timer(timerDelay, this);
        timer.start();

        blinkTimer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isClosing) {
                    eyeHeightCoeff -= 0.1;
                    if (eyeHeightCoeff <= 0) {
                        eyeHeightCoeff = 0;
                        isClosing = false;
                    }
                } else {
                    eyeHeightCoeff += 0.1;
                    if (eyeHeightCoeff >= 1) {
                        eyeHeightCoeff = 1;
                        isClosing = true;
                        stopBlinkingAndSetRandomDelay();
                    }
                }
                cat.setEyeHeightCoeff(eyeHeightCoeff);
                repaint();
            }
        });

        delayTimer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startBlinking();
            }
        });

        pawTimer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handlePawAnimation();
            }
        });

        addKeyListener(this);
        setFocusable(true);

        this.cup = new Cup(60,400 - 60, (int)(60 * 1.3), 60, Color.GRAY);
        this.laptop = new Laptop(190, 400 - 150, (int)(150 * 1.6), 150, Color.GRAY);
        this.vase = new Vase(600, 400 - 300, (int)(300 * 0.42), 300, Color.GRAY);
        this.cat = new Cat(350, 400 - 250, (int)(250 * 1.4), 250, eyeHeightCoeff, pawHeightCoeff);
        this.table = new Table(20, 400, 740, Color.GRAY);

        delayTimer.setInitialDelay(new Random().nextInt(5000));
        delayTimer.start();
    }

    @Override
    public void paint(final Graphics gr) {
        super.paint(gr);
        cup.draw(gr);
        laptop.draw(gr);
        vase.draw(gr);
        cat.draw(gr);
        table.draw(gr);
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!pawTimer.isRunning()) {
            isPawDown = true;
            pawTimer.start();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    private void handlePawAnimation() {
        if (isPawDown) {
            pawHeightCoeff += 0.3;
            if (pawHeightCoeff >= 1) {
                pawHeightCoeff = 1;
                isPawDown = false;
            }
        } else {
            pawHeightCoeff -= 0.2;
            if (pawHeightCoeff <= 0) {
                pawHeightCoeff = 0;
                isPawDown = true;
                pawTimer.stop();
            }
        }
        cat.setPawHeightCoeff(pawHeightCoeff);
        repaint();
    }

    private void stopBlinkingAndSetRandomDelay() {
        blinkTimer.stop();
        Random random = new Random();
        int delayTime = random.nextInt(5000);
        delayTimer.setDelay(delayTime);
        delayTimer.start();
    }

    private void startBlinking() {
        blinkTimer.start();
    }
}

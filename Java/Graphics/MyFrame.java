package graphics;

import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class MyFrame extends JFrame {
    private final int ALTURA = 500;
    private final int LARGURA = 500;

    public MyFrame() {
        this.setSize(ALTURA, LARGURA);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g) {
        Random random = new Random();

        while (true) {
            Color color = new Color(random.nextInt(255));
            g.drawRect(random.nextInt(300), random.nextInt(300), random.nextInt(500), random.nextInt(500));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }
}

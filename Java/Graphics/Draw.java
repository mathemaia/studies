package graphics;

import javax.swing.JFrame;
import java.awt.*;
import java.util.Random;

public class Draw extends JFrame {
    private final int ALTURA = 500;
    private final int LARGURA = 500;

    public Draw() {
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * Método responsável por criar os segmentos de reta de tamanho e cor aleatória.
     * @param g objeto graphics
     */
    @Override
    public void paint(Graphics g) {
        Random random = new Random();

        while (true) {
            Color color = new Color(random.nextInt(255));
            g.drawLine(random.nextInt(500), random.nextInt(500), random.nextInt(500), random.nextInt(500));

            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Draw janela = new Draw();
    }

}

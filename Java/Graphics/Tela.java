package graphics;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;

public class Tela extends JPanel implements ActionListener {
    private int x;
    private int y;

    public Tela()  {
        this.setPreferredSize(new Dimension(500, 500));
        this.setBackground(Color.black);
    }

    /**
     * Método responsável por criar os segmentos de reta de tamanho e cor aleatória.
     * @param g objeto graphics
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        Random random = new Random();
        int i = 100;

        g2D.setPaint(Color.blue);
        g2D.drawOval(x, y,x + 50, y + 50);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.x = x + 100;
        this.repaint();
    }
}

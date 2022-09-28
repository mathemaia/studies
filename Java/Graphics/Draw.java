package graphics;

import javax.swing.JFrame;
import java.awt.*;
import java.util.Random;

public class Draw extends JFrame {
    private final int ALTURA = 500;
    private final int LARGURA = 500;
    Tela tela;

    public Draw() {
        this.tela = new Tela();
        this.add(tela);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
    }

    public static void main(String[] args) {
        Draw janela = new Draw();
    }

}

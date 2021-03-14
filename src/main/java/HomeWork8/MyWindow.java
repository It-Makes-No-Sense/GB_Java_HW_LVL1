package HomeWork8;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {
    public MyWindow () {
        setTitle("Крестики - Нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setVisible(true);
    }
}

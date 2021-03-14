package HomeWork8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Random;

public class TicTacToe extends JComponent {
    public static final int EMPTY = 0;
    public static final int X = 20;
    public static final int O = 100;
    int[][] arr;
    boolean isXturn = true;
    Random rnd = new Random();

    public TicTacToe() {
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
        arr = new int[3][3];
        initGame();
    }

    public void initGame() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j]=EMPTY;
            }
        }
        isXturn = true;
    }

    @Override
    protected void processMouseEvent(MouseEvent e) {
        super.processMouseEvent(e);
        if (e.getButton() == MouseEvent.BUTTON1) {
                if (isXturn == true) {
                    int x = e.getX();
                    int y = e.getY();

                    int i = (int) ((float)x / getWidth() * 3);
                    int j = (int) ((float)y / getHeight() * 3);

                    if (arr[i][j] == EMPTY) {
                        arr[i][j] = X;
                        isXturn = false;
                        repaint();
                        int res = checkWin();
                        if (res!=0){
                            if (res == O*3){
                                JOptionPane.showMessageDialog(this,"Нолики выйграли!","Победа!", JOptionPane.INFORMATION_MESSAGE);
                            } else if (res == X*3) {
                                JOptionPane.showMessageDialog(this,"Крестики выйграли!","Победа!", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(this,"Ничья!","Ничья!", JOptionPane.INFORMATION_MESSAGE);
                            }
                            initGame();
                            repaint();
                        }
                    }
                }
                do {
                    if (isXturn == false) {
                        int x = rnd.nextInt(getWidth());
                        int y = rnd.nextInt(getHeight());

                        int i = (int) ((float)x / getWidth() * 3);
                        int j = (int) ((float)y / getHeight() * 3);

                        if (arr[i][j] == EMPTY) {
                            arr[i][j] = O;
                            isXturn = true;
                            repaint();
                            int res = checkWin();
                            if (res!=0){
                                if (res == O*3){
                                    JOptionPane.showMessageDialog(this,"Нолики выйграли!","Победа!", JOptionPane.INFORMATION_MESSAGE);
                                } else if (res == X*3) {
                                    JOptionPane.showMessageDialog(this,"Крестики выйграли!","Победа!", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(this,"Ничья!","Ничья!", JOptionPane.INFORMATION_MESSAGE);
                                }
                                initGame();
                                repaint();
                            }
                        }
                    }
                } while (isXturn == false);

        }
    }


    void drawX ( int i, int j, Graphics graphics) {
        graphics.setColor(Color.BLACK);
        int w1 = getWidth() / 3;
        int h1 = getHeight() / 3;
        int x = i * w1;
        int y = j * h1;
        graphics.drawLine(x,y,x +w1,y+h1); // 1 диагональ
        graphics.drawLine(x,y+h1,x+w1, y); // 2 диагональ
    }

    void draw0 (int i,int j, Graphics graphics) {
        graphics.setColor(Color.BLACK);
        int w1 = getWidth() / 3;
        int h1 = getHeight() / 3;
        int x = i * w1;
        int y = j * h1;
        graphics.drawOval(x+5*w1/100,y,w1*9/10,h1);
    }

    void drawX0(Graphics graphics) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i][j]== X) {
                    drawX(i,j,graphics);
                } else if (arr[i][j] == O){
                    draw0(i,j,graphics);
                }
            }

        }
    }

    int checkWin() {
        int diag = 0;
        int diag2 = 0;

        for (int i = 0; i < 3; i++) {
            diag += arr[i][i];
            diag2 += arr[i][2 - i];
        }

        if (diag == O * 3 || diag == X * 3) {
            return diag;
        }

        if (diag2 == O * 3 || diag2 == X * 3) {
            return diag2;
        }
        int chek_i, chek_j;
        boolean hasEmpty = false;

        for (int i = 0; i < 3; i++) {
            chek_i = 0;
            chek_j = 0;
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == 0) {
                    hasEmpty = true;
                }
                chek_i += arr[i][j];
                chek_j += arr[j][i];
            }

            if (chek_i == O * 3 || chek_i == X * 3) {
                return chek_i;
            }
            if (chek_j == O * 3 || chek_j == X * 3) {
                return chek_j;
            }
        }
        if(hasEmpty) return 0; else return -1;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.clearRect(0,0,getWidth(),getHeight());
        paintMap(g);
        drawX0(g);
    }

    public void paintMap (Graphics graphics){
        int w = getWidth();
        int h = getHeight();
        int w1 = w/3;
        int h1= h/3;
        for (int i = 0; i < 3; i++) {
            graphics.drawLine(0,h1*i,w,h1*i); //Линия по горизонтали
            graphics.drawLine(w1*i,0,w1*i,h); //Линия по вертикали
        }
    }
}

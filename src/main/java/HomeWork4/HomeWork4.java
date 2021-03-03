package HomeWork4;

import java.util.Random;
import java.util.Scanner;

public class HomeWork4 {
    public static char [][] map;
    public static final int SIZE = 3;
    public static final int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_0 = '0';
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)){
                System.out.println("Победил игрок!");
                break;
            }

            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }

            aiTurn();
            printMap();
            if (checkWin(DOT_0)){
                System.out.println("Победил ИИ!");
                break;
            }
            if (isMapFull()){
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Конец игры!");
        sc.close();
    }

    private static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i+1)+" ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void humanTurn() {
        int x,y;
        do {
            System.out.println("Введите координаты Х и Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellIsValid(x,y));
        map[y][x] = DOT_X;
    }

    private static boolean isCellIsValid(int x,int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >=SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    private static void aiTurn() {
        int x,y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellIsValid(x,y));
        System.out.println("Компьютер походил в точку " + (x+1) + " " + (y+1));
        map[y][x] = DOT_0;
    }

    private static boolean checkWin(char symb) {
        int x = 0;

        for (int i = 0; i < SIZE; i++) {            //Проверка по горизонтали
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symb){
                    x++;
                    if (x == DOTS_TO_WIN) {
                        return true;
                    }
                } else {
                    x = 0;
                }
            }
        }

        x = 0;
        for (int i = 0; i < SIZE; i++) {            //Проверка по вертикали
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == symb){
                    x++;
                    if (x == DOTS_TO_WIN) {
                        return true;
                    }
                } else {
                    x = 0;
                }
            }
        }

        x = 0;
        for (int i = 0; i < SIZE; i++) {        //По горизонтали 3x3 или 4х4 - при условии что для победы нужно 4 символа.
            for (int j = 0; j < SIZE; j++) {
                if (i == j) {
                    if (map[i][j] == symb) {
                        x++;
                        if (x == DOTS_TO_WIN){
                            return true;
                        }
                    }
                }
            }
        }

        x = 0;
        for (int i = 0; i < SIZE; i++) {    // Вторая горизонталь
            for (int j = 0; j < SIZE; j++) {
                if (j == map.length - 1 - i) {
                    if (map[i][j] == symb) {
                        x++;
                        if (x == DOTS_TO_WIN){
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    private static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
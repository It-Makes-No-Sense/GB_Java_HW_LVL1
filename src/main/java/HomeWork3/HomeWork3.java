package HomeWork3;

import java.util.Random;
import java.util.Scanner;

public class HomeWork3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        while (true) {
            int x = rand.nextInt(10);
            System.out.println("Загадано число от 0 до 9, у вас есть 3 попытки чтобы отгадать его!");

            for (int i = 0; i <= 3; i++) {
                if (i == 3) {
                    System.out.println("Ваши попытки закончились, вы проиграли. Начать заново? \n 1 - Да \n 0 - Нет");
                    int o = sc.nextInt();
                    if (o == 0) {
                        sc.close();
                        return;
                    } else {
                        i = 4;
                        continue;
                    }
                }

                int v = sc.nextInt();

                if (v == x) {
                    System.out.println("Вы угадали! Хотите сыграть еще? \n 1 - Да \n 0 - Нет");
                    int o = sc.nextInt();
                    if (o == 0) {
                        sc.close();
                        return;
                    } else {
                        i = 4;
                        continue;
                    }
                } else if (v < x) {
                    System.out.println("Загаданное число больше");
                } else {
                    System.out.println("Загаданное число меньше");
                }
            }
        }
    }
}

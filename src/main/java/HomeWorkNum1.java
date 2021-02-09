public class HomeWorkNum1 {
    public static void main(String[] args) { //# 1
        // # 2
        byte b = 0;     //целочисленные
        short s = 0;
        int i = 0;
        long l = 0L;

        float f = 1.1f;     //С плав. точкой
        double d = 1.1;

        char c = 'С';       //Символьный тип

        boolean bo = true;      //Логический тип

        System.out.println(foo(2, 3, 12, 6)); // #3
        System.out.println(task10and20(8, 13)); // #4
        positiveOrNegative(4); // #5
        System.out.println(positiveOrNegative2(-10)); // # 6
        whatIsName("Давид"); // #7
        whatYear(1840); // #8
    }

    public static float foo(float a, float b, float c, float d) { //# 3
        return a * (b + (c / d));
    }


    public static boolean task10and20(int x1, int x2) { // #4
        boolean result;
        if (x1 + x2 >= 10 & x1 + x2 <= 20) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public static void positiveOrNegative(int x) { // #5
        if (x < 0) {
            System.out.println("Ваше число отрицательное");
        } else {
            System.out.println("Ваше число положительное");
        }
    }

    public static boolean positiveOrNegative2(int x) {  //#6
        if (x < 0) {
            return true;
        } else return false;

    }

    public static void whatIsName(String name) { //#7
        System.out.println("Привет " + name + "! Спасибо, что проверил домашнее задание!");
    }


    public static void whatYear(int x) { //#8
            if ((x % 400) % 4 == 0) {
                System.out.println("Год високосный!");
            } else {
                System.out.println("Год не високосный");
            }
    }
}
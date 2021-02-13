package HomeWork2;

public class HomeWorkNum2 {
    public static void main(String[] args) {

        int[] arr = {0, 1, 0, 0, 1, 1}; //#1
        {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 1) {
                    arr[i] = 0;
                } else {
                    arr[i] = 1;
                }
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println(" \n ");

        int[] arr2 = new int[8];    //# 2
        {
            for (int i = 0, j = 0; i < arr2.length; i++) {
                arr2[i] = j;
                System.out.println("arr2[" + i + "] = " + j);
                j += 3;
            }
        }
        System.out.println(" \n ");

        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1}; //#3
        {
            for (int i = 0; i < arr3.length; i++) {
                if (arr3[i] < 6) {
                    int j;
                    j = arr3[i] * 2;
                    System.out.println(j);
                }
            }
        }
        System.out.println(" \n ");

        int[][] arr4 = new int[5][5]; {                       //#4
            for (int i = 0; i < arr4.length; i++) {
                for (int j = 0; j < arr4.length; j++) {
                    if (i == j || j == arr4.length - 1 - i) {
                            arr4[i][j] = 1;
                        }
                    System.out.print(arr4[i][j] + " ");
                    }
                System.out.println();
            }
        }
        System.out.println(" \n ");

        //#5 - сделал сам
        int [] arr5 = {1, 15, 4, -23, 45}; {
            int min = arr5[0];
            int max = arr5[0];
            for (int i = 0; i < arr5.length ; i++) {
                if (min > arr5[i]){
                    min = arr5[i];
                }
                if (max < arr5[i]) {
                    max = arr5[i];
                }
            }
            System.out.println(min + " " + max);
        }
        int [] proverka = {1,2,1,4,3,1,2,1};
        System.out.println("\n" + chekB(proverka));
        System.out.println(shiftArr(proverka, 5));
    }

    //#6 - переписал с сегодняшнего вебинара
    public static boolean chekB (int [] arr6) {
        boolean check = false;

        int sumLeft = arr6[0] + arr6[1];
        int sumRight = arr6[arr6.length-1] + arr6[arr6.length - 2];

        if (sumLeft == sumRight && arr6.length == 4) {
            return true;
        }

        for (int i = 2; i < arr6.length - 2 ; i++) {

            sumRight = arr6[arr6.length-1] + arr6[arr6.length - 2];

            for (int j = i; j < arr6.length - 2; j++) {
                sumRight += arr6[j];
            }

            if (sumLeft == sumRight) {
                return true;
            }
            sumLeft += arr6[i];
        }
        return check;
    }

    //#7
    public static void shiftArr(int arr [], int n) {
        int temp = arr[0];
        int currentIndex = n;
        int jumps = 1;

        while(jumps <= arr.length) {
            int swap = arr[currentIndex % arr.length];
            arr[currentIndex % arr.length] = temp;
            temp = swap;
            if ((jumps * n) % arr.length == 0) {
                currentIndex++;
                temp = arr[currentIndex % arr.length];
            }
            currentIndex += n;
            jumps++;
        }
    }

}

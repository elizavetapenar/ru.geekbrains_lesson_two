package ru.geekbrains_lesson_two;

import java.sql.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {0, 1, 0, 0, 1, 1, 1, 0, 0, 1};
        System.out.println(Arrays.toString(Array01(arr1)));

        int[] arr4 = {110, 20, 34, 41, 5};
        int[] arr04 = ArrayMinMax(arr4);
        System.out.println("Minimum is " + arr04[0] + '\n' + "Maximum is " + arr04[1]);

        int[]arr03 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(ArrayXtwo(arr03)));

        int[]arr02 = new int[8];
        System.out.println(Arrays.toString(ArrayFill(arr02)));

        int[][]square = new int[6][6];
        int[][] Diagonal = ArrayDiagonal(square);
        System.out.println(square==Diagonal);
        for(int rows = 0; rows < Diagonal.length; rows++){
            System.out.println(Arrays.toString(Diagonal[rows]));
        }
    }
    //    1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
//    Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
    private static int[] Array01(int[]arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 0) ? 1 : 0;
//            if (arr[i] == 0) {
//                arr[i] = 1;
//            } else {
//                arr[i] = 0;
//            }
        }
        return arr;
    }
//    }
//    2. Задать пустой целочисленный массив размером 8. Написать метод, который помощью цикла заполнит его значениями
//    1 4 7 10 13 16 19 22;
    private static int[] ArrayFill(int[]arr){
        arr[0] = 1;
        for(int i = 1; i < arr.length; i++){
         arr[i] = arr[i-1] + 3;
        }
        return arr;
    }
//   3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод, принимающий на вход массив и умножающий
//      числа меньше 6 на 2;
    private static int[] ArrayXtwo(int[]arr){
        for(int i = 0; i < arr.length; i++){
            if (arr[i] < 6){
                arr[i] *= 2;
            }
        }
        return arr;
    }
//}
//   4. Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;
    private static int[] ArrayMinMax(int[] inputArray){
        int max = inputArray[0];
        int min = inputArray[0];
        for(int i = 1; i < inputArray.length; i++){
            if(inputArray[i] > max){
                max = inputArray[i];
            }
            if(inputArray[i] < min) {
                min = inputArray[i];
            }
        }
        int[]arr = new int [2];
        arr[0] = min;
        arr[1] = max;
        return arr;
    }
//   5*. Создать квадратный целочисленный массив (количество строк и столбцов одинаковое), заполнить его диагональные элементы
//       единицами, используя цикл(ы);
    private static int[][] ArrayDiagonal(int[][]arr){
        for(int rows = 0; rows < arr.length; rows++){
            for(int cols = 0; cols < arr[rows].length; cols++){
                if(rows == cols){
                    arr[rows][cols] = 1;
                }
            }
        }
        for(int rows = 0; rows < arr.length; rows++){
            for(int cols = arr[rows].length - 1; cols >= 0; cols--){
                if(rows + cols == arr.length - 1){
                    arr[rows][cols] = 1;
                }
            }
        }
        return arr;
    }
}

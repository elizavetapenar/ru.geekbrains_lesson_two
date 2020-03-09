package ru.geekbrains_lesson_two;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ex1:");
        int[] arr1 = {0, 1, 0, 0, 1, 1, 1, 0, 0, 1};
        System.out.println("Input:\t" + Arrays.toString(arr1));
        System.out.println("Output:\t" + Arrays.toString(Array01(arr1)));

        System.out.println("\nEx2:");
        int[]arr02 = new int[8];
        System.out.println("Output:\t" + Arrays.toString(ArrayFill(arr02)));

        System.out.println("\nEx3:");
        int[]arr03 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Input:\t" + Arrays.toString(arr03));
        System.out.println("Output:\t" + Arrays.toString(ArrayXtwo(arr03)));

        System.out.println("\nEx4:");
        int[] arr4 = {110, 20, 34, 41, 5};
        int[] arr04 = ArrayMinMax(arr4);
        System.out.println("Input:\t" + Arrays.toString(arr4));
        System.out.println("Minimum is " + arr04[0] + '\n' + "Maximum is " + arr04[1]);

        System.out.println("\nEx5:");
        int[][]square = new int[6][6];
        int[][] Diagonal = ArrayDiagonal(square);
        System.out.println(square==Diagonal);
        for(int rows = 0; rows < Diagonal.length; rows++)
            System.out.println(Arrays.toString(Diagonal[rows]));

        System.out.println("\nEx6:");
        int[]CheckValue = {5, 5, 5, 3, 6, 6};
        int[]CheckValue2 = {5, 5, 1, 3, 6, 6};
        System.out.println("Input:\t" + Arrays.toString(CheckValue));
        System.out.println("Output:\t" + ArrayCheckBalance(CheckValue));
        System.out.println("Input:\t" + Arrays.toString(CheckValue2));
        System.out.println("Output:\t" + ArrayCheckBalance(CheckValue2));

        System.out.println("\nEx7:");
        int[]Cycle = {5, 6, 7, 8, 9};
        System.out.println("Input:\t" + Arrays.toString(Cycle));
        System.out.println("n=3:\t" + Arrays.toString(ArrayCycle(Cycle, 3)));
        System.out.println("n=-3:\t" + Arrays.toString(ArrayCycle(Cycle, -3)));

    }
    //    1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
//    Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
    private static int[] Array01(int[]arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = (arr[i] == 0) ? 1 : 0;
        return arr;
    }
//    }
//    2. Задать пустой целочисленный массив размером 8. Написать метод, который помощью цикла заполнит его значениями
//    1 4 7 10 13 16 19 22;
    private static int[] ArrayFill(int[]arr){
        arr[0] = 1;
        for(int i = 1; i < arr.length; i++)
            arr[i] = arr[i-1] + 3;
        return arr;
    }
//   3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод, принимающий на вход массив и умножающий
//      числа меньше 6 на 2;
    private static int[] ArrayXtwo(int[]arr){
        for(int i = 0; i < arr.length; i++){
            if (arr[i] < 6)
                arr[i] *= 2;
        }
        return arr;
    }
//}
//   4. Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;
    private static int[] ArrayMinMax(int[] inputArray){
        int max = inputArray[0];
        int min = inputArray[0];
        for(int i = 1; i < inputArray.length; i++){
            if(inputArray[i] > max)
                max = inputArray[i];
            if(inputArray[i] < min)
                min = inputArray[i];
        }
        int[]OutArray = new int [2];
        OutArray[0] = min;
        OutArray[1] = max;
        return OutArray;
    }
//   5*. Создать квадратный целочисленный массив (количество строк и столбцов одинаковое), заполнить его диагональные элементы
//       единицами, используя цикл(ы);
    private static int[][] ArrayDiagonal(int[][]arr){
        for(int rows = 0; rows < arr.length; rows++){
            for(int cols = 0; cols < arr[rows].length; cols++){
                if(rows == cols || rows + cols == arr.length - 1)
                    arr[rows][cols] = 1;
            }
        }
        return arr;
    }
//  6** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true если в массиве
//    есть место, в котором сумма левой и правой части массива равны. Примеры: checkBalance([1, 1, 1, || 2, 1]) ? true,
//    checkBalance ([2, 1, 1, 2, 1]) ? false, checkBalance ([10, || 1, 2, 3, 4]) ? true. Абстрактная граница показана
//    символами ||, эти символы в массив не входят.
    private static boolean ArrayCheckBalance(int[]arr){
        int Summa = 0;
        for(int i = 0; i < arr.length; i++)
            Summa += arr[i];
        int Right = Summa;
        int Left = 0;
        for(int x = 0; x < arr.length; x++){
            Right -= arr[x];
            Left += arr[x];
            if(Right == Left)
                return true;
        }
        return false;
    }
//  7***. Написать метод, которому на вход подаётся одномерный массив и число n (может быть положительным, или отрицательным),
//        при этом метод должен циклически сместить все элементы массива на n позиций.
    private static int[] ArrayCycle(int[]arr, int n){
        int length = arr.length;
        int[]NewArr = new int[length];
        int NewIndex;
        for (int i = 0; i < length; i++) {
            NewIndex = (i + n) % length;
            if (NewIndex < 0)
                NewArr[NewIndex + length] = arr[i];
            else
                NewArr[NewIndex] = arr[i];
        }
        return NewArr;
    }
//    8*****.   Не пользоваться вспомогательным массивом при решении задачи 7.
}

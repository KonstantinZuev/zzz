/**
*Java 1. Home work #3
*
*@author Zuev Konstantin
*@version 24.02.2022
*/
import java.util.Arrays;


class HomeWorkApp3 {

    public static void main(String[] args) { 

        System.out.println("Задание 1");
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
        arr[i] = 1 - arr[i];
        System.out.println(arr[i]);

    }
        System.out.println("Задание 2");
        int[] arrA = new int[101];
        for (int i = 0; i < arrA.length; i++) {
        arrA[i] = i;
        System.out.println("arrA[" + i + "] = " + arrA[i]);

    }
        System.out.println("Задание 3");
        int[] arrB = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arrB));
        for (int i = 0; i < arrB.length; i++) {
        if (arrB[i] < 6) {
        arrB[i] *= 2;
        System.out.println(Arrays.toString(arrB));
        }
    }
        System.out.println("Задание 4");
        int [][] matrix = new int [5][5];
        for (int i = 0; i < matrix.length; i++) {
        matrix[i][i] = 1;
        matrix[i][matrix.length - i -1] = 1;
    }
        for (int i = 0; i < matrix.length; i++) {
        System.out.println(Arrays.toString(matrix[i]));

    }
        System.out.println("Задание 5");

        int [] arrC = {15, 5};
      //Sytem.out.println(Arrays.toString(arrC));
       }
    }
package com.spnikit.taks2;

import java.util.Arrays;

// 2. Отсортируйте массив [5,6,3,2,5,1,4,9]
public class Task2 {
    public static void main(String[] args) {
        int[] arr = {5, 6, 3, 2, 5, 1, 4, 9};

        System.out.println("Начальный массив: " + Arrays.toString(arr));
        insertionSort(arr);

        assert Arrays.equals(arr, new int[]{1, 2, 3, 4, 5, 5, 6, 9}) : "Not Equal";

        System.out.println("Отсортированный массив: " + Arrays.toString(arr));
    }


    static void insertionSort(int[] array) {


        for (int i = 1; i < array.length; i++) {
            int tmp = array[i]; // положили во временную переменную
            int j = i - 1;
            while (j >= 0) {

                if (array[j] > tmp) { // если число слева от сохраненной переменной больше ее, передвигаем
                    array[j + 1] = array[j];
                    j--;
                } else {
                    break; // если меньше или равно прерываем цикл
                }
            }
            array[j + 1] = tmp;
        }
    }

}

package com.spnikit.task1;

//1. Заполните двумерный массив случайным числами и выведите максимальное, минимальное и среднее значение.

public class Task1 {
    public static void main(String[] args) {
        var array = new int[10][10];

        // создание генератора случайных чисел с верхних порогом в 1000
        RandomGenerator generator = new RandomGenerator(1000);

        // заполнение массива
        for (int[] outer: array){
            for(int i = 0; i < outer.length; i++){
                outer[i] = generator.nextInt();
            }
        }

        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        int sum = 0;
        int counter = 0;

        for (int[] outer: array){
            for (int j : outer) {
                if (j > maxValue) {
                    maxValue = j;
                } else if(j < minValue){
                    minValue = j;
                }
                sum += j;
                counter++;
            }
        }

        System.out.println("Максимальное значение в массиве = " + maxValue);
        System.out.println("Минимальное значение в массиве = " + minValue);
        System.out.println("Среднее значение в массиве = " + sum/counter);


    }


    static class RandomGenerator{
        private final int max;
        private int last;

        public RandomGenerator(int max){
            this.max = max;
            this.last = (int)(System.currentTimeMillis()%max);
        }

        public int nextInt(){
            this.last = (last * 3452352 + 2344)%33939;
            this.last = last % this.max;
            return this.last;
        }
    }
}



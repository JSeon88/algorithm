package com.sort;

public class MyBubbleSort {

    public int[] sort(int[] numbers){
        boolean flag;

        do {
            flag = false;

            for(int i = 0; i<numbers.length-1; ++i){
                if(numbers[i+1] < numbers[i]){
                    int temp = numbers[i+1];
                    numbers[i+1] = numbers[i];
                    numbers[i] = temp;
                    flag = true;
                }
            }
        }while (flag);

        return numbers;
    }

    public static void main(String[] args){
        MyBubbleSort bubbleSort = new MyBubbleSort();

        int[] numbers = {6,4,9,5};
        int[] result = bubbleSort.sort(numbers);
        for(int i = 0; i<result.length; ++i){
            System.out.println(result[i]);
        }

    }
}

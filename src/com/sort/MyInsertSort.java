package com.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyInsertSort {

    public List<Integer> sort(List<Integer> list){
        List<Integer> newList = new LinkedList<>();

        originalList : for(int num : list){
            for(int j = 0; j<newList.size(); ++j){
                if(num < newList.get(j) ){
                    newList.add(j,num);
                    continue originalList;
                }
            }
            newList.add(newList.size(),num);
        }

        return newList;
    }

    public static void main(String[] args){
        MyInsertSort insertSort = new MyInsertSort();

        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(4);
        list.add(9);
        list.add(5);

        List<Integer> result = insertSort.sort(list);

        for(int i = 0; i<result.size(); ++i){
            System.out.println(result.get(i));
        }
    }
}

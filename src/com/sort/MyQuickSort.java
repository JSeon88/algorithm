package com.sort;

import java.util.ArrayList;
import java.util.List;

public class MyQuickSort {

    public List<Integer> sort(List<Integer> list){

        if(list.size() < 2){
            return list;
        }

        int pivot = list.get(0);
        List<Integer> lower = new ArrayList<>();
        List<Integer> higher = new ArrayList<>();
        for(int i = 1; i<list.size(); ++i){
            if(pivot < list.get(i)){
                lower.add(list.get(i));
            }else{
                higher.add(list.get(i));
            }
        }

        List<Integer> sorted = sort(lower);
        sorted.add(pivot);
        sorted.addAll(sort(higher));
        return sorted;
    }

    public static void main(String[] args){
        MyQuickSort quickSort = new MyQuickSort();

        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(4);
        list.add(9);
        list.add(5);
        list.add(1);
        list.add(8);
        list.add(3);
        list.add(7);

        List<Integer> result = quickSort.sort(list);

        for(int i = 0; i<result.size(); ++i){
            System.out.println(result.get(i));
        }
    }
}

package com.sort;

import java.util.ArrayList;
import java.util.List;

public class MyMergeSort {

    public List<Integer> sort(List<Integer> list){

        if(list.size() <2){
            return list;
        }

        List<Integer> leftHalf = list.subList(0, list.size()/2);
        List<Integer> rightHalf = list.subList(list.size()/2, list.size());

        return merge(sort(leftHalf), sort(rightHalf));
    }

    public static List<Integer> merge(List<Integer> left, List<Integer> right){

        int leftPtr = 0;
        int rigthPtr = 0;

        List<Integer> merged = new ArrayList<>(left.size() + right.size());

        while (leftPtr < left.size() && rigthPtr < right.size()){
            if(left.get(leftPtr) < right.get(rigthPtr)){
                merged.add(left.get(leftPtr));
                leftPtr++;
            }else{
                merged.add(right.get(rigthPtr));
                rigthPtr++;
            }
        }

        while (leftPtr < left.size()){
            merged.add(left.get(leftPtr));
            leftPtr++;
        }

        while (rigthPtr < right.size()){
            merged.add(right.get(rigthPtr));
            rigthPtr++;
        }

        return merged;
    }

    public static void main(String[] args){

        MyMergeSort mergeSort = new MyMergeSort();

        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(4);
        list.add(9);
        list.add(5);
        list.add(1);
        list.add(8);
        list.add(3);
        list.add(7);

        List<Integer> result = mergeSort.sort(list);

        for(int val : result){
            System.out.println(val);
        }

    }
}

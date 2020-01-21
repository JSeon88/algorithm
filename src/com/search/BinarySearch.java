package com.search;

import com.sort.MyQuickSort;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

    public Boolean search(List<Integer> list, Integer val){

        int lSize = list.size()/2;

        if(list == null || list.isEmpty()){
            return false;
        }

        int comparison = list.get(lSize);

        if(val.equals(comparison)){
            return true;
        }

        // 오름차순으로 정렬되어 있을 경우
//        if(comparison < val){
//            return search(list.subList(lSize+1, list.size()), val);
//        }else{
//            return search(list.subList(0, lSize), val);
//        }

        // 내림차순으로 정렬되어 있을 경우
        if(comparison > val){
            return search(list.subList(lSize+1, list.size()), val);
        }else{
            return search(list.subList(0, lSize), val);
        }

    }

    public static void main(String[] args){

        BinarySearch binarySearch = new BinarySearch();

        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(4);
        list.add(9);
        list.add(5);
        list.add(1);
        list.add(8);
        list.add(3);
        list.add(7);

        MyQuickSort quickSort = new MyQuickSort();
        List<Integer> sortedList = quickSort.sort(list);

        // 정렬이 되어있다는 가정하에 이진검색.
        Boolean result = binarySearch.search(sortedList, 9);

        System.out.println(result);

    }
}

package com.algo.level2;

import java.util.*;

/**
 * 다리를 지나는 트럭
 * 스텍/큐
 * **/

public class Printer {

    public int solution(int[] priorities, int location) {
        int answer = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        Integer[] newArr = Arrays.stream(priorities).boxed().toArray( Integer[]::new);
        Arrays.sort(newArr, Comparator.reverseOrder());
        for(int i = 0; i<newArr.length; ++i){
            map.put(i, newArr[i]);
        }
        int loc = priorities[location];

        Set<Integer> keys = map.keySet();
        for(int key : keys){
            int val = map.get(key);
            if(val == loc){
                return key+1;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        Printer solution = new Printer();

//        int location = 2;
//        int[] priorities = {2, 1, 3, 2};

        int location = 0;
        int[] priorities = {1, 1, 9, 1, 1, 1};

        int answer = solution.solution(priorities, location);

        System.out.println(answer);


    }




}

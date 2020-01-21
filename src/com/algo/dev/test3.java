package com.algo.dev;

import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

/**
 * 다리를 지나는 트럭
 * 스텍/큐
 * **/

public class test3 {

    public int solution(int number, int[] firecracker) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<firecracker.length; ++i){
            map.put(i, 0);
            stack.push(firecracker[i]);
        }

        int cnt = 0;
        while (!stack.empty()){
            int num = stack.pop();
            int len = cnt+1+num;
            if(firecracker.length < len){
                len = firecracker.length;
            }
            for(int k = cnt+1; k<len; ++k){
                map.put(k, map.get(k)+1);
            }
            cnt++;
        }

        Set<Integer> keys = map.keySet();
        for(int key : keys){
            if(map.get(key) == 0){
                answer++;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        test3 solution = new test3();
//        String s1= "cookie";
//        String s2= "cooookieee";
//
        int number= 10;
        int[] firecraker= {1, 1, 3, 0, 0, 0, 2, 1, 0, 3};
        int answer = solution.solution(number, firecraker);

        System.out.println(answer);


    }




}

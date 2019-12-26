package com.algo.level2;

import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

/**
 * 다리를 지나는 트럭
 * 스텍/큐
 * **/

public class test4 {

    public int solution(int number, int[] firecracker) {
        int answer = 0;

        int firecrackerLen = firecracker.length;
        int[] arr = new int[firecrackerLen];

        int fail = 0;
        int cnt = 0;
        for(int i = firecrackerLen-1; i>0; i--){

            cnt = cnt > firecracker[i] ? cnt : firecracker[i];
            if(i == firecrackerLen-1){
                fail++;
                continue;
            }
            if(cnt == 0){
                fail++;
            }
            cnt--;
        }

//        for(int key : arr){
//            if(key == 0){
//                answer++;
//            }
//        }

        return fail;
    }


    public static void main(String[] args) {
        test4 solution = new test4();
//        String s1= "cookie";
//        String s2= "cooookieee";
//
        int number= 10;
        int[] firecraker= {1, 1, 3, 0, 0, 0, 2, 1, 0, 3};
        int answer = solution.solution(number, firecraker);

        System.out.println(answer);


    }




}

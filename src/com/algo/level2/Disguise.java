package com.algo.level2;

import java.util.HashMap;
import java.util.Set;

/**
 * 위장
 * hash
 * **/

public class Disguise {

    public int solution(int[] s1, int[] s2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for(int i = 0; i<s1.length; ++i){
            map1.put(s1[i], 1);
        }


        for(int j = 0; j<s2.length; ++j){
            map1.put(s2[j], map1.get(s2[j])+1);
        }

        Set<Integer> keys = map1.keySet();
        for(int key : keys){
            if(map1.get(key) == 1){
                return key;
            }
        }
        System.out.println("");
        return 0;
    }

    public static void main(String[] args) {
//        Disguise solution = new Disguise();
//        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
//        int answer = solution.solution(clothes);
//
//        System.out.println(answer);
//        HashMap<Integer, Integer> map1 = new HashMap<>();
//        Set<Integer> keys = map1.keySet()
//
//                 int a = map1.values()




//        int answer = 0;
//        Arrays.sort(s1);
//        Arrays.sort(s2);
//        for(int i=0; i<s1.length; ++i){
//            if(s1[i] != s2[i]){
//                answer = s1[i];
//                break;
//            }
//        }
//        return answer;

    }




}

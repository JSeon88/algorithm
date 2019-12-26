package com.algo.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * 모의고사 / 완전 탐색
 * **/

public class MathAnswer {

    public int[] solution(int[] answers) {
        ArrayList<Integer> list = new ArrayList<>();
        int[][] pattern = {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
        int max = -1;
        int duplicate = 1;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<pattern.length; i++){
            int res = cal(pattern[i], answers);
            map.put(i+1, res);
            if(max == res){
                duplicate++;
            }
            if(max < res){
                max = res;
            }
        }

        int[] result = new int[duplicate];
        int idx = 0;
        Set<Integer> keys = map.keySet();
        for(int key : keys){
            if(max == map.get(key)){
                result[idx] = key;
                idx++;
            }
        }


        return result;

    }

    public int cal(int[] pattern, int[] answers){
        int len = pattern.length;
        int cnt = 0;
        for(int i = 0; i<answers.length; ++i){
            if(pattern[i % len] == answers[i]){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        MathAnswer solution = new MathAnswer();
        //int[] answers = {1,2,3,4,5};
        int[] answers = {6,6,6,6};
        int[] answer = solution.solution(answers);

        for(int i = 0; i<answer.length; ++i){
            System.out.println(answer[i]);
        }

    }




}

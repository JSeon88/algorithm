package com.algo.level2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 기능 개발
 * 스텍/큐
 * **/

public class Progresse {

    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<progresses.length; ++i){
            int cnt = 0;
            for(int j = progresses[i]; j<100; j=j+speeds[i]){
                cnt++;
            }
            list.add(cnt);
        }


        int temp = list.get(0);
        int cnt = 1;
        ArrayList<Integer> newList = new ArrayList<>();
        for(int k = 1; k<list.size(); ++k){
            if(list.get(k) <= temp){
                cnt++;
            }else{
                temp = list.get(k);
                newList.add(cnt);
                cnt = 1;

            }
            if(k == list.size()-1){
                newList.add(cnt);
                break;
            }
        }

        int[] answer = new int[newList.size()];
        for (int i = 0; i < newList.size(); i++) {
            answer[i] = newList.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Progresse solution = new Progresse();
        int[] progresses = {93,30,55};
        int[] speeds = {1,30,5};
        int[] answer = solution.solution(progresses, speeds);

        for(int a : answer){
            System.out.println(a);
        }


    }




}

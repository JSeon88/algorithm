package com.algo.level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 레벨2 / 라면공장
 */
public class NoodleFactory {

    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int cnt = stock;
        int j = 0;
        for(int i = 0; i<k; ++i){

            if(dates[j]  == i){
                if(cnt < dates[j]){
                    cnt += supplies[j];
                    answer++;
                }
                if(j != dates.length-1){
                    j++;
                }

            }
            cnt--;


        }

        return answer;
    }

    public static void main(String[] args){

        int stock = 4;
        int[] dates = {4,10,15};
        int[] supplies = {20,5,10};
        int k = 30;

        NoodleFactory noodleFactory = new NoodleFactory();
        int answer = noodleFactory.solution(stock, dates, supplies, k);

        System.out.println(answer);
    }
}

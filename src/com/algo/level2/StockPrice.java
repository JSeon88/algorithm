package com.algo.level2;

import java.util.ArrayList;

/**
 * 주식가격
 * 스텍/큐
 * **/

public class StockPrice {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0; i<prices.length; ++i){
            int price = prices[i];
            int cnt = 0;
            for(int j = i+1; j<prices.length; ++j){
                if(price <= prices[j]){
                    cnt++;
                }else{
                    cnt++;
                    break;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }

    public static void main(String[] args) {
        StockPrice solution = new StockPrice();
        int[] prices = {1, 2, 3, 2, 3};
        //int[] prices = {5,4,3,5,6,5};
        int[] answer = solution.solution(prices);

        for(int a : answer){
            System.out.println(a);
        }


    }




}

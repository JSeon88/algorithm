package com.algo.dev;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Hippoz {

    public String solution(String s){
        String answer = "";
        String[] temp = s.split(",");
        String[] player1 = temp[0].split("\\s");
        String[] player2 = temp[1].split("\\s");

        Arrays.sort(player1);
        Arrays.sort(player2);

        int player1Res = 6;
        int player2Res = 6;

        // 연속된 숫자인지 확인 - 1st
        int firstNumber1 = Integer.valueOf(player1[0]);
        int len1 = player1.length;
        int firstNumber2 = Integer.valueOf(player2[0]);
        int len2 = player2.length;

        int k = 0;
        for(int i = firstNumber1; i<len1; ++i){
            if(!player1[k].equals(String.valueOf(i))){
                player1Res = 6;
                break;
            }else{
                player1Res = 1;
            }
            k++;
        }

        k = 0;
        for(int i = firstNumber2; i<len2; ++i){
            if(!player2[k].equals(String.valueOf(i))){
                player2Res = 6;
                break;
            }else{
                player2Res = 1;
            }
            k++;
        }

        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();

        // 같은 숫자 count 세기
        for(int j = 0; j<len1; ++j){
            if(!map1.containsKey(player1[j])){
                map1.put(player1[j], 1);
            }else{
                map1.put(player1[j], map1.get(player1[j])+1);
            }
        }

        for(int j = 0; j<len2; ++j){
            if(!map2.containsKey(player2[j])){
                map2.put(player2[j], 1);
            }else{
                map2.put(player2[j], map2.get(player2[j])+1);
            }
        }

        // 배점 계산
        player1Res = cal(map1);
        player2Res = cal(map2);

        // 승패 계산
        if(player1Res == player2Res){
            answer = "Draw";
        }else if(player1Res < player2Res){
            answer = "First";
        }else{
            answer = "Second";
        }

        return answer;
    }

    private int cal(Map<String,Integer> map){
        int res = 6;
        if(map.containsValue(2) && map.containsValue(3)){
            res = 4;
        }else if(map.containsValue(4)){
            res = 3;
        }else if(map.containsValue(2)){
            Set<String> keys = map.keySet();
            for(String key : keys){
                if(map.get(key).equals(2)){
                    map.remove(key);
                    break;
                }
            }
            if(map.containsValue(2)){
                res = 5;
            }
        }else if(map.containsValue(5)){
            res = 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Hippoz solution = new Hippoz();
        //String s  = "3 2 3 2 3,6 1 1 2 3";
        String s  = "5 5 5 5 5,1 1 1 1 1";
        String answer = solution.solution(s);

        System.out.println(answer);

    }
}

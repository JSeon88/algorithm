package com.algo.level1;

import java.util.*;
/**
 * level 1 / 해쉬
 * 완주하지 못한 선수
 * **/

public class NoCompletion {

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i= 0; i<completion.length; ++i){
            if(!participant[i].equals(completion[i])){
                answer = participant[i];
                break;
            }
        }

        if(answer.equals("")){
            answer = participant[participant.length-1];
        }

        return answer;

    }

    public static void main(String[] args) {
        NoCompletion solution = new NoCompletion();
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        String answer = solution.solution(participant, completion);

        System.out.println(answer);
    }




}

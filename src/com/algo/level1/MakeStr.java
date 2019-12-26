package com.algo.level1;

/**
 * 이상한 문자 만들기
 *sp ace -> Sp AcE
 * **/

public class MakeStr {

    public String solution(String s) {
        String answer = "";
        String[] strArr = s.split("\\s+", s.length());
        for(int i = 0; i<strArr.length; ++i){
            if(strArr[i].equals("")){
                answer = answer + " ";
            }else{
                char[] chArr = strArr[i].toCharArray();
                for(int j = 0; j<chArr.length; ++j){
                    // 홀수는 무조건 소문자로
                    if((j & 1) != 0){
                        // 대문자인 경우 소문자로, 소문자인 경우는 그냥 통과
                        if(65<=chArr[j] && chArr[j]<=90) {
                            chArr[j] = (char)(chArr[j]+32);
                        }
                    }else{
                        // 소문자인 경우 대문자로, 대문자인 경우는 그냥 통과
                        if(97<=chArr[j] && chArr[j]<=122) {
                            chArr[j] = (char)(chArr[j]-32);
                        }
                    }
                    answer = answer+chArr[j];
                }
                answer = answer + " ";
            }

        }
        return answer.substring(0, answer.length()-1);
    }

    public static void main(String[] args) {
        MakeStr solution = new MakeStr();
        String answer = solution.solution("AAAAAAAAAAA A A A A AAAAA AAA ");
        //String answer = solution.solution("try hello world");

        System.out.println(answer);
    }




}

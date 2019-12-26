package com.algo.level1;

import java.util.HashMap;

/**
 * 2020 KAKAO BLIND RECRUITMENT
 * 문자열 압축
 * **/

public class Compression {

    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        String beforeTemp = "";
        String afterTemp = "";
        HashMap<Integer, String> map = new HashMap<>();
        int smallLen = 9999;
        if(len == 1){
            return 1;
        }
        for(int i = 1; i<=len/2; ++i){
            String compression = "";
            int cnt = 1;
            for(int j = 0; j<len; j=j+i){
                if(j+i > len){
                    compression += beforeTemp;
                }else{
                    beforeTemp = s.substring(j, j+i);
                    if((j+i)+i > len){
                        String remain = s.substring(j+i);
                        if(cnt == 1){
                            compression += beforeTemp + remain;
                            break;
                        }else{
                            compression += cnt + beforeTemp + remain;
                            break;
                        }
                    }else{
                        afterTemp = s.substring(j+i,(j+i)+i);
                        if(beforeTemp.equals(afterTemp)){
                            cnt++;
                        }else {
                            if(cnt == 1){
                                compression += beforeTemp;
                            }else{
                                compression += cnt + beforeTemp;
                            }
                            cnt = 1;
                        }
                    }
                }

            }
            int compressionLen = compression.length();
            if(smallLen >compressionLen ){
                smallLen = compressionLen;
            }
            map.put(i, compression);
        }

        return smallLen;
    }

    public static void main(String[] args) {
        Compression solution = new Compression();
        //String s  = "abcabcabcabcdededededede";
        //String s  = "xababcdcdababcdcd";
        //String s  = "ababcdcdababcdcd";
        //String s  = "abcabcdede";
        String s  = "a";
        int answer = solution.solution(s);

        System.out.println(answer);

    }




}

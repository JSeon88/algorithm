package com.algo.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 다리를 지나는 트럭
 * 스텍/큐
 * **/

public class test2 {

    public boolean solution(String s1, String s2) {
        boolean answer = true;
        ArrayList<Str> list1 = new ArrayList<>();
        ArrayList<Str> list2 = new ArrayList<>();

        String[] strArr = s1.split("", s1.length());
        String before = strArr[0];
        int beforeIdx = 0;
        list1.add(new Str(strArr[0], 1));

        for(int i = 1; i<s1.length(); ++i){
            if(before.equals(strArr[i])){
               list1.get(beforeIdx).count++;
            }else{
                list1.add(new Str(strArr[i], 1));
                before = strArr[i];
                beforeIdx++;
            }
        }

        String[] strArr2 = s2.split("", s2.length());
        String before2 = strArr2[0];
        int beforeIdx2 = 0;
        list2.add(new Str(strArr2[0], 1));

        for(int i = 1; i<s2.length(); ++i){
            if(before2.equals(strArr2[i])){
                list2.get(beforeIdx2).count++;
            }else{
                list2.add(new Str(strArr2[i], 1));
                before2 = strArr2[i];
                beforeIdx2++;
            }
        }

        int list1Size = list1.size();
        int list2Size = list2.size();

        if(list1Size != list2Size){
            return false;
        }

        for(int k = 0; k<list1.size(); ++k){
            if(!list1.get(k).key.equals(list2.get(k).key)){
                return false;
            }
            if(list1.get(k).count > list2.get(k).count){
                return false;
            }
        }

        return answer;
    }

    class Str{
        public String key;
        public int count;
        public Str(String key, int count){
            this.key = key;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        test2 solution = new test2();
//        String s1= "cookie";
//        String s2= "cooookieee";

        String s1= "cookie";
       String s2= "cokie";
        boolean answer = solution.solution(s1, s2);

        System.out.println(answer);


    }




}

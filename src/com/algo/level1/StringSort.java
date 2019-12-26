package com.algo.level1;

import java.util.*;

public class StringSort {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strings = {"abce", "cdx","abcd" };
        solution.solution(strings, 2);
    }

    static class Solution {
        public String[] solution(String[] strings, int n) {
            String[] answer = {};
            ArrayList<String> arr = new ArrayList<>();
            for (int i = 0; i < strings.length; i++) {
                arr.add("" + strings[i].charAt(n) + strings[i]);
            }
            Collections.sort(arr);
            answer = new String[arr.size()];
            for (int i = 0; i < arr.size(); i++) {
                answer[i] = arr.get(i).substring(1, arr.get(i).length());
            }
            return answer;
        }
    }

}

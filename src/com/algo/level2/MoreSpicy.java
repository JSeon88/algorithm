package com.algo.level2;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 레벨 2 : 더 맵게
 */
public class MoreSpicy {

//    private int[] sort(int[] scoville){
//        boolean flag;
//        do{
//            flag = false;
//            for(int i = 0; i<scoville.length-1; ++i){
//                if(scoville[i] > scoville[i+1]){
//                    int temp = scoville[i+1];
//                    scoville[i+1] = scoville[i];
//                    scoville[i] = temp;
//                    flag = true;
//                }
//            }
//        }while(flag);
//
//        return scoville;
//    }
//
//    public int solution(int[] scoville, int K) {
//        int answer = 0;
//        boolean flag = true;
//
//        do{
//
//            int[] sorted = sort(scoville);
//            if(answer != sorted.length-1){
//                for(int i = 0; i<sorted.length-1; ++i){
//                    if(sorted[i] >= K){
//                        flag = false;
//                        break;
//                    }
//                    if(sorted[i] != -1){
//                        int cal = sorted[i] + (sorted[i+1] *2);
//                        sorted[i] = -1;
//                        sorted[i+1] = cal;
//                        answer++;
//                    }
//                }
//            }else{
//                flag = false;
//            }
//
//        }while(flag);
//
//        return answer;
//    }

    public int solution(int[] scoville, int K) {
        int answer = 0;

        Queue<Integer> queue = new PriorityQueue<>(scoville.length);

        for(int i = 0; i<scoville.length; ++i){
            queue.offer(scoville[i]);
        }

        while(queue.size() > 1){
            if(queue.peek() >= K){
                break;
            }
            int pre = queue.poll();
            int next = queue.poll();
            int cal = pre + (next *2);
            queue.offer(cal);
            answer++;
        }

        // 모든 음식의 스코빌 지수 이상으로 못 만들었으니 -1
        if(queue.poll() < K){
            answer = -1;
        }

        return answer;
    }

    public static void main(String[] args){


        MoreSpicy moreSpicy = new MoreSpicy();

        //int[] scoville = {1, 2, 3, 9, 10, 12};
        //int[] scoville = {1, 2, 3};
        int[] scoville = {1,2,3};
        //int K = 7;
        int K = 14;

        int answer = moreSpicy.solution(scoville, K);

        System.out.println(answer);
    }
}

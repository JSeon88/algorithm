package com.algo.level1;

/**
 * 탐욕법 (Greedy)
 * 체육복
 * **/

public class Greedy {

    public int solution(int n, int[] lost, int[] reserve) {
        int lostLen = lost.length;

//        int k = 0;
//        for(int i = 0; i<lost.length; ++i){
//            int lostStudent = lost[i];
//            for(int j = k; j<reserve.length; ++j){
//                int reserverStudent = reserve[j];
//                if(reserverStudent == lostStudent){
//                    lostLen--;
//                    k++;
//                    break;
//                }
//                if(reserverStudent-1 == lostStudent || lostStudent ==  reserverStudent+1){
//                    lostLen--;
//                    k++;
//                    break;
//                }
//            }
//        }

        // 두개의 여별을 가지고 있는 애들이 잃어버렸을 경우
        int duplicateCnt = 0;
        for(int i = 0; i<lost.length; ++i) {
            int lostStudent = lost[i];
            for (int j = 0; j < reserve.length; ++j) {
                int reserverStudent = reserve[j];
                if(reserverStudent == lostStudent){
                    lost[i] = -1;
                    reserve[j] = -1;
                    // 잃어버렸지만 여벌이 있기 때문에 실질적으로 잃어버린게 아니기 때문에
                    // 따로 인원수 체크.
                    duplicateCnt++;
                    break;
                }
            }
        }

        // 이제 체육복을 빌려주자
        int okCnt = 0;
        for(int i = 0; i<lost.length; ++i) {
            int lostStudent = lost[i];
            for (int j = 0; j < reserve.length; ++j) {
                int reserverStudent = reserve[j];
                if(reserverStudent-1 == lostStudent || lostStudent ==  reserverStudent+1){
                    lost[i] = -1;
                    reserve[j] = -1;
                    // 체육복을 빌리는데 성공한 카운트
                    okCnt++;
                    break;
                }
            }

        }

        int answer = n-lostLen+duplicateCnt+okCnt;
        return answer;
    }

    public static void main(String[] args) {
        Greedy solution = new Greedy();
        int n = 7;
        int[] lost = {2,3,4};
        int[] reserve = {1,2,3,6};
        int answer = solution.solution(n,lost,reserve);

        System.out.println(answer);

    }




}

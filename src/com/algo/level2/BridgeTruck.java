package com.algo.level2;

import java.util.*;

/**
 * 다리를 지나는 트럭
 * 스텍/큐
 * **/

public class BridgeTruck {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> passingBridge = new LinkedList<>();
        Queue<Truck> waitingTruck =  new LinkedList<>();

        for(int i = 0; i<truck_weights.length; ++i){
            waitingTruck.offer(new Truck(truck_weights[i], bridge_length));
        }

        int time = 1;
        int totalWeight = waitingTruck.peek().weight;
        passingBridge.offer(waitingTruck.poll());
        while(!passingBridge.isEmpty()){

            for(Truck truck : passingBridge){
                truck.length--;
            }

            if(passingBridge.peek().length == 0){
                totalWeight -= passingBridge.poll().weight;
            }

            if(!waitingTruck.isEmpty() && waitingTruck.peek().weight + totalWeight <= weight){
                totalWeight += waitingTruck.peek().weight;
                passingBridge.offer(waitingTruck.poll());
            }
            time++;
        }
        return time;
    }

    public class Truck{
        public int weight;
        public int length;

        public Truck(int weight, int length){
            this.weight = weight;
            this.length = length;
        }
    }

    public static void main(String[] args) {
        BridgeTruck solution = new BridgeTruck();
//        int bridge_length = 2;
//        int weight = 10;
//        int[] truck_weights = {7,4,5,6};

//        int bridge_length = 100;
//        int weight = 100;
//        int[] truck_weights = {10};

        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

        int answer = solution.solution(bridge_length, weight,truck_weights);

        System.out.println(answer);


    }




}

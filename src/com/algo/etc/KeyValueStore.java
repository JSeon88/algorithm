package com.algo.etc;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

class TimeOutStore extends TimerTask{

    private String key;

    TimeOutStore(String key){
        this.key = key;
    }

    @Override
    public void run() {
        KeyValueStore.delete(key);
    }
}

public class KeyValueStore {

    private static HashMap<String, String> store = new HashMap<>();

    public static void set(String key, String value){
        store.put(key, value);
    }

    public static String get(String key){
        return store.get(key);
    }

    public static void expire(String key, long seconds){
        if(seconds > 0){
            new Timer().schedule(new TimeOutStore(key), seconds);
        }
    }

    public static void delete(String key){
        if(store.containsKey(key)){
            store.remove(key);
        }
    }

    public static void main(String[] args){
        KeyValueStore.set("aaa","aaa");
        System.out.println(KeyValueStore.get("aaa"));
        KeyValueStore.expire("aaa", 2);

        KeyValueStore.set("bbb","bbb");
        System.out.println(KeyValueStore.get("bbb"));

        KeyValueStore.set("ccc","ccc");
        System.out.println(KeyValueStore.get("ccc"));

        KeyValueStore.set("ddd","ddd");
        System.out.println(KeyValueStore.get("ddd"));

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println(KeyValueStore.get("aaa"));
                timer.cancel();
            }
        };

        timer.schedule(task,1);


    }
}

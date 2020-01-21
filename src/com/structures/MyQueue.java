package com.structures;

public class MyQueue<T> {

    private class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;
    private int size = 0;

    // 등록
    public void offer(T data){
        Node<T> newItem = new Node<>(data);
        if(head == null){
            head = newItem;
        }else{
            Node<T> item = head;
            while(item.next != null){
                item = item.next;
            }
            item.next = newItem;
        }
        size++;
    }

    // 값 내보내기
    public T pop(){
        if(isEmpty()){
            throw new Error("큐에 값이 없습니다.");
        }
        Node<T> item = head;
        head = item.next;
        size--;
        return item.data;
    }

    // 값 확인하기
    public T peek(){
        if(isEmpty()){
            throw new Error("큐에 값이 없습니다.");
        }
        return head.data;
    }

    // 비었는지 확인
    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args){

        MyQueue<Integer> queue = new MyQueue<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        System.out.println(queue.pop());
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());

    }
}

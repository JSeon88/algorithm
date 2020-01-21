package com.structures;

public class MyQueue2<T> {

    private class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data){
            this.data = data;
        }
    }

    private Node<T> first;
    private Node<T> last;

    // 등록
    public void add(T data){
        Node<T> newItem = new Node<>(data);
        if(last != null){
            last.next = newItem;
        }
        last = newItem;
        if(first == null){
            first = last;
        }
    }

    // 값 내보내기
    public T remove(){
        if(isEmpty()){
            throw new Error("큐에 값이 없습니다.");
        }
        Node<T> item = first;
        first = item.next;
        if(first == null){
            last = null;
        }
        return item.data;
    }

    // 값 확인하기
    public T peek(){
        if(isEmpty()){
            throw new Error("큐에 값이 없습니다.");
        }
        return first.data;
    }

    // 비었는지 확인
    public boolean isEmpty(){
        return first == null;
    }

    public static void main(String[] args){

        MyQueue2<Integer> queue = new MyQueue2<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println(queue.remove());
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

    }
}

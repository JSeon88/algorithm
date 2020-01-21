package com.structures;

import java.util.EmptyStackException;

/**
 * 스택 구현
 * @param <T>
 */
public class MyStack<T> {

    private class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data){
            this.data = data;
        }
    }

    private Node<T> top;

    // 등록
    public void push(T data){
        Node<T> newItem = new Node<>(data);
        newItem.next = top;
        top = newItem;
    }

    // 내보내기
    public T pop(){
        if(isEmpty()){
           throw new EmptyStackException();
        }
        T item = top.data;
        top = top.next;
        return item;
    }

    // 값 확인
    public T peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return top.data;
    }

    // 비워있는지 확인
    public boolean isEmpty(){
        return top == null;
    }

    public static void main(String[] args){

        MyStack<Integer> stack = new MyStack<>();
        System.out.println(stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.isEmpty());
        stack.pop();
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
    }

}

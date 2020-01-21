package com.algo.etc;

import java.util.LinkedList;

/**
 * Queue
 * 개와 고양이만 분양하는 분양소
 * 분양 받는 사람은 동물의 종류만 선택 가능
 * 분양소에서 오래 있었던 순으로 자동으로 분양
 */

enum AnimalType{
    Dog, Cat
}

abstract class Animal{
    AnimalType type;
    String name;
    int order;

    Animal(AnimalType type, String name){
        this.type = type;
        this.name = name;
    }

    public int getOrder(){
        return order;
    }

    public void setOrder(int order){
        this.order = order;
    }

    public String toString(){
        return order + ") type : " + type + ", name : " + name;
    }
}

class Cat extends Animal{
    Cat(String name){
        super(AnimalType.Cat, name);
    }
}

class Dog extends Animal{
    Dog(String name){
        super(AnimalType.Dog, name);
    }
}

public class AnimalShelter {

    LinkedList<Cat> cats = new LinkedList<>();
    LinkedList<Dog> dogs = new LinkedList<>();
    int order;
    AnimalShelter(){
        this.order = 1;
    }

    // 동물 등록
    public void enqueue(Animal animal){
        animal.setOrder(order);
        order++;
        if(animal.type == AnimalType.Dog){
            dogs.addLast((Dog) animal);
        }else {
            cats.addLast((Cat) animal);
        }
    }

    // 개 분양
    public Animal dequeueDog(){
        return dogs.poll();
    }

    // 고양이 분양
    public Animal dequeueCat(){
        return cats.poll();
    }

    // 자동 분양
    public Animal dequeue(){

        if(dogs.size() == 0 && cats.size() == 0){
            return null;
        }else if(dogs.size() == 0){
            return cats.poll();
        }else if(cats.size() == 0){
            return dogs.poll();
        }

        Animal dog = dogs.peek();
        Animal cat = cats.peek();

        if(dog.order > cat.order){
            return cats.poll();
        }else{
            return dogs.poll();
        }
    }


    public static void main(String[] args){

        AnimalShelter as = new AnimalShelter();

        Dog dog1 = new Dog("puppy");
        Dog dog2 = new Dog("chichi");
        Dog dog3 = new Dog("choco");
        Cat cat1 = new Cat("shasha");
        Cat cat2 = new Cat("miumiu");
        Cat cat3 = new Cat("gaga");

        as.enqueue(dog1);
        as.enqueue(cat1);
        as.enqueue(dog2);
        as.enqueue(cat2);
        as.enqueue(dog3);
        as.enqueue(cat3);

        System.out.println(as.dequeueCat().toString());
        System.out.println(as.dequeueDog().toString());
        System.out.println(as.dequeue().toString());
        System.out.println(as.dequeue().toString());
        System.out.println(as.dequeue().toString());
        System.out.println(as.dequeue().toString());

    }
}

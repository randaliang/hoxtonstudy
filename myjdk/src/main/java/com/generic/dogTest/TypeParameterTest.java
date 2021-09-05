package com.generic.dogTest;

/**
 * @author randaliang
 * @date 2021-07-18 9:52
 **/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TypeParameterTest {
    //第一种声明：简单，灵活性低
    public static <T extends Comparable<T>> void mySort1(List<T> list) {
        Collections.sort(list);
    }

    //第二种声明：复杂，灵活性高
    public static <T extends Comparable<? super T>> void mySort2(List<T> list) {
        Collections.sort(list);
    }

    public static void main(String[] args) {
        //在这个方法中要创建一个 Animal List 和一个 Dog List，然后分别调用两个排序方法。
        // 创建一个 Animal List
        List<Animal> animals = new ArrayList<Animal>();
        animals.add(new Animal(25));
        animals.add(new Dog(35));

        // 创建一个 Dog List
        List<Dog> dogs = new ArrayList<Dog>();
        dogs.add(new Dog(5));
        dogs.add(new Dog(18));

        // 测试  mySort1() 方法
//        mySort1(animals);
//        mySort1(dogs);
        // 测试  mySort2() 方法
        mySort2(animals);
        mySort2(dogs);
    }
}

class Animal implements Comparable<Animal> {
    protected int age;

    public Animal(int age) {
        this.age = age;
    }

    //使用年龄与另一实例比较大小
    @Override
    public int compareTo(Animal other) {
        return this.age - other.age;
    }
}

class Dog extends Animal {
    public Dog(int age) {
        super(age);
    }
}
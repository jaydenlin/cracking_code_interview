package stack_n_queue;

import java.util.LinkedList;

/**
 * 題目：動物收容所
 * 知識點：
 * 1.紀錄一個特別的值 order 來判斷兩個 Queue 要取那一個
 * 2.LinkedList 可以用來當 Queue
 */
public class NO_3_6 {
}

class Animal {
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    private int order;
    protected String name;

    public Animal(String name){
        this.name = name;
    }
}

class Cat extends Animal{

    public Cat(String name){
        super(name);
    }

}

class Dog extends Animal{

    public Dog(String name){
        super(name);
    }

}

class AnimalQueue{
    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    private int order = 0;

    public void enqueue(Animal a){
        a.setOrder(this.order);
        this.order++;

        if(a instanceof Cat){
            cats.add((Cat)a);
        }

        if(a instanceof Dog){
            dogs.add((Dog)a);
        }
    }

    public Animal dequeueAny(){
        if(dogs.size() == 0) {
            return dequeueCats();
        }
        else if(cats.size() == 0) {
            return dequeueDogs();
        }

        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if(dog.getOrder() > cat.getOrder()) {
            return dequeueCats();
        } else {
            return dequeueDogs();
        }
    }

    public Dog dequeueDogs(){
        return dogs.poll();
    }

    public Cat dequeueCats(){
        return cats.poll();
    }
}

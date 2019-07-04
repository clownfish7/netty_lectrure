package com.yzy.bytebuf;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author yzy
 * @classname AtomicUpdaterTest
 * @description TODO
 * @create 2019-07-04 15:38
 */
public class AtomicUpdaterTest {

    public static void main(String[] args) {
      /*  Person person = new Person();

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(()->{
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(person.age++);
            });
            t.start();
        }*/

      Person person = new Person();

        AtomicIntegerFieldUpdater<Person> updater = AtomicIntegerFieldUpdater.newUpdater(Person.class, "age");
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(updater.getAndIncrement(person));
            });
            t.start();
        }
    }
}

class Person {
    volatile int age = 1;
}

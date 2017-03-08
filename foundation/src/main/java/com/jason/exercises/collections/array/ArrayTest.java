package com.jason.exercises.collections.array;

import java.util.Spliterator;
import java.util.Spliterators;

/**
 * Created by shanshouchen@weibangong.com on 2017/2/13.
 */
public class ArrayTest {
    public static void main(String[] args) {
        Person p1 = new Person("p1");
        Person p2 = new Person("p2");
        Person[] ps1 = new Person[2];
        ps1[0] = p1;
        ps1[1] = p2;


        Person[] ps2 = ps1;
        ps1 = null;

        for (Person person : ps2) {
            System.out.println(person.getName());
        }

        Spliterator.OfDouble ofDouble = Spliterators.emptyDoubleSpliterator();


    }

}

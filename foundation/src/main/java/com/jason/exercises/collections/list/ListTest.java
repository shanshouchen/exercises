package com.jason.exercises.collections.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Spliterator;

/**
 * Created by shanshouchen@weibangong.com on 2017/2/14.
 */
public class ListTest {
    public static void main(String[] args) {
        Collection<Person> people = new ArrayList<Person>();

        people.add(new Person("Jane", "Doe", "Ireland"));
        people.add(new Person("Joe", "Doe", "England"));
        people.add(new Person("John", "Doe", "Scotland"));
        people.add(new Person("Julie", "Doe", "Wales"));
        people.add(new Person("Jerry", "Doe", "France"));
        people.add(new Person("Jim", "Doe", "Italy"));

        Spliterator<Person> peopleSpliterator = people.spliterator();

        Spliterator<Person> newPartition = peopleSpliterator.trySplit();

        System.out.println(" " + newPartition.estimateSize());
        System.out.println(" " + peopleSpliterator.estimateSize());

    }


}

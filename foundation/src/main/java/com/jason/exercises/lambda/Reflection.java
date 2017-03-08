package com.jason.exercises.lambda;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

/**
 * Created by shanshouchen@weibangong.com on 2017/2/15.
 */
public class Reflection {

    public interface Animal {
        default String eat() {
            return this.getClass().getSimpleName()
                    + " eats like an ordinary animal";
        }

        default String sleep() {
            return this.getClass().getSimpleName()
                    + " sleeps like an ordinary animal";
        }

        String go();
    }

    static class Dog implements Animal {

        @Override
        public String go() {
            return "Dog walks on four legs";
        }

        @Override
        public String sleep() {
            return "Dog sleeps";
        }
    }


    public static void main(String[] args) throws NoSuchMethodException {
        Dog dog = new Dog();
        Stream.of(dog.getClass().getMethod("eat"), dog.getClass().getMethod("go"), dog.getClass().getMethod("sleep")).forEach(method -> {
            System.out.println("method name " + method.getName());
            System.out.println("is default " + method.isDefault());
            System.out.println(" invoke ");
            try {
                System.out.println(method.invoke(dog));
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            System.out.println();
        });
    }

}

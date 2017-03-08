package com.jason.exercises.refrect;

/**
 * Created by shanshouchen@weibangong.com on 2017/1/18.
 */
public class Factory {

    public static Fruit getInstance(String ClassName) {
        Fruit f = null;
        try {
            f = (Fruit) Class.forName(ClassName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}

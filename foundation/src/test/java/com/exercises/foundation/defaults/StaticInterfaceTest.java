package com.exercises.foundation.defaults;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by shanshouchen@weibangong.com on 2017/2/15.
 */
public class StaticInterfaceTest {

    @Test
    public void test() {
        Assert.assertEquals("toDublin", TicketOffice.defaultOffice().qDublin());
        Assert.assertEquals("Hello World", TicketOffice.helloworld());
    }

    public interface TicketOffice {
        String qDublin();

        static TicketOffice defaultOffice() {
            return () -> "toDublin";
        }

        static String helloworld() {
            return "Hello World";
        }


    }
}

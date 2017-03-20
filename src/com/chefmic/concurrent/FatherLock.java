package com.chefmic.concurrent;

import org.junit.Test;

/**
 * Created by cyuan on 3/18/17.
 */
public class FatherLock {

    class Widget {

        public synchronized void doSomething() {
            System.out.println("This is Widget");
        }

    }

    class TextWidget extends Widget {

        @Override
        public synchronized void doSomething() {
            System.out.println("This is text widget");
            super.doSomething();
        }

    }

    @Test
    public void testLock() {
        TextWidget widget = new TextWidget();
        widget.doSomething();
    }

}

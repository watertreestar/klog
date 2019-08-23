package com.knife;

import org.junit.Test;

/**
 * @Date 2019/8/22 17:48
 **/
public class ClassNameTest {
    @Test
    public void testName(){
        System.out.println(this.getClass().getName());  // com.knife.ClassNameTest
        System.out.println(this.getClass().getCanonicalName());  // com.knife.ClassNameTest
        System.out.println(this.getClass().getSimpleName());   // ClassNameTest
        System.out.println(this.getClass().getTypeName());  // com.knife.ClassNameTest

        // getCanonicalName() and getName are different on innerClass and array
    }

    public static void main(String[] args) {
        System.out.println(ClassNameTest.class.getName());
        System.out.println(ClassNameTest.class.getCanonicalName());
        System.out.println(ClassNameTest.class.getSimpleName());
        System.out.println(ClassNameTest.class.getTypeName());
    }
}

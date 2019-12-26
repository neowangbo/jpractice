package com.b5wang.jpractice.javase.util;

import java.util.Arrays;

public class ArraysTest {

    public static void main(String[] args){
        int[]  intArr = {1,8,9,4,6,3,2,7,5};
        System.out.println(Arrays.toString(intArr));

        Arrays.sort(intArr);
        System.out.println(Arrays.toString(intArr));
    }

}

package com.b5wang.jpractice.javase.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysTest {

    public static void main(String[] args){
        int[] intArr = {1,8,9,4,6,3,2,7,5};
        System.out.println(Arrays.toString(intArr));

        /**
         * How to sort an array?
         * */
        Arrays.sort(intArr);
        System.out.println(Arrays.toString(intArr));


        /**
         * How to convert int array to integer array?
         * */
        Integer[] integerArr = Arrays.stream(intArr).boxed().toArray(Integer[]::new);
        System.out.println(Arrays.toString(integerArr));
        Arrays.sort(integerArr, );

        /**
         * Convert array to list
         * */
        List<Integer> l = Arrays.asList(intArr);


    }

}

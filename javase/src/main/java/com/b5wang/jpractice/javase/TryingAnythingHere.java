package com.b5wang.jpractice.javase;

import java.util.Random;

public class TryingAnythingHere {

    private static final String MATRIC_TEMPLATE = "campaign_%s{target=\"%d\",result=\"%s\"}\r\n";

    private static final int MAX_TARGETID = 10000;

    private static final String[] RESULTS = {"SUCCESS","FAILED"};

    private static int campaignId = 1;// Start from 1, no maximum limitation

    private static int targetId = 1;// Start from 1, maximum is MAX_TARGETID

    private static Random r = new Random();

    public static void main(String[] args){

        // Num targets has been handled. num is [0,150).
        int num = r.nextInt(150);

        System.out.println("num = " + num);

        for(int i = 0; i < num; i++){
            /**
             * One campaign maximum has MAX_TARGETID targets, so need to increase campaign id, and reset targetId back to 1
             * */
            if(targetId > MAX_TARGETID){
                campaignId ++;
                targetId = 1;
            }

            int resultIndex = r.nextInt(2);
            //System.out.println(String.format(MATRIC_TEMPLATE, campaignId, targetId));
            System.out.println(String.format(MATRIC_TEMPLATE, campaignId, targetId, RESULTS[resultIndex]));

            targetId++;
        }

    }

}

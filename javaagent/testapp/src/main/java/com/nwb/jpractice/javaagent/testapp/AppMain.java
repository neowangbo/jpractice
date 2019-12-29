package com.nwb.jpractice.javaagent.testapp;

import java.util.Scanner;

/**
 * This app simulates the normal java application running actions.
 * Insert, Update, Delete, Quit
 * */
public class AppMain {

    public final static String PROMPT_STRING = "The actions you can do: Insert[i], Update[u], Delete[d], Quit[q]";

    private final static AppActions appActions = new AppActions();

    public static void main(String[] args){
        System.out.println("AppMain has been starting!!!");
        System.out.println(PROMPT_STRING);

        Scanner scanner = new Scanner(System.in);
        String action = null;
        while((action = scanner.next()) != null){
            switch (action){
                case "i":
                    appActions.insert();
                    break;
                case "u":
                    appActions.update();
                    break;
                case "d":
                    appActions.delete();
                    break;
                case "q":
                    System.exit(0);
                default:
                    System.out.println(PROMPT_STRING);
                    continue;
            }
        }
    }

}

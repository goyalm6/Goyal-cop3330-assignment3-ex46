/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution, Exercise 46
 *  Copyright 2021 Mayank Goyal
 */

package ex46;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

class PrintOutput{

    // instance variable map
    private HashMap<String, Integer> map;

    // constructor
    public PrintOutput( HashMap<String, Integer> map) {
        this.map = map;
    }

    //print histogram on screen
    public void printHistogram() {
        // declare arrays to store keys and values
        String keys[] = new String[map.size()];
        Integer values[] = new Integer[map.size()];

        int k=0;

        // iterate through array
        for (Entry<String, Integer> entry : map.entrySet()) {
            keys[k] = entry.getKey();
            values[k++] = entry.getValue();
        }

        // declare another arrays of String and Integer to Store values
        int tempvals[] = new int[map.size()];
        String tempkeys[] = new String[map.size()];
        // duplicate values arrays to tempvals
        for(int i=0;i<values.length;i++) {
            tempvals[i] = values[i];
        }

        // reverse sort values array
        Arrays.sort(values, Collections.reverseOrder());

        // sort keys array according to values array and store in tempkeys
        for(int i=0; i<map.size();i++) {
            int value = values[i];
            for(int j=0; j<tempvals.length;j++) {
                if(value == tempvals[j]) {
                    tempkeys[i] = keys[j];
                    break;
                }
            }
        }

        System.out.println();

        // print histogram
        for(int i=0;i<map.size();i++) {
            int value = map.get(tempkeys[i]);
            System.out.print(tempkeys[i]+" : \t");
            for(int j=0; j<value; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
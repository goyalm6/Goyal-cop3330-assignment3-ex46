/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution, Exercise 46
 *  Copyright 2021 Mayank Goyal
 */

package ex46;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class WordFrequencyFinder {

    public static void main(String[] args) throws FileNotFoundException {

        // create ReadInputFile file object
        ReadInputFile rf = new ReadInputFile();

        //read file
        HashMap<String, Integer> map = rf.readFile();

        // create PrintOutput class object
        PrintOutput po = new PrintOutput(map);

        // print output
        po.printHistogram();
    }
}

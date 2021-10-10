/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution, Exercise 46
 *  Copyright 2021 Mayank Goyal
 */

package ex46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class ReadInputFile{

    // define variables
    private Scanner scanner;
    private File file;

    // constructor
    public ReadInputFile() throws FileNotFoundException {
        // initialize variable
        // pass input file as a parameter
        file = new File("src/main/resources/exercise46_input.txt");
        scanner = new Scanner(file);
    }

    // read file
    public HashMap<String, Integer> readFile()
    {
        HashMap<String, Integer> hMap = new HashMap<String,Integer>();
        // use try and finally block to handle exceptions
        try
        {
            while( scanner.hasNext() )
            {

                // read input whole line
                String input = scanner.nextLine();

                // split words in the file by spaces
                String arr[] = input.split(" ");

                // looping through array of words
                for(int i=0;i<arr.length;i++) {

                    String key = arr[i];
                    // if key is already in map then
                    if(hMap.containsKey(key)) {
                        // update value by 1
                        int value = hMap.get(key);
                        value++;
                        hMap.put(key, value);
                    }
                    else {
                        // else add to the map
                        hMap.put(key, 1);
                    }
                }
            }
        }
        finally
        {
            scanner.close();
        }

        return hMap;
    }
}


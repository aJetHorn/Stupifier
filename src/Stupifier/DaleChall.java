package Stupifier;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DaleChall {
 private String words[];
 
 public DaleChall(String filename){
   words = new String[3000];
   readList(filename);
 }
 
 private void readList(String filename){
  int numWords = 0;
  try{
    BufferedReader in = new BufferedReader(new FileReader(filename));
    String line;
    while ((line = in.readLine()) != null){
      numWords++;
      words[numWords - 1] = line.trim();
   }
  }
  catch (IOException ex){
    System.out.println("There was an error in StringBuilder, check input file(s)");
    System.exit(0);
  }
 }
 
 public boolean isWordOnList(String word){
   for (int i = 0; i < words.length; i++){
     if (word.equalsIgnoreCase(words[i])){
       return true;
     }
   }
   return false;
 }
}
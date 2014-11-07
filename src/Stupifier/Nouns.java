package Stupifier;

//copy of the DaleChall class, can simplify to just DaleChall but made just in case we need to add
//more to this specific class
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Nouns{
  private String [] nouns;
  
  public Nouns(String filename){
    nouns = new String[91000];
    readList(filename);
  }
  private void readList(String filename){
    int numWords = 0;
    try{
      BufferedReader in = new BufferedReader(new FileReader(filename));
      String line;
      while ((line = in.readLine()) != null){
        numWords++;
        nouns[numWords - 1] = line.trim();
      }
    }
    catch (IOException ex){
      System.out.println("There was an error in StringBuilder, check input file(s)");
      System.exit(0);
    }
  }
   public boolean isWordOnList(String word){
   for (int i = 0; i < nouns.length; i++){
     if (word.equalsIgnoreCase(nouns[i])){
       return true;
     }
   }
   return false;
 }
}
package Stupifier;

import java.util.ArrayList;
import java.util.List;

public class Stupifier{
    Text inputText;
    Text outputText;
    
    public Stupifier(Text in){
        this.inputText = in;
    }
    
    public void stupify(){
        outputText = inputText; //preserve input
        //first pass
        ArrayList<Sentence> sentences = outputText.getSentences();
        for (int i = 0; i < sentences.size(); i++){
            ArrayList<Token> tokens = sentences.get(i).getTokens();
            for (int j = 0; j < tokens.size(); j++){
                Token currentToken = tokens.get(j);
<<<<<<< HEAD
                if (currentToken.categoryToString(currentToken.getCategory()).equalsIgnoreCase("Adverb_Adjective_Noun_Verb")){
=======
                //prints token category now, check to make sure it looked for nouns
                System.out.println(currentToken + ": "+currentToken.categoryToString(currentToken.getCategory()));
                if (currentToken.categoryToString(currentToken.getCategory()).equalsIgnoreCase("Adverb_Adjective_Verb") ||
                    currentToken.categoryToString(currentToken.getCategory()).equalsIgnoreCase("Noun")){
>>>>>>> 00c49c6bdb9063a68a8299e44c6ebb5fd36179b5
                    String newWord = findEasierSynonym(currentToken.getValue());
                    System.out.println("Stupified " + currentToken + " to " + newWord);
                    currentToken.setValue(newWord);
                }
            }
        }
    }
    
    public String findEasierSynonym(String s){
        //needs work..
        //for now, compares synonym length, then checks list of dale chall words, then finds shortest synonym in length
        System.out.println(s);
        Thesaurus t = new Thesaurus("mthesaur.txt");
        DaleChall dc = new DaleChall("dalechall.txt");
        if(t.getSynonyms(s.toLowerCase()) != null){
          List<String> syn = t.getSynonyms(s.toLowerCase());
          String small = syn.get(0);
          for(int i = 0; i < syn.size(); i++){
            if(s.length() > syn.get(i).length()){
              if(dc.isWordOnList(syn.get(i))){
                small = syn.get(i);
                break;
              }
              else{
                if(syn.get(i).length() < small.length()){
                  small = syn.get(i);
                }
              }
            }
          }
          s = small;
        }
        else{
          System.out.println(s + " couldn't be stupified any more");
        }
        return s;
    }
    
    public void newInputText(Text in){
        this.inputText = in;
    }
    
    public Text getOutputText(){
        return outputText;
    }
    
    public Text getInputText(){
        return inputText;
    }
}
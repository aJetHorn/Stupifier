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
                
                if (currentToken.categoryToString(currentToken.getCategory()).equalsIgnoreCase("Adverb_Adjective_Noun_Verb")){
                    String newWord = findEasierSynonym(currentToken.getValue());
                    System.out.println("Stupified " + currentToken + " to " + newWord);
                    currentToken.setValue(newWord);
                }
            }
        }
    }
    
    public String findEasierSynonym(String s){
        //needs work..
        //for now, take a random synonym and replace it
        System.out.println(s);
        Thesaurus t = new Thesaurus("mthesaur.txt");
        if(t.getSynonyms(s.toLowerCase()) != null){
        List<String> syn = t.getSynonyms(s.toLowerCase());
        int ran = (int)(Math.random() * syn.size()) + 0;
        s = syn.get(ran);
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
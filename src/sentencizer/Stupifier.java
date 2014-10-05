package sentencizer;

import java.util.ArrayList;

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
                Token currentToken = tokens.get(i);
                if (currentToken.categoryToString(currentToken.getCategory()).equalsIgnoreCase("word")){
                    String newWord = findEasierSynonym(currentToken.getValue());
                    System.out.println("Stupified " + currentToken + " to " + newWord);
                    currentToken.setValue(newWord);
                }
            }
        }
    }
    
    public String findEasierSynonym(String s){
        //needs work..
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
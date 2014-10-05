package sentencizer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Text { //a collection of sentences
    //collection of tokens with terminal punctuation
    //consider edge cases
    
    private ArrayList<Sentence> sentences = new ArrayList<>();
    private String name;
    private String rawText;
    private int index;
    
    public Text(String fileName){ //constructor..
        this.index = 0;
        try {
            BufferedReader input = new BufferedReader(new FileReader(fileName));
            
            StringBuilder sb = new StringBuilder();
            String s;
            while ((s = input.readLine()) != null ) {
                sb.append(s);
            }
            rawText = sb.toString();
            //this is rough, splits on period, exclamation, question mark
            String[] rawSentences = rawText.split("(?<=(!+|\\.+|\\?+))");
            
            Sentencizer sentencizer = new Sentencizer(rawSentences);
            
            while (sentencizer.hasNext()){
                sentences.add(sentencizer.nextSentence());
            }  
        }
        catch (IOException ex)
        {
            System.out.println("There was an error in BufferedReader, check input file(s)");
            System.exit(0);
        }  
    }
    
    public String getName(){ //get name of text
        return name;
    }
    
    public void setName(String s){
        this.name = s;
    }
    
    public int getIndex(){
        return index;
    }
    
    public Sentence getNextSentence(){
        return sentences.get(index++);
    }
    
    public String getRawText(){
        return rawText;
    } 
}

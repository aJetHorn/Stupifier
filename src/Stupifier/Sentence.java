package Stupifier;

import java.util.ArrayList;

public class Sentence{
    public enum SentenceType {IMPERATIVE_DECLARATIVE, EXCLAMATORY, INTERROGATIVE, UNKNOWN};
    
    private ArrayList<Token> tokens = new ArrayList<>();
    private SentenceType type; //type
    private String rawText;
    private int index;
    
    public Sentence(){
       
    }
    public Sentence(String raw){
        this.rawText = raw;
    }
    public Sentence(String raw, SentenceType type){
        this.rawText = raw;
        this.type = type;
        this.index = 0;
        System.out.println("sentence crated with type: " + type);
        System.out.println("time to tokenize");
        Tokenizer tokenizer = new Tokenizer(raw);
        System.out.println("tokenizer created");
          
        while (tokenizer.hasNext()){
            Token nextToken = tokenizer.nextToken();
            System.out.println("Token in sentence: " + nextToken);
            tokens.add(nextToken);
        }
    }
    
    public static String typeToString(SentenceType type){
        switch(type){
            case IMPERATIVE_DECLARATIVE:
                return "Imperative or Declarative";
            case EXCLAMATORY:
                return "Exclamatory";
            case INTERROGATIVE:
                return "Interrogative";
            case UNKNOWN:
                return "Unknown";
            default:
                return "No Value";
        }
    }
    
    public Token getNextToken(){
        return tokens.get(index++);
    }
    
    public ArrayList<Token> getTokens(){
        return tokens;
    }
    
    public SentenceType getType(){
 return type;
    }
    
    public void printTokens(){
        for (int i = 0; i < tokens.size(); i++){
            System.out.println(tokens.get(i));
        }
    }
    public void printRaw(){
        System.out.println(rawText);
    }
    
    @Override
    public String toString(){
        return rawText;
    }
    
    public void setSentenceType(SentenceType type){
 this.type = type;
    }
}

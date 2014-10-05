package sentencizer;

import java.util.ArrayList;

public class Sentence{
    public enum SentenceType {IMPERATIVE_DECLARATIVE, EXCLAMATORY, INTERROGATIVE, UNKNOWN};
    
    private ArrayList<Token> tokens = new ArrayList<>();
    private SentenceType type; //type
    private String raw;
    private int index;
    
    public Sentence(){
       
    }
    public Sentence(String raw){
        this.raw = raw;
    }
    public Sentence(String raw, SentenceType type){
        this.raw = raw;
        this.type = type;
        this.index = 0;
        
        Tokenizer tokenizer = new Tokenizer(raw);
            
        while (tokenizer.hasNext()){
            tokens.add(tokenizer.nextToken());
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
    
    public SentenceType getType(){
	return type;
    }
    
    public void setSentenceType(SentenceType type){
	this.type = type;
    }
}

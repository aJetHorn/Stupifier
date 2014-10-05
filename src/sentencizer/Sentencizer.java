
package sentencizer;

public class Sentencizer {

    private int index = 0;
    private String[] rawSentences;
    
    public static void main(String[] args) {
        //sentencization, tokenization, stupification
    }
    public Sentencizer(){
        
    }
    
    public Sentencizer(String[] rawSentences){
        this.index = 0;
        this.rawSentences = rawSentences;
    }
    
    public Sentence nextSentence(){
        String rawSentence = nextRawSentence();
        if (rawSentence.contains(".")){
           return new Sentence(rawSentence, Sentence.SentenceType.IMPERATIVE_DECLARATIVE); 
        }
        else if (rawSentence.contains("!")){
           return new Sentence(rawSentence, Sentence.SentenceType.EXCLAMATORY);    
        }
        else if (rawSentence.contains("?")){
           return new Sentence(rawSentence, Sentence.SentenceType.INTERROGATIVE); 
        }
        else {
            return new Sentence(rawSentence, Sentence.SentenceType.UNKNOWN);
        }  
    }
    
    public String nextRawSentence(){
        return rawSentences[index++];
    }
    
    public String[] getRawSentences(){
        return rawSentences;
    }
    
    public void setRawSentences(String[] rawSentences){
        this.rawSentences = rawSentences;
    }
    
    public int getIndex(){
        return index;
    }
    
    public void setIndex(int i){
        this.index = i;
    }
    
    public boolean hasNext(){
        return index < rawSentences.length;
    }
}

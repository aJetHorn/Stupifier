package Stupifier;

public class Word extends Token{
    Nouns n = new Nouns("nouns.txt");
    private static final String[] ARTICLES = {"the", "a", "an", "some"};
    private static final String[] PREPOSITIONS = 
    {"about","above","across","after","against","along","among",
        "around","at","before","behind","below","beneath","beside",
        "between","by","down","during","except","for","from","in",
        "in front of","inside","instead of","into","like","near","of",
        "off","on","onto","on top of","out of","outside","over","past",
        "since","through","to","toward","under","underneath","until","up",
        "upon","with","within","without"}; //fill this out
    private static final String[] COORDINATING_CONJUNCTIONS = {"and", "but", "or", "nor", "yet", "so"};
    private static final String[] PERSONAL_PRONOUNS = 
        {"I", "me", "we", "us", "you", "she", "her", "it", "he", "him", "they", "them"};
    private static final String[] RELATIVE_PRONOUNS =
        {"that", "which", "who", "whom", "whose", "whichever", "whoever", "whomever"};
    private static final String[] DEMONSTRATIVE_PRONOUNS =
    {"this", "that", "these", "those"};
     private static final String[] INDEFINITE_PRONOUNS =
     {"anybody", "anyone", "anything", "each", "either", "everybody", "everyone",
     "everything", "neither", "nobody", "no one", "nothing", "one", "somebody",
     "someone", "something", "both", "few", "many", "several", "all", "any",
     "most", "none", "some"};
     private static final String[] REFLEXIVE_PRONOUNS =
     {"myself", "ourselves", "yourself", "yourselves", "himself",
         "herself", "itself", "themselves"};
     private static final String[] INTERROGATIVE_PRONOUNS =
     {"who", "what", "which", "whom", "whose"};
     //no one will not work
     private static final String[] POSSESSIVE_PRONOUNS =
     {"my", "your", "his", "her", "its", "our", "your", "their", "mine", "yours",
        "hers", "ours", "theirs", "yours"};
    
    
    public Word(String w){
        setValue(w);
        classifyWord();
    }
    
    public String toString(){
        return getValue();
    }
    
    public void classifyWord(){ //finds category
        if (arrayContains(ARTICLES, getValue())){
            setCategory(Token.TokenCategory.ARTICLE);
        }
        else if (arrayContains(PREPOSITIONS, getValue())){
            setCategory(Token.TokenCategory.PREPOSITION);
        }
        else if (arrayContains(COORDINATING_CONJUNCTIONS, getValue())){
            setCategory(Token.TokenCategory.CONJUNCTION);
        }
        //yes, the redundancy is purposeful
        else if (arrayContains(PERSONAL_PRONOUNS, getValue())){
            setCategory(Token.TokenCategory.PRONOUN);
        }
        else if (arrayContains(RELATIVE_PRONOUNS, getValue())){
            setCategory(Token.TokenCategory.PRONOUN);
        }
        else if (arrayContains(DEMONSTRATIVE_PRONOUNS, getValue())){
            setCategory(Token.TokenCategory.PRONOUN);
        }
        else if (arrayContains(INDEFINITE_PRONOUNS, getValue())){
            setCategory(Token.TokenCategory.PRONOUN);
        }
        else if (arrayContains(REFLEXIVE_PRONOUNS, getValue())){
            setCategory(Token.TokenCategory.PRONOUN);
        }
        else if (arrayContains(INTERROGATIVE_PRONOUNS, getValue())){
            setCategory(Token.TokenCategory.PRONOUN);
        }
        else if (arrayContains(POSSESSIVE_PRONOUNS, getValue())){
           setCategory(Token.TokenCategory.PRONOUN);
        }
        else if(n.isWordOnList(getValue())){
            setCategory(Token.TokenCategory.NOUN);
        }
        else if (startsWithUppercase(getValue())){
            setCategory(Token.TokenCategory.PROPER_NOUN);
        }
        else{
            setCategory(Token.TokenCategory.ADVERB_ADJECTIVE_VERB);
        }
    }
    
    public boolean arrayContains(String[] array, String element){
        for (int i = 0; i < array.length; i++){
            if (array[i].equalsIgnoreCase(element)){
                return true;
            }
        }
        return false;
    }
    
    public boolean startsWithUppercase(String s){
        if (s.length() == 0){
            return false;
        }
        else{
            String firstChar = s.substring(0,1);
            return firstChar.equals(firstChar.toUpperCase());
        }
    }
}
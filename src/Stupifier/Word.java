package Stupifier;

public class Word{
    private String category = "";
    private String contents = "";
    private static final String[] ARTICLES = {"the", "a", "an", "some"};
    private static final String[] PREPOSITIONS = {}; //fill this out
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
        this.category = "";
        this.contents = w;
        classifyWord();
    }
    
    public String toString(){
        return contents;
    }
    
    public void classifyWord(){ //finds category
        if (arrayContains(ARTICLES, contents)){
            category = "article";
        }
        else if (arrayContains(PREPOSITIONS, contents)){
            category = "preposition";
        }
        else if (arrayContains(COORDINATING_CONJUNCTIONS, contents)){
            category = "conjunction";
        }
        else if (arrayContains(PERSONAL_PRONOUNS, contents)){
            category = "pronoun";
        }
        else if (arrayContains(RELATIVE_PRONOUNS, contents)){
            category = "pronoun";
        }
        else if (arrayContains(DEMONSTRATIVE_PRONOUNS, contents)){
            category = "pronoun";
        }
        else if (arrayContains(INDEFINITE_PRONOUNS, contents)){
            category = "pronoun";
        }
        else if (arrayContains(REFLEXIVE_PRONOUNS, contents)){
            category = "pronoun";
        }
        else if (arrayContains(INTERROGATIVE_PRONOUNS, contents)){
            category = "pronoun";
        }
        else if (arrayContains(POSSESSIVE_PRONOUNS, contents)){
            category = "pronoun";
        }
        else if (startsWithUppercase(contents)){
            category = "proper_noun";
        }
        else{
            category = "noun_or_verb";
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
    
    public String getCategory(){
        return category;
    }
}
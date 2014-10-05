
package Stupifier;

public class Tokenizer { //aka a lexer

    private int index = 0;
    private String rawText;
    private char ch;
    
    public Tokenizer(String rawText){
        this.index = 0;
        this.rawText = rawText;
        this.ch = nextChar();
    }
    
    public Token nextToken(){
        System.out.println("rawtext: " + rawText + " index: " + index);
        System.out.println();
        String currentToken = "";
        String category = "";
        do{
            System.out.println("ch: " + ch);
            System.out.println("category: " + category);
            System.out.println("is whitespace? " + Character.isWhitespace(ch));
            if (Character.isWhitespace(ch)){ //CUT IT
                ch = nextChar();
                return createNewToken(currentToken, category);
            }
            else if (ch == '.' || ch == '?' || ch == '!'){
                if (!(category.equalsIgnoreCase("terminal") ||
                        (category.equalsIgnoreCase("")))){
                    return createNewToken(currentToken, category);
                }
                return createNewToken(ch + "", "terminal");
            }
            else if (!Character.isLetterOrDigit(ch)){ //symbols
                if (!(category.equalsIgnoreCase("symbol") ||
                        (category.equalsIgnoreCase("")))){
                    return createNewToken(currentToken, category);
                }
                category = "symbol";
                currentToken += ch;
            }
            else if (Character.isLetter(ch)){
                if (!(category.equalsIgnoreCase("word") ||
                        (category.equalsIgnoreCase("")))){
                    return createNewToken(currentToken, category);
                }
                category = "word";
                currentToken += ch;
            }
            
            else if (Character.isDigit(ch)){
                if (!(category.equalsIgnoreCase("numeral") ||
                        (category.equalsIgnoreCase("")))){
                    return createNewToken(currentToken, category);
                }
                category = "numeral";
                currentToken += ch;
            }
            else {
                return createNewToken(currentToken, "INVALID");
            }
            if (hasNext()){
              ch = nextChar();
            }
            else{
              return createNewToken(currentToken, "INVALID");
            }
        } while (true);
    }
    
    public Token createNewToken(String cToken, String category){
        System.out.println("token to be created: " + cToken);
        if (category.equalsIgnoreCase("word")){
            return new Token(cToken, Token.TokenCategory.WORD);
        }
        else if (category.equalsIgnoreCase("terminal")){
            return new Token(cToken, Token.TokenCategory.TERMINAL);
        }
        else if (category.equalsIgnoreCase("symbol")){
            return new Token(cToken, Token.TokenCategory.SYMBOL);
        }
        else if (category.equalsIgnoreCase("numeral")){
            return new Token(cToken, Token.TokenCategory.NUMERAL);
        }
        else {
            return new Token(cToken, Token.TokenCategory.INVALID);
        }
    }
    
    public char nextChar(){
        char ch = rawText.charAt(index);
        index++;
        return ch;
    }
    
    public char getChar(){
        return ch;
    }
    public int getIndex(){
        return index;
    }
    
    public void setIndex(int i){
        this.index = i;
    }
    
    public boolean hasNext(){
        return index < rawText.length();
    }
}

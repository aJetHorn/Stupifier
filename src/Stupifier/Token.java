package Stupifier;

public class Token {
	public enum TokenCategory {WORD, TERMINAL, SYMBOL, NUMERAL, INVALID}
	
	private String value;
	private TokenCategory category; //category
	
	public String getValue(){
		return value;
	}
	
	public TokenCategory getCategory(){
		return category;
	}
	
	public void setValue(String val){
		this.value = val;
	}
	
	public void setCategory(TokenCategory cat){
		this.category = cat;
	}
	
	public Token(String val, TokenCategory cat){
		this.value = val;
		this.category = cat;
	}
	
	public Token(){ //default
	}
        
        public String toString(){
            return this.value + " (" + this.category +")";
        }
	
    public static String categoryToString(TokenCategory cat){ //turns expected enum into string
        switch (cat) { 
            case WORD:
                return "Word";
            case TERMINAL:
             return "Terminal";
            case SYMBOL:
             return "Symbol";
             case NUMERAL:
               return "Numeral";
              case INVALID:
               return "Invalid";
             default:
                return "";
		}			
	}
}

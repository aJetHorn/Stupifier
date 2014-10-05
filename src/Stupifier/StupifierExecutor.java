package Stupifier;

public class StupifierExecutor{
    private static final String INPUT_FILE = "text1.txt";
    
    public static void main(String args[]){
        System.out.println("start..");
        Text text = new Text(INPUT_FILE);
        System.out.println("text object created..");
        text.printTokens();
        Stupifier stupifier = new Stupifier(text);
        System.out.println("stupifier created..");
        stupifier.stupify();
        System.out.println("stupification has occured..");
        text.printRawSentences();    
        text.printTokens();
        System.out.println("raw sentences printed..");
    }
}
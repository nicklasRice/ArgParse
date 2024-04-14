import java.util.List;

public class Main{
    public static void main(String[] args) {
        String command = "arg1 arg2 !command !sub-command arg3 \"Hello World\"";
        List<CommandLineTokenizer.Token> tokens = CommandLineTokenizer.tokenize(command);
        tokens.forEach(token -> System.out.println(token));
    }
}
import java.util.List;

public class Main{
    public static void main(String[] args) {
        System.out.println("TEST 1");
        String command = "arg1 arg2 !command !sub-command arg3 \"Hello World\" -value=bob";
        List<CommandLineTokenizer.Token> tokens = CommandLineTokenizer.tokenize(command);
        tokens.forEach(token -> System.out.println(token));

        System.out.println("TEST 2");
        command = "arg1 arg2 !command !sub-command arg3 \"Hello World\" -value=\"bob the great\"";
        tokens = CommandLineTokenizer.tokenize(command);
        tokens.forEach(token -> System.out.println(token));

        System.out.println("TEST 3");
        command = "arg1 arg2 !command !sub-command arg3 \"Hello World\" -value=\'bob the great\'";
        tokens = CommandLineTokenizer.tokenize(command);
        tokens.forEach(token -> System.out.println(token));

        System.out.println("TEST 4");
        command = "arg1 arg2 !command !sub-command arg3 \"Hello World\" -value=\"bob-the-great !\"";
        tokens = CommandLineTokenizer.tokenize(command);
        tokens.forEach(token -> System.out.println(token));

        System.out.println("TEST 5");
        command = "arg1 arg2 !command !sub-command arg3 \"Hello World\" -value=bob-the-great!";
        tokens = CommandLineTokenizer.tokenize(command);
        tokens.forEach(token -> System.out.println(token));

        System.out.println("TEST 6");
        command = "arg1 arg2 !command !sub-command arg3 \"Hello World\" -value=bob!the!great";
        tokens = CommandLineTokenizer.tokenize(command);
        tokens.forEach(token -> System.out.println(token));
    }
}
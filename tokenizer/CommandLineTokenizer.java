import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandLineTokenizer {
    private static final Pattern TOKEN_PATTERN = Pattern.compile("-[^=\\s]+(?:=(?:\"[^\"]*\"|'[^']*'|[^\\s\"']+))?|!\\S+|\"[^\"]*\"|'[^']*'|\\S+");

    public static List<Token> tokenize(String cliInput) {
        List<Token> tokens = new ArrayList<>();
        Matcher matcher = TOKEN_PATTERN.matcher(cliInput);
        while (matcher.find()) {
            String tokenStr = matcher.group();
            if (tokenStr.startsWith("!")) {
                tokens.add(new CommandToken(tokenStr));
            } else if (tokenStr.startsWith("-")) {
                int equalIndex = tokenStr.indexOf('=');
                if (equalIndex != -1) {
                    String name = tokenStr.substring(1, equalIndex);
                    String argument = tokenStr.substring(equalIndex + 1);
                    tokens.add(new NamedArgToken(tokenStr, name, argument));
                } else {
                    tokens.add(new NamedArgToken(tokenStr, tokenStr.substring(1), null));
                }
            } else {
                tokens.add(new PosArgToken(tokenStr));
            }
        }
        return tokens;
    }

    public static sealed class Token permits CommandToken, NamedArgToken, PosArgToken {
        protected String token;

        public Token(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }

        @Override
        public String toString() {
            return String.format("[type: %s, token: %s]", this.getClass().getName(), token);
        }
    }

    public final static class CommandToken extends Token {
        public CommandToken(String token) {
            super(token);
        }
    }

    public final static class NamedArgToken extends Token {
        private String name;
        private String argument;

        public NamedArgToken(String token, String name, String argument) {
            super(token);
            this.name = name;
            this.argument = argument;
        }

        public String getName() {
            return name;
        }

        public String getArgument() {
            return argument;
        }

        @Override
        public String toString() {
            return String.format("[type: %s, token: %s, name: %s, argument: %s]", this.getClass().getName(), token, name, argument == null ? "null" : argument);
        }
    }

    public final static class PosArgToken extends Token {
        public PosArgToken(String token) {
            super(token);
        }
    }
}

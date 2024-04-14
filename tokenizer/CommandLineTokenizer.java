import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandLineTokenizer {
    private static final Pattern TOKEN_PATTERN = Pattern.compile("[^\\s\"']+|\"[^\"]*\"|'[^']*'");

    public static List<Token> tokenize(String CliInput) {
        List<Token> tokens = new ArrayList<>();
        Matcher matcher = TOKEN_PATTERN.matcher(CliInput);
        while (matcher.find()) {
            String tokenStr = matcher.group();
            int startIndex = matcher.start();
            int tokenLength = tokenStr.length();
            tokens.add(new Token(tokenStr, tokenLength, startIndex));
        }
        return tokens;
    }

    public static class Token {
        private String value;
        private int length;
        private int startIndex;

        public Token(String value, int length, int startIndex) {
            this.value = value;
            this.length = length;
            this.startIndex = startIndex;
        }

        public String getValue() {
            return value;
        }

        public int getLength() {
            return length;
        }

        public int getStartIndex() {
            return startIndex;
        }

        @Override
        public String toString() {
            return String.format("[value: %s, length: %d, index: %d]", value, length, startIndex);
        }
    }
}

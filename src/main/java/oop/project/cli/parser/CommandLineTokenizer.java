package oop.project.cli.parser;

import oop.project.cli.exception.ArgParseException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CommandLineTokenizer {
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

    static abstract sealed class Token permits CommandToken, NamedArgToken, PosArgToken {
        protected String token;

        public Token(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }

        abstract public void accept(MatchVisitor m) throws ArgParseException;

        @Override
        public String toString() {
            return String.format("[type: %s, token: %s]", this.getClass().getName(), token);
        }
    }

    final static class CommandToken extends Token {
        public CommandToken(String token) {
            super(token);
        }

        @Override
        public void accept(MatchVisitor m) throws ArgParseException {
            m.match(this);
        }

        public String getName() {
            return "";
        }
    }

    final static class NamedArgToken extends Token {
        private final String name;
        private final String argument;

        public NamedArgToken(String token, String name, String argument) {
            super(token);
            this.name = name;
            this.argument = argument;
        }

        @Override
        public void accept(MatchVisitor m) throws ArgParseException {
            m.match(this);
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

    final static class PosArgToken extends Token {
        public PosArgToken(String token) {
            super(token);
        }

        @Override
        public void accept(MatchVisitor m) throws ArgParseException {
            m.match(this);
        }
    }
}

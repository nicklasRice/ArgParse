package oop.project.cli.parser;

import oop.project.cli.command.Command;
import oop.project.cli.exception.ArgParseException;

import java.util.List;

public final class ArgParser {
    private final Command command;

    public ArgParser(Command command) {
        this.command = command;
    }

    public Namespace parse(String args) throws ArgParseException {
        List<CommandLineTokenizer.Token> tokens = CommandLineTokenizer.tokenize(args);
        MatchVisitor matchVisitor = new MatchVisitor(this.command);
        for (var token : tokens) {
            token.accept(matchVisitor);
        }
        return matchVisitor.getNamespace();
    }

    public Namespace parse(String[] args) throws ArgParseException {
        return parse(String.join(" ", args));
    }
}

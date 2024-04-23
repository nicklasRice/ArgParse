package oop.project.cli.parser;

import oop.project.cli.argument.Argument;
import oop.project.cli.command.Command;
import oop.project.cli.exception.ArgParseException;
import oop.project.cli.exception.ParseException;
import org.checkerframework.checker.units.qual.N;

import java.util.ListIterator;
import java.util.NoSuchElementException;

final class MatchVisitor {
    private Command command;
    private ListIterator<Argument<?>> posArgsIter;
    private Namespace namespace;

    public MatchVisitor(Command command) {
        this.command = command;
        this.posArgsIter = this.command.getPosArgs().listIterator();
        this.namespace = new Namespace(command.getName());
    }

    public void match(CommandLineTokenizer.CommandToken token) throws ArgParseException {
        while (this.posArgsIter.hasNext()) {
            var posArg = this.posArgsIter.next();
            if (!posArg.isSatisfied()) {
                throw new ArgParseException("Argument " + posArg.getIdentifier()
                        + " not satisfied for command " + command.getName());
            }
        }
        Command subcommand = this.command.getSubcommands().get(token.getName());
        if (subcommand == null) {
            throw new ArgParseException("Nonexistent subcommand " + token.getName()
                    + " of command " + command.getName());
        }
        this.command = subcommand;
        this.posArgsIter = this.command.getPosArgs().listIterator();
        this.namespace = this.namespace.createSubnamespace(this.command.getName());
    }

    public void match(CommandLineTokenizer.PosArgToken token) throws ArgParseException {
        try {
            var posArg = this.posArgsIter.next();
            Object val = posArg.convert(token.getToken());
            if (!posArg.isFull()) {
                this.posArgsIter.previous();
            }
            this.namespace.insert(posArg.getIdentifier(), val);
        }
        catch (NoSuchElementException e) {
            throw new ArgParseException("Could not match token " + token.getToken() +
                    " in command " + this.command.getName());
        }
        catch (ParseException e) {
            throw new ArgParseException("Could not parse token " + token.getToken() + " in command "
                    + this.command.getName(), e);
        }
    }

    public void match(CommandLineTokenizer.NamedArgToken token) throws ArgParseException {
        var namedArg = this.command.getNamedArgs().get(token.getName());
        if (namedArg == null) {
            throw new ArgParseException("No such named argument " + token.getName() + " in command " +
                    this.command.getName());
        }
        try {
            Object val = namedArg.convert(token.getArgument());
            this.namespace.insert(namedArg.getIdentifier(), val);
        }
        catch (ParseException e) {
            throw new ArgParseException("Could not parse token " + token.getArgument() +
                    " in command " + this.command.getName(), e);
        }
    }

    public Namespace getNamespace() {
        return this.namespace;
    }
}

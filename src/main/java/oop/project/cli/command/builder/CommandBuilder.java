package oop.project.cli.command.builder;

import oop.project.cli.argument.Argument;
import oop.project.cli.command.Command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandBuilder {
    private String identifier;
    private boolean isNamed = false;
    private String name = "";
    private List<Argument<?>> posArgs = new ArrayList<>();
    private Map<String, Argument<?>> namedArgs = new HashMap<>();
    private Map<String, Command> subcommands = new HashMap<>();

    CommandBuilder(String name) {
        this.name = name;
    }

    public CommandBuilder reset(String identifier) {
        this.identifier = identifier;
        this.posArgs = new ArrayList<>();
        this.namedArgs = new HashMap<>();
        this.subcommands = new HashMap<>();
        return this;
    }

    public CommandBuilder setName(String name) {
        this.isNamed = true;
        this.name = name;
        return this;
    }

    public CommandBuilder addArgument(Argument<?> argument) {
        if (argument.isNamed()) {
            this.namedArgs.put(argument.getName(), argument);
        }
        else {
            this.posArgs.add(argument);
        }
        return this;
    }

    public CommandBuilder addSubcommand(Command subcommand) {
        this.subcommands.put(subcommand.getName(), subcommand);
        return this;
    }

    public Command build() {
        return new Command(this.name, this.posArgs, this.namedArgs, this.subcommands);
    }
}

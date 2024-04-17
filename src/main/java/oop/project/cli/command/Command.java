package oop.project.cli.command;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import oop.project.cli.argument.Argument;

import java.util.List;
import java.util.Map;

public class Command {
    private final String name;
    private final ImmutableList<Argument<?>> posArgs;
    private final ImmutableMap<String, Argument<?>> namedArgs;
    private final ImmutableMap<String, Command> subcommands;

    public Command(String name, List<Argument<?>> posArgs, Map<String, Argument<?>> namedArgs,
                   Map<String, Command> subcommands) {
        this.name = name;
        this.posArgs = ImmutableList.copyOf(posArgs);
        this.namedArgs = ImmutableMap.copyOf(namedArgs);
        this.subcommands = ImmutableMap.copyOf(subcommands);
    }

    public String getName() {
        return this.name;
    }

    public ImmutableList<Argument<?>> getPosArgs() {
        return this.posArgs;
    }

    public ImmutableMap<String, Argument<?>> getNamedArgs() {
        return this.namedArgs;
    }

    public ImmutableMap<String, Command> getSubcommands() {
        return this.subcommands;
    }
}

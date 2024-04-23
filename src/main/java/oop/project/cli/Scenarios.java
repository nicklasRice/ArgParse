package oop.project.cli;

import oop.project.cli.argument.builder.FloatArgBuilder;
import oop.project.cli.argument.builder.IntegerArgBuilder;
import oop.project.cli.command.builder.CommandBuilder;
import oop.project.cli.exception.ArgParseException;
import oop.project.cli.parser.ArgParser;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

public class Scenarios {

    /**
     * Parses and returns the arguments of a command (one of the scenarios
     * below) into a Map of names to values. This method is provided as a
     * starting point that works for most groups, but depending on your command
     * structure and requirements you may need to make changes to adapt it to
     * your needs - use whatever is convenient for your design.
     */
    public static Map<String, Object> parse(String command) {
        //This assumes commands follow a similar structure to unix commands,
        //e.g. `command [arguments...]`. If your project uses a different
        //structure, e.g. Lisp syntax like `(command [arguments...])`, you may
        //need to adjust this a bit to work as expected.
        var split = command.split(" ", 2);
        var base = split[0];
        var arguments = split.length == 2 ? split[1] : "";
        return switch (base) {
            case "add" -> add(arguments);
            case "sub" -> sub(arguments);
            case "sqrt" -> sqrt(arguments);
            case "calc" -> calc(arguments);
            case "date" -> date(arguments);
            default -> throw new IllegalArgumentException("Unknown command.");
        };
    }

    /**
     * Takes two positional arguments:
     *  - {@code left: <your integer type>}
     *  - {@code right: <your integer type>}
     */
    private static Map<String, Object> add(String arguments) {
        //TODO: Parse arguments and extract values.
        int left;
        int right;

        CommandBuilder commandBuilder = new CommandBuilder("add");
        IntegerArgBuilder argBuilder = new IntegerArgBuilder("num1");
        commandBuilder.addArgument(argBuilder.build());
        argBuilder.reset("num2");
        commandBuilder.addArgument(argBuilder.build());
        var parser = new ArgParser(commandBuilder.build());
        try {
            var res = parser.parse(arguments);
            left = (int) res.get("num1");
            right = (int) res.get("num2");
        }
        catch (ArgParseException e) {
            throw new RuntimeException(e);
        }
        return Map.of("left", left, "right", right);
    }

    /**
     * Takes two <em>named</em> arguments:
     *  - {@code left: <your decimal type>} (optional)
     *     - If your project supports default arguments, you could also parse
     *       this as a non-optional decimal value using a default of 0.0.
     *  - {@code right: <your decimal type>} (required)
     */
    static Map<String, Object> sub(String arguments) {
        //TODO: Parse arguments and extract values.

        Optional<Float> left = Optional.empty();
        float right = 0.F;

        CommandBuilder commandBuilder = new CommandBuilder("sub");
        FloatArgBuilder argBuilder = new FloatArgBuilder("num1");
        argBuilder.setName("left");
        commandBuilder.addArgument(argBuilder.build());
        argBuilder.reset("num2");
        argBuilder.setName("right");
        commandBuilder.addArgument(argBuilder.build());
        var parser = new ArgParser(commandBuilder.build());
        try {
            var res = parser.parse(arguments);
            left = Optional.of((Float) res.get("num1"));
            right = (float) res.get("num2");
        }
        catch (ArgParseException e) {
            throw new RuntimeException(e);
        }

        return Map.of("left", left.get(), "right", right);
    }

    /**
     * Takes one positional argument:
     *  - {@code number: <your integer type>} where {@code number >= 0}
     */
    static Map<String, Object> sqrt(String arguments) {
        //TODO: Parse arguments and extract values.
        int number = 0;

        CommandBuilder commandBuilder = new CommandBuilder("sqrt");
        IntegerArgBuilder argBuilder = new IntegerArgBuilder("number");
        commandBuilder.addArgument(argBuilder.build());

        var parser = new ArgParser(commandBuilder.build());
        try {
            var res = parser.parse(arguments);
            number = (int) res.get("number");

        } catch (ArgParseException e) {
            throw new RuntimeException("Invalid argument.");
        }
        return Map.of("number", number);
    }

    /**
     * Takes one positional argument:
     *  - {@code subcommand: "add" | "div" | "sqrt" }, aka one of these values.
     *     - Note: Not all projects support subcommands, but if yours does you
     *       may want to take advantage of this scenario for that.
     */
    static Map<String, Object> calc(String arguments) {
        //TODO: Parse arguments and extract values.
        String subcommand = "";
        return Map.of("subcommand", subcommand);
    }

    /**
     * Takes one positional argument:
     *  - {@code date: Date}, a custom type representing a {@code LocalDate}
     *    object (say at least yyyy-mm-dd, or whatever you prefer).
     *     - Note: Consider this a type that CANNOT be supported by your library
     *       out of the box and requires a custom type to be defined.
     */
    static Map<String, Object> date(String arguments) {
        //TODO: Parse arguments and extract values.
        LocalDate date = LocalDate.EPOCH;
        return Map.of("date", date);
    }

    //TODO: Add your own scenarios based on your software design writeup. You
    //should have a couple from pain points at least, and likely some others
    //for notable features. This doesn't need to be exhaustive, but this is a
    //good place to test/showcase your functionality in context.

}

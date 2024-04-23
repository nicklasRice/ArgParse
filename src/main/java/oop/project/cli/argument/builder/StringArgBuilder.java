package oop.project.cli.argument.builder;

import oop.project.cli.argument.Argument;
import oop.project.cli.argument.StringArgument;
import oop.project.cli.exception.ArgBuildException;
import oop.project.cli.exception.ParseException;

public class StringArgBuilder extends BaseArgBuilder<String>{
    public StringArgBuilder(String identifier) {
        super(identifier);
    }

    @Override
    public final Argument<String> build() throws ArgBuildException {
        return new StringArgument(identifier, isNamed, name, validators, hasDefault, defaultVal.toString(), help);
    }
}

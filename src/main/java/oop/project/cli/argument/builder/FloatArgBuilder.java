package oop.project.cli.argument.builder;

import oop.project.cli.argument.Argument;
import oop.project.cli.argument.FloatArgument;
import oop.project.cli.exception.ArgBuildException;

public class FloatArgBuilder extends BaseArgBuilder<Float> {
    public FloatArgBuilder(String identifier) {
        super(identifier);
    }

    @Override
    public FloatArgument build() throws ArgBuildException {
        return new FloatArgument(identifier, isNamed, name, validators, hasDefault, defaultVal, help);
    }
}

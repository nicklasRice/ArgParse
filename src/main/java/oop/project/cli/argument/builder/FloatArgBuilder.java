package oop.project.cli.argument.builder;

import oop.project.cli.argument.Argument;
import oop.project.cli.argument.FloatArgument;
import oop.project.cli.exception.ArgBuildException;

public abstract class FloatArgBuilder extends BaseArgBuilder<Float> {
    FloatArgBuilder(String identifier) {
        super(identifier);
    }

    @Override
    public FloatArgument build() throws ArgBuildException {
        return new FloatArgument(identifier, isNamed, name, validators, hasDefault, Float.parseFloat(defaultVal.toString()), help);
    }
}

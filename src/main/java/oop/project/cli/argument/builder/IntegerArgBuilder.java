
package oop.project.cli.argument.builder;

import oop.project.cli.argument.IntegerArgument;
import oop.project.cli.exception.ArgBuildException;

public final class IntegerArgBuilder extends BaseArgBuilder<Integer> {
    public IntegerArgBuilder(String identifier) {
        super(identifier);
    }

    public IntegerArgument build() throws ArgBuildException {
        return new IntegerArgument(identifier, isNamed, name, validators, hasDefault, defaultVal, help);
    }
}

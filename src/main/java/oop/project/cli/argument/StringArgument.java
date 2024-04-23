package oop.project.cli.argument;

import oop.project.cli.argument.validator.Validator;
import oop.project.cli.exception.*;
import java.util.List;


public class StringArgument extends BaseArgument<String> {
    public StringArgument(String identifier, boolean isNamed, String name, List<Validator<String>> validators,
                           boolean hasDefault, String defaultVal, String help) throws ArgBuildException {
        super(identifier, isNamed, name, validators, hasDefault, defaultVal, help, NArgs.ExactlyN, 1);
    }

    private boolean satisfied = false;

    @Override
    public String convert(String str) throws ParseException {
        try {
            this.validate(str);
            this.satisfied = true;
            return str;
        }
        catch (ValidateException e) {
            throw new ParseException("Error while validating the value parsed from " + str + " in argument " +
                    (this.isNamed() ? this.getName() : this.getIdentifier()), e);
        }
    }

    @Override
    public boolean isSatisfied() {
        if (this.isNamed()) {
            return true;
        }
        return this.satisfied;
    }

    @Override
    public boolean isFull() {
        return this.isSatisfied();
    }
}

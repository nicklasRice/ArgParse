package oop.project.cli.argument;

import oop.project.cli.argument.validator.Validator;
import oop.project.cli.exception.*;
import java.util.List;


public class IntegerArgument extends BaseArgument<Integer> {
    public IntegerArgument(String identifier, boolean isNamed, String name, List<Validator<Integer>> validators,
                           boolean hasDefault, Integer defaultVal, String help) throws ArgBuildException {
        super(identifier, isNamed, name, validators, hasDefault, defaultVal, help, NArgs.ExactlyN, 1);
    }

    private boolean satisfied = false;

    @Override
    public Integer convert(String str) throws ParseException {
        try {
            Integer value = Integer.parseInt(str);
            this.validate(value);
            this.satisfied = true;
            return value;
        } catch (NumberFormatException e) {
            throw new ParseException(String.format("Could not convert argument %s to Integer: %s",
                    getIdentifier(), e.getMessage()), e);
        } catch (ValidateException e) {
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

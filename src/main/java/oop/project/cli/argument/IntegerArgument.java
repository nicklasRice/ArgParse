package oop.project.cli.argument;

import oop.project.cli.argument.validator.Validator;
import oop.project.cli.exception.*;
import java.util.List;


public class IntegerArgument extends BaseArgument<Integer> {

    private Integer value;

    public IntegerArgument(String identifier, boolean isNamed, String name, List<Validator<Integer>> validators,
                           boolean hasDefault, Integer defaultVal, String help) throws ArgBuildException {
        super(identifier, isNamed, name, validators, hasDefault, defaultVal, help);
    }

    @Override
    public Integer convert(String str) throws ParseException {
        try {
            this.value = Integer.parseInt(str);
            return this.value;
        } catch (NumberFormatException e) {
            throw new ParseException(String.format("Could not convert argument %s to Integer: %s",
                    getIdentifier(), e.getMessage()), e);
        }
    }

    @Override
    protected void validate(Integer val) throws ArgParseException {
        super.validate(val);
    }

    // ? I am assuming we just want to check if there is a value.
    @Override
    public boolean isSatisfied() {
        return this.value != null || hasDefault();
    }

}

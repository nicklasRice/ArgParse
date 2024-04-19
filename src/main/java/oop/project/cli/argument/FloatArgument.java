package oop.project.cli.argument;

import oop.project.cli.validator.Validator;
import oop.project.cli.exception.*;
import java.util.List;


public class FloatArgument extends BaseArgument<Float> {

    private Float value;

    public FloatArgument(String identifier, boolean isNamed, String name, List<Validator<Float>> validators,
                           boolean hasDefault, Float defaultVal, String help) throws ArgBuildException {
        super(identifier, isNamed, name, validators, hasDefault, defaultVal, help);
    }

    @Override
    public Float convert(String str) throws ParseException {
        try {
            this.value = Float.parseFloat(str);
            return this.value;
        } catch (NumberFormatException e) {
            throw new ParseException(String.format("Could not convert argument %s to Float: %s",
                    getIdentifier(), e.getMessage()), e);
        }
    }

    @Override
    protected void validate(Float val) throws ArgParseException {
        super.validate(val);
    }

    // ? I am assuming we just want to check if there is a value.
    @Override
    public boolean isSatisfied() {
        return this.value != null || hasDefault();
    }

}

package oop.project.cli.argument;

import oop.project.cli.argument.validator.Validator;
import oop.project.cli.exception.*;
import java.util.List;


public class FloatArgument extends BaseArgument<Float> {
    public FloatArgument(String identifier, boolean isNamed, String name, List<Validator<Float>> validators,
                           boolean hasDefault, Float defaultVal, String help) throws ArgBuildException {
        super(identifier, isNamed, name, validators, hasDefault, defaultVal, help, NArgs.ExactlyN, 1);
    }

    private boolean satisfied = false;

    @Override
    public Float convert(String str) throws ParseException {
        try {
            Float value = Float.parseFloat(str);
            this.validate(value);
            this.satisfied = true;
            return value;
        } catch (NumberFormatException e) {
            throw new ParseException("Error while parsing " + str + " in argument " +
                    (this.isNamed() ? this.getName() : this.getIdentifier()));
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

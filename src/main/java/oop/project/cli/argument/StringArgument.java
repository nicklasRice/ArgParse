package oop.project.cli.argument;

import oop.project.cli.argument.validator.Validator;
import oop.project.cli.exception.*;
import java.util.List;


public class StringArgument extends BaseArgument<String> {

    private String value;

    public StringArgument(String identifier, boolean isNamed, String name, List<Validator<String>> validators,
                           boolean hasDefault, String defaultVal, String help) throws ArgBuildException {
        super(identifier, isNamed, name, validators, hasDefault, defaultVal, help);
    }

    @Override
    public String convert(String str) throws ParseException {
        this.value = str;
        return this.value;
    }

    @Override
    protected void validate(String val) throws ArgParseException {
        super.validate(val);
    }

    // ? I am assuming we just want to check if there is a value.
    @Override
    public boolean isSatisfied() {
        return this.value != null || hasDefault();
    }

}

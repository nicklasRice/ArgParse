package oop.project.cli.argument.builder;

import oop.project.cli.argument.Argument;
import oop.project.cli.validator.Validator;

public interface ArgBuilder<T> {
    ArgBuilder<T> reset(String identifier);
    ArgBuilder<T> setName(String name);
    ArgBuilder<T> addValidation(Validator<T> validator);
    ArgBuilder<T> setDefault(T defaultVal);
    ArgBuilder<T> setHelp(String help);
    Argument<T> build();
}

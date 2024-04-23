package oop.project.cli.argument.builder;

import oop.project.cli.argument.Argument;

import oop.project.cli.exception.ArgBuildException;

import oop.project.cli.argument.NArgs;
import oop.project.cli.argument.validator.Validator;
import oop.project.cli.exception.ArgBuildException;


public interface ArgBuilder<T> {
    ArgBuilder<T> reset(String identifier);
    ArgBuilder<T> setName(String name);
    ArgBuilder<T> addValidation(Validator<T> validator);
    ArgBuilder<T> setDefault(T defaultVal);
    ArgBuilder<T> setHelp(String help);

    ArgBuilder<T> setNArgs(NArgs type);
    ArgBuilder<T> setNArgs(Integer n);
    Argument<T> build() throws ArgBuildException;
}

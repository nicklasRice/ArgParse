package oop.project.cli.argument.validator;

import oop.project.cli.exception.ValidateException;

public interface Validator<T> {
    void validate(T val) throws ValidateException;
}

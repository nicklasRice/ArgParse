package oop.project.cli.argument.validator;

import oop.project.cli.exception.ValidateException;

import java.util.List;

public class ChoicesValidator<T> implements Validator<T> {
    List<T> choices;
    public ChoicesValidator(List<T> choices) {
        this.choices = choices;
    }

    @Override
    public void validate(T val) throws ValidateException {
        if (!choices.contains(val)) {
            throw new ValidateException("Value not in provided choices");
        }
    }
}

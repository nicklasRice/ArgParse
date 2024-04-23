package oop.project.cli.argument.validator;

import oop.project.cli.exception.ValidateException;
import java.lang.Integer;

public class IntInRange<Integer> implements Validator<Integer> {
    java.lang.Integer min;
    java.lang.Integer max;

    public IntInRange(java.lang.Integer min, java.lang.Integer max) {
        this.min = min;
        this.max = max;
    }

    public void validate(java.lang.Integer val) throws ValidateException {
        if ((val.compareTo(java.lang.Integer.MIN_VALUE)) < 0 || (val.compareTo(java.lang.Integer.MAX_VALUE) > 0)) {
            throw new ValidateException("Value out of range");
        }
    }

    @Override
    public void validate(Integer val) throws ValidateException {
        validate((java.lang.Integer.valueOf(val.toString())));
    }
}

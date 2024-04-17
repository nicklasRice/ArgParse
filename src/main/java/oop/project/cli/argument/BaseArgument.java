package oop.project.cli.argument;

import com.google.common.collect.ImmutableList;
import oop.project.cli.exception.ArgBuildException;
import oop.project.cli.exception.ArgParseException;
import oop.project.cli.exception.ValidateException;
import oop.project.cli.validator.Validator;

import java.util.List;

public abstract class BaseArgument<T> implements Argument<T> {
    private final String identifier;
    private final boolean isNamed;
    private final String name;
    private final ImmutableList<Validator<T>> validators;
    private final boolean hasDefault;
    private final T defaultVal;
    private final String help;

    BaseArgument(String identifier, boolean isNamed, String name, List<Validator<T>> validators, boolean hasDefault,
                 T defaultVal, String help) throws ArgBuildException {
        if (!isNamed && hasDefault) {
            throw new ArgBuildException(String.format("Argument %s is positional but has a default",
                    identifier));
        }
        this.identifier = identifier;
        this.isNamed = isNamed;
        this.name = name;
        this.validators = ImmutableList.copyOf(validators);
        this.hasDefault = hasDefault;
        this.defaultVal = defaultVal;
        this.help = help;
    }

    @Override
    public final String getIdentifier() {
        return this.identifier;
    }

    @Override
    public final boolean isNamed() {
        return this.isNamed;
    }

    @Override
    public final String getName() {
        return this.name;
    }

    @Override
    public final boolean hasDefault() {
        return this.hasDefault;
    }

    @Override
    public final T getDefault() {
        return this.defaultVal;
    }

    @Override
    public final String getHelp() {
        return this.help;
    }

    protected void validate(T val) throws ArgParseException {
        for (var validator : this.validators) {
            try {
                validator.validate(val);
            } catch (ValidateException e) {
                throw new ArgParseException(String.format("Error while parsing argument %s", this.identifier), e);
            }
        }
    }
 }
package oop.project.cli.argument.builder;

import oop.project.cli.validator.Validator;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseArgBuilder<T> implements ArgBuilder<T> {
    protected String identifier;
    protected boolean isNamed;
    protected String name;
    protected List<Validator<T>> validators = new ArrayList<>();
    protected boolean hasDefault = false;
    protected T defaultVal = null;
    protected String help = "";

    BaseArgBuilder(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public BaseArgBuilder<T> reset(String identifier) {
        this.identifier = identifier;
        this.isNamed = false;
        this.name = "";
        this.validators = new ArrayList<>();
        this.hasDefault = false;
        this.defaultVal = null;
        this.help = "";
        return this;
    }

    @Override
    public final BaseArgBuilder<T> setName(String name) {
        this.isNamed = true;
        this.name = name;
        return this;
    }

    @Override
    public final BaseArgBuilder<T> addValidation(Validator<T> validator) {
        this.validators.add(validator);
        return this;
    }

    @Override
    public final BaseArgBuilder<T> setDefault(T defaultVal) {
        this.hasDefault = true;
        this.defaultVal = defaultVal;
        return this;
    }

    @Override
    public final BaseArgBuilder<T> setHelp(String help) {
        this.help = help;
        return this;
    }
}

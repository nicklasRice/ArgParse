package oop.project.cli.argument.builder;

import oop.project.cli.argument.NArgs;
import oop.project.cli.argument.validator.Validator;

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
    protected NArgs nArgsType = NArgs.ExactlyN;
    protected Integer nArgs = 1;

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
        this.nArgsType = NArgs.ExactlyN;
        this.nArgs = 1;
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

    @Override
    public final BaseArgBuilder<T> setNArgs(NArgs nArgs) {
        this.nArgsType = nArgs;
        return this;
    }

    @Override
    public final BaseArgBuilder<T> setNArgs(Integer n) {
        this.nArgsType = NArgs.ExactlyN;
        this.nArgs = n;
        return this;
    }
}

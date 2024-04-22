/*
package oop.project.cli.argument.builder;

import oop.project.cli.argument.Argument;
import oop.project.cli.validator.Validator;

import java.util.ArrayList;

public class IntegerArgumentBuilder extends BaseArgBuilder<Integer> {

    IntegerArgumentBuilder(String identifier) {
        super(identifier);
        this.identifier = identifier;
    }
    @Override
    public BaseArgBuilder<Integer> reset(String identifier) {
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
    public final BaseArgBuilder<Integer> setName(String name) {
        this.isNamed = true;
        this.name = name;
        return this;
    }

    @Override
    public final BaseArgBuilder<Integer> addValidation(Validator<Integer> validator) {
        this.validators.add(validator);
        return this;
    }

    @Override
    public final BaseArgBuilder<Integer> setDefault(Integer defaultVal) {
        this.hasDefault = true;
        this.defaultVal = defaultVal;
        return this;
    }

    @Override
    public final BaseArgBuilder<Integer> setHelp(String help) {
        this.help = help;
        return this;
    }
    
    @Override
    public Argument<Integer> build() {
        return null;
    }
}
*/

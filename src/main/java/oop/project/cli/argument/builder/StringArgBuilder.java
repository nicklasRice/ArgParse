package oop.project.cli.argument.builder;

import oop.project.cli.argument.Argument;
import oop.project.cli.argument.StringArgument;
import oop.project.cli.exception.ArgBuildException;
import oop.project.cli.exception.ParseException;

public class StringArgBuilder extends BaseArgBuilder{
    StringArgBuilder(String identifier) {
        super(identifier);
    }

    @Override
    public final Argument<String> build() throws ArgBuildException {
        return new StringArgument(identifier, isNamed, name, validators, hasDefault, defaultVal.toString(), help);
        /*String defaultVal;
        return new StringArgument(
                identifier = this.identifier,
                isNamed = this.isNamed,
                name = this.name,
                validators = this.validators,
                hasDefault = this.hasDefault,
                defaultVal = this.defaultVal.toString(),
                setDefault(this.defaultVal);
                help = this.help
        );*/
            /*@Override
            public String getIdentifier() {
                return this.getIdentifier();
            }

            @Override
            public boolean isNamed() {
                return false;
            }

            @Override
            public String getName() {
                return null;
            }

            @Override
            public String convert(String str) throws ParseException {
                return null;
            }

            @Override
            public boolean hasDefault() {
                return false;
            }

            @Override
            public String getDefault() {
                return null;
            }

            @Override
            public String getHelp() {
                return null;
            }

            @Override
            public boolean isSatisfied() {
                return false;
            }
        };
        return null;
    }*/
    }
}

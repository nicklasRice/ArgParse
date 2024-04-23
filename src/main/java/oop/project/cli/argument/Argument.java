package oop.project.cli.argument;

import oop.project.cli.exception.ParseException;

public interface Argument<T> {
    String getIdentifier();
    boolean isNamed();
    String getName();
    T convert(String str) throws ParseException;
    boolean hasDefault();
    T getDefault();
    String getHelp();
    boolean isSatisfied();
    boolean isFull();
}

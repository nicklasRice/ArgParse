package oop.project.cli.parser;

import java.util.Map;

public final class Namespace {
    private final String name;
    private Map<String, Object> parseResults;
    private Namespace subnamespace;

    Namespace(String name) {
        this.name = name;
    }

    void insert(String name, Object value) {
        this.parseResults.put(name, value);
    }

    Namespace createSubnamespace(String name) {
        this.subnamespace = new Namespace(name);
        return this.subnamespace;
    }
}

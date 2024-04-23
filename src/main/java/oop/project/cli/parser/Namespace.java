package oop.project.cli.parser;

import java.util.Map;

public final class Namespace {
    private final String name;
    private Map<String, Object> parseResults;
    private Namespace subnamespace = null;

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

    public String getName() {
        return this.name;
    }

    public Object get(String str) {
        return this.parseResults.get(str);
    }

    public Namespace getSubnamespace() {
        return this.subnamespace;
    }

    public Namespace getNamespace(String str) {
        if (this.name.compareTo(str) == 0) {
            return this;
        }
        var subnamespace = this.subnamespace;
        while (subnamespace.getName().compareTo(str) != 0) {
            if (subnamespace.getSubnamespace() == null) {
                return null;
            }
            subnamespace = subnamespace.getSubnamespace();
        }
        return subnamespace;
    }
}

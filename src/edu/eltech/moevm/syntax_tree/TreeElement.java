package edu.eltech.moevm.syntax_tree;

import java.util.List;

/**
 * Created by vladimir on 31.10.15.
 */
public abstract class TreeElement {
    protected TreeElement parent;
    protected Type type;
    protected String value;

    public final String getValue() {
        return value;
    }

    public final Type getType() {
        return type;
    }

    public void add(TreeElement element) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public List<TreeElement> getElements() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public final TreeElement getParent() {
        return parent;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
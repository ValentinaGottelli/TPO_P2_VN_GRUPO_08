package org.tp0.implementations;

import org.tp0.models.Set;
import org.tp0.models.Stack;

public class StackBuilder {
    private Stack stack;

    public StackBuilder() {
        this.stack = new StaticStack();
    }

    public StackBuilder add(int a) {
        this.stack.add(a);
        return this;
    }

    public StackBuilder addAll(Set set) {
        Set copySet = StaticSet.copy(set);

        while (!copySet.isEmpty()) {
            this.stack.add(copySet.choose());
            copySet.remove(copySet.choose());
        }

        return this;
    }

    public Stack build() {
        return this.stack;
    }
}

package org.tp0.implementations.ejercicioCuatro;

import org.tp0.implementations.ejercicioDos.StaticSet;
import org.tp0.models.Set;

public class SetBuilder {
    private Set set;

    public SetBuilder() {
        this.set = new StaticSet();
    }

    public SetBuilder add(int a) {
        this.set.add(a);
        return this;
    }

    public SetBuilder addAll(Set otherSet) {
        Set copySet = StaticSet.copy(otherSet);

        while (!copySet.isEmpty()) {
            this.set.add(copySet.choose());
            copySet.remove(copySet.choose());
        }

        return this;
    }

    public Set build() {
        return this.set;
    }
}
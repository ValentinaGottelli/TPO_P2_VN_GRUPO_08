package org.tp0.implementations.ejercicioCinco;

import org.tp0.implementations.ejercicioDos.StaticSet;
import org.tp0.models.ICollection;
import org.tp0.models.Set;

public class CollectionBuilder<T extends ICollection> {
    private T collection;

    public CollectionBuilder(T collection) {
        this.collection = collection;
    }

    public CollectionBuilder<T> add(int a) {
        this.collection.add(a);
        return this;
    }

    public CollectionBuilder<T> addAll(Set otherSet) {
        Set copySet = StaticSet.copy(otherSet);

        while (!copySet.isEmpty()) {
            this.collection.add(copySet.choose());
            copySet.remove(copySet.choose());
        }

        return this;
    }

    public T build() {
        return this.collection;
    }
}

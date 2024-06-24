package org.tp0.implementations.ejercicioSeis;

import org.tp0.models.Node;

public class NodeTwiceLinked {
    private int value;
    private NodeTwiceLinked next;
    private NodeTwiceLinked previous;

    public NodeTwiceLinked(int value, NodeTwiceLinked next, NodeTwiceLinked previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public NodeTwiceLinked getNext() {
        return next;
    }

    public NodeTwiceLinked getPrevious() {
        return previous;
    }

    public void setNext(NodeTwiceLinked next) {
        this.next = next;
    }

    public void setPrevious(NodeTwiceLinked previous) {
        this.previous = previous;
    }
}

package com.jad;

import java.util.ArrayList;

public class Foo {
    private Bar bar;
    private ArrayList<Baz> bazs = new ArrayList<>();
    private Qux qux;
    private Corge corge;
    private ArrayList<Grault> graults = new ArrayList<>();


    public Foo(Bar bar) {
        this.graults.add(new Grault(this));
    }

    public void addBaz(Baz baz) {
        this.bazs.add(new Baz());
    }

    public void addGrault() {
        Grault newGrault = new Grault(this);
        this.graults.add(newGrault);
    }
}

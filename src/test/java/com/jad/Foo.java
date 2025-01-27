package com.jad;

import java.util.ArrayList;

public class Foo {
    private Bar bar;
    private ArrayList<Baz> bazs;
    private Qux qux;
    private Corge corge;
    private ArrayList<Grault> graults;


    public Foo(Bar bar) {
        this.bar = bar;
        this.bazs = new ArrayList<>();
        this.graults = new ArrayList<>();
        this.qux = new Qux();
        this.corge = null;
    }

    public Bar getBar() {
        return this.bar;
    }

    public ArrayList<Baz> getBazs() {
        return this.bazs;
    }

    public void addBaz(Baz baz) {
        this.bazs.add(baz);
    }

    public Qux getQux() {
        return this.qux;
    }

    public Corge getCorge() {
        return this.corge;
    }

    public void setCorge(Corge corge) {
        if (this.corge != null) {
            this.corge.setFoo(null);
        }

        this.corge = corge;

        if (corge != null) {
            corge.setFoo(this);
        }
    }

    public ArrayList<Grault> getGraults() {
        return this.graults;
    }

    public void addGrault() {
        Grault newGrault = new Grault(this);
        this.graults.add(newGrault);
    }

}

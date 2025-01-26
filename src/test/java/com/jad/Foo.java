package com.jad;

import java.util.ArrayList;

public class Foo {
    private Bar bar;
    private ArrayList<Baz> bazs;
    private Qux qux;
    private Corge corge; // Toujours non null
    private ArrayList<Grault> graults;

    // Constructeur
    public Foo(Bar bar, Corge corge) {
        if (corge == null) {
            throw new IllegalArgumentException("Corge ne peut pas être null pour Foo.");
        }
        this.bar = bar;
        this.bazs = new ArrayList<>();
        this.graults = new ArrayList<>();
        this.qux = new Qux();
        this.corge = corge;

        // Associer le Foo au Corge
        if (corge.getFoo() != this) {
            corge.setFoo(this);
        }
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

    public void setCorge(Corge newCorge) {
        if (newCorge == null) {
            throw new IllegalArgumentException("Corge ne peut pas être null pour Foo.");
        }

        // Si le Corge est déjà associé, rien à faire
        if (this.corge == newCorge) {
            return;
        }

        // Dissocier l'ancien Corge
        Corge oldCorge = this.corge;
        this.corge = null; // Temporarily nullify to prevent recursion
        if (oldCorge != null) {
            oldCorge.setFoo(null);
        }

        // Associer le nouveau Corge
        this.corge = newCorge;
        if (newCorge.getFoo() != this) {
            newCorge.setFoo(this);
        }
    }

    public ArrayList<Grault> getGrault() {
        return this.graults;
    }

    public void addGrault() {
        Grault newGrault = new Grault(this);
        this.graults.add(newGrault);
    }
}
package com.jad;

public class Corge {
    private Foo foo; // Peut être null

    public Corge(Foo foo) {
        this.foo = foo;

        // Si un Foo est fourni, s'assurer que l'association est correcte
        if (foo != null && foo.getCorge() != this) {
            foo.setCorge(this);
        }
    }

    public Foo getFoo() {
        return this.foo;
    }

    public void setFoo(Foo newFoo) {
        // Si le Foo est déjà associé, ne rien faire
        if (this.foo == newFoo) {
            return;
        }

        // Dissocier l'ancien Foo
        Foo oldFoo = this.foo;
        this.foo = null; // Temporarily nullify to prevent recursion
        if (oldFoo != null) {
            oldFoo.setCorge(null);
        }

        // Associer le nouveau Foo
        this.foo = newFoo;
        if (newFoo != null && newFoo.getCorge() != this) {
            newFoo.setCorge(this);
        }
    }
}
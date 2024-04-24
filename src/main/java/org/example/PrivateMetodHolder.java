package org.example;

@MyAnno
public class PrivateMetodHolder {
    @MyAnno
    private void metod() {
        System.out.println("private metod");
    }
}

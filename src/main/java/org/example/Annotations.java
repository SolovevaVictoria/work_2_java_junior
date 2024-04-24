package org.example;

import java.lang.reflect.Array;
import java.lang.reflect.Method;

@MyAnno
public class Annotations {
    @MyAnno
    public static void main(String[] args) throws NoSuchMethodException {
        Class<Annotations> annotationsClass = Annotations.class;
        for (int a = 0; a < annotationsClass.getAnnotations().length; a++) { // вытянуть из класса все аннотации, которые на нём есть
            System.out.println(annotationsClass.getAnnotations()[a]);
        }

        MyAnno anno = annotationsClass.getAnnotation(MyAnno.class);
        System.out.println(anno);
        //MyAnno annoMain =
        for (Method declaredMethod : annotationsClass.getDeclaredMethods()) {
            System.out.println(declaredMethod.getAnnotations()[0]);

        }
        // System.out.println(annotationsClass.getMethod("main", String.class)).getAnnotation(MyAnno.class);
        //System.out.println(annoMain);
        System.out.println();


        MyClass myClass = new MyClass();
        RandomIntegerProcessor.processRandomInteger(myClass);
        System.out.println(myClass.integer);
        }


        private static class MyClass {
        @RandomInteger(min = 50)  // явно задаём значения параметров, максимум по умолчанию
        private int integer;


        }
}

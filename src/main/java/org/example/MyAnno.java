package org.example;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// у каждой аннотации должно быть 2 аннотации
@Retention(RetentionPolicy.RUNTIME) // указывает, где должнв быть данная аннотация
//  SOURSE (после компиляции её нет)
//  / CLASS (аннотация в runtime есть, но она доступна только виртуальной машине)
//  / RUNTIME (есть в runtime, может быть считана в результате применения рефлексии)

@Target({ElementType.TYPE, ElementType.METHOD}) // регулируем, над чем можно ставить аннотацию
//TYPE
// FIELD
// METHOD
// PARAMETER
// CONSTRUCTOR
// LOCAL_VARIABLE
// ANNOTATION_TYPE другие аннотации
// PACKAGE
// TYPE_PARAMETER
// TYPE_USE
// MODULE

public @interface MyAnno {
}

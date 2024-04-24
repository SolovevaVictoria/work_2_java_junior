package org.example;

import java.lang.reflect.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Person person1 = new Person("Victoria");
        Class <? extends Person> aClass = person1.getClass();  // Класс Class порождает объекты, описывающие класс Person
        //Class <? extends Person> aClass = Person.class();  // второй способ получить объект, описывающий класс Person

        Constructor<? extends Person> constructor0 = aClass.getConstructor();  // конструктор без параметров
        Person person2 = constructor0.newInstance();


        Constructor<? extends Person> constructor = aClass.getConstructor(String.class);  // для получения конструктора передаём типы параметров
        Person person3 = constructor.newInstance("David");


        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);


        // Варианты получения КОНСТРУКТОРОВ:
        // 1) <x>.getDeclaredConstructors() для получения конструкторов, задекларированных именно в классе x без учёта иерархий
        // 2) <x>.getConstructors() только те конструкторы, к которым есть доступ (не private) без учёта иерархий

        int i = 1;
        Constructor <?>[] declaredConstructors = aClass.getDeclaredConstructors();  // получили массив конструкторов
        for (Constructor<?> declaredConstructor : declaredConstructors){
            System.out.print("Constructor #" + i++ + " ");
            for (Parameter parameter : declaredConstructor.getParameters()){
                System.out.print(parameter.getName() + " ");
                System.out.print(parameter.getType());
            }
            System.out.println();
        }
        System.out.println(Person.class.getDeclaredConstructors().length);
        System.out.println(Person.class.getConstructors().length);
        System.out.println(ExtPerson.class.getDeclaredConstructors().length);
        System.out.println(ExtPerson.class.getConstructors().length);

        // МЕТОДЫ
        person2.setName("Vladimir");
        System.out.println(person2);
        Method setName1 = Person.class.getMethod("setName", String.class);  // берём метод из Person по названию и типам параметров
        setName1.invoke(person2, "Vova");  // вызываем setName1 на объекте person2
        System.out.println(person2);
        Method getName1 = Person.class.getMethod("getName");  // берём метод из Person по названию и типам параметров
        System.out.println(getName1.invoke(person2));
        System.out.println(Person.class.getMethod("getCounter").invoke(null));  // вызываем статический метод, в качестве объекта указываем null/что-то ещё

        System.out.println("задекларированы в Person: " + Person.class.getDeclaredMethods().length);
        System.out.println("все доступные в Person: " + Person.class.getMethods().length);  // задекларированные + часть из object
        System.out.println("задекларированы в ExtPerson: " + ExtPerson.class.getDeclaredMethods().length);
        System.out.println("все доступные в ExtPerson: " + ExtPerson.class.getMethods().length);  // задекларированные + часть из object

        // вызовем privante метод из класса PrivateMetodHolder
        Method method = PrivateMetodHolder.class.getDeclaredMethod("metod");
        method.setAccessible(true);
        method.invoke(new PrivateMetodHolder());


        // ПОЛЯ
        Field namePersonField = Person.class.getDeclaredField("name");
        System.out.println(namePersonField);
        namePersonField.setAccessible(true);  // можно не переключать, мы итак имеем доступ к полю, т. к. класс вложенный
        namePersonField.set(person1, "Vika");
        System.out.println(person1);
        // константы тоже можем менять
        System.out.println(person1.unmodifiableField);
        Field unmodifiableField = Person.class.getDeclaredField("unmodifiableField");
        unmodifiableField.setAccessible(true);
        unmodifiableField.set(person1, "NEW_VALUE");
        System.out.println(person1.unmodifiableField);
        System.out.println(person2.unmodifiableField);






    }

    private static class ExtPerson extends Person {
        ExtPerson (int age){}
        public void foo(){}
    }

    private static class Person {
        private final String unmodifiableField;
        private static long counter = 0L;
        private String name;
        public Person(){
            this("unnamed");
        }

        public Person(String name){
            this.name = name;
            unmodifiableField = "VALUE";
            counter++;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static long getCounter() {
            return counter;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
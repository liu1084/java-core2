package com.jim.web;

import java.lang.reflect.Field;

public class ObjectTreePrinter {

    public static void printObjectTree(Object obj) {
        printObjectTree(obj, 0);
    }

    private static void printObjectTree(Object obj, int indent) {
        if (obj == null) {
            printIndent(indent);
            System.out.println("null");
            return;
        }

        Class<?> objClass = obj.getClass();
        printIndent(indent);
        System.out.println(objClass.getName());

        Field[] fields = objClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);
                printIndent(indent + 1);
                System.out.println(field.getName() + ": " + value);

                if (isNonPrimitive(value)) {
                    printObjectTree(value, indent + 2);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printIndent(int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }
    }

    private static boolean isNonPrimitive(Object obj) {
        if (obj == null) {
            return false;
        }
        Class<?> clazz = obj.getClass();
        return !clazz.isPrimitive() &&
                !clazz.equals(String.class) &&
                !Number.class.isAssignableFrom(clazz) &&
                !Boolean.class.equals(clazz) &&
                !Character.class.equals(clazz);
    }
}


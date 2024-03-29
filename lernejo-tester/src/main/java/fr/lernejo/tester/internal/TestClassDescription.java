package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;


import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class TestClassDescription {
    Class<?> test;

    TestClassDescription(Class<?> test){
        this.test = test;
    }

    @TestMethod
    List<Method> listTestMethods() {
        List<Method> l = new ArrayList<>();

        try{
            Method[] m = test.getDeclaredMethods();
            for(Method met : m){
                if(Modifier.isPublic(met.getModifiers())){
                    if(!Modifier.isStatic(met.getModifiers())) {
                        if (met.getParameterCount() == 0) {
                            if (met.getGenericReturnType() == void.class) {
                                l.add(met);
                            }
                        }
                    }
                }
            }
        }
        catch (SecurityException s){
            System.err.println("SecurityException " + s.getMessage());
        }

        return l;
    }
}

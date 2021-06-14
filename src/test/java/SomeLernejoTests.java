import fr.lernejo.tester.api.TestMethod;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class SomeLernejoTests {
    Class<?> test;

    SomeLernejoTests(Class<?> test){
        this.test = test;
    }

    @TestMethod
    List<Method> listTestMethods(SomeLernejoTests t) {
        List<Method> l = new ArrayList<>();

        try{
            Method[] m = test.getDeclaredMethods();
            for(Method met : m){
                if(Modifier.isPublic(met.getModifiers())){
                    l.add(met);
                }
                else if(met.isAnnotationPresent(TestMethod.class)) {
                    l.add(met);
                }
                else if(met.getParameterCount() == 0){
                    l.add(met);
                }
                else if(met.getGenericReturnType() == void.class) {
                    l.add(met);
                }
            }
        }
        catch (SecurityException s){
            System.err.println("SecurityException " + s.getMessage());
        }

        return l;
    }
}

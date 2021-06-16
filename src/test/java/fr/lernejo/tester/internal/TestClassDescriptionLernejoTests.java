package fr.lernejo.tester.internal;

import fr.lernejo.tester.SomeLernejoTests;

public class TestClassDescriptionLernejoTests {
    public static void main(String[] args) {
        Class<SomeLernejoTests> testClass = SomeLernejoTests.class;
        TestClassDescription test = new TestClassDescription(testClass);
        System.out.println(test.listTestMethods());
    }
}

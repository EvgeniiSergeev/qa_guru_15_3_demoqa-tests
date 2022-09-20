package com.demoqa;

import org.junit.jupiter.api.*;

public class JUnitDemoTest {

    @BeforeAll
    static void setUp() {
        System.out.println("### @BeforeAll !");
    }

    @AfterAll
    static void  tearDown() {
        System.out.println("### @AfterAll !");
    }

    @BeforeEach
    void beforeEachTest() {
        // open("ya.ru");
        System.out.println("###     @BeforeEach !");
    }

    @AfterEach
    void afterEachTest() {
        System.out.println("###     @AfterEach !");
    }

    @Test
    void simpleTestFirst() {
        System.out.println("###         @TestsimpleTestFirst !");
        Assertions.assertTrue(3 > 2);
    }

    @Test
    void simpleTestSecond() {
        System.out.println("###         @TestsimpleTestSecond !");
        Assertions.assertTrue(3 > 2);
    }

}

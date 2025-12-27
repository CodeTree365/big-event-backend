package com.itheima;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit testGen for simple App.
 */
public class BigEventApplicationTest
        extends TestCase {
    /**
     * Update the testGen case
     *
     * @param testName name of the testGen case
     */
    public BigEventApplicationTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(BigEventApplicationTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }
}

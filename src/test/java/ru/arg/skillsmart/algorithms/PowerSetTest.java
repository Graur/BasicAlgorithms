package ru.arg.skillsmart.algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class PowerSetTest {

    public static final int numbersOfSize = 18000;

    private PowerSet powerSet;

    private PowerSet powerSet2;

    private PowerSet powerSet3;

    private PowerSet powerSet4;

    public void setUp() {
        powerSet = new PowerSet();
        for (int i = 0; i < numbersOfSize; i++) {
            powerSet.put(Integer.toString(i));
        }
    }

    public void setUp2() {
        powerSet2 = new PowerSet();
        for (int i = numbersOfSize; i < numbersOfSize + 15000; i++) {
            powerSet2.put("abcvbdgdrefsdf" + i);
        }
    }

    public void setUp3() {
        powerSet3 = new PowerSet();
        for (int i = numbersOfSize; i < numbersOfSize + 10000; i++) {
            powerSet3.put("asdfasdf" + i);
        }

        for (int i = 0; i < numbersOfSize - 17000; i++) {
            powerSet3.put(Integer.toString(i));
        }
    }

    public void setUp4() {
        powerSet4 = new PowerSet();

        for (int i = 0; i < numbersOfSize - 1000; i++) {
            powerSet4.put(Integer.toString(i));
        }
    }

    @Test
    public void setUpTest() {
        System.out.println("setUp");
        long start = System.currentTimeMillis();
        setUp();
        long end = System.currentTimeMillis();
        long time = end - start;
        assertTrue(time <= 2000);
        System.out.println("Benchmarks time = " + time);
    }

    @Test
    public void size() {
        System.out.println("size");
        setUp();
        long start = System.currentTimeMillis();
        int size = powerSet.size();
        long end = System.currentTimeMillis();
        long time = end - start;
        assertEquals(18000, size);
        assertTrue(time <= 2000);
        System.out.println("Benchmarks time = " + time);
    }

    @Test
    public void put() {
        System.out.println("put");
        setUp();
        long start = System.currentTimeMillis();
        powerSet.put("asd");
        long end = System.currentTimeMillis();
        assertEquals(18001, powerSet.size());
        long time = end - start;
        assertTrue(time <= 2000);
        System.out.println("Benchmarks time = " + time);
    }

    @Test
    public void get() {
        System.out.println("get");
        setUp();
        long start = System.currentTimeMillis();
        boolean get = powerSet.get("5000");
        long end = System.currentTimeMillis();
        assertEquals(18000, powerSet.size());
        assertTrue(get);
        boolean notGet = powerSet.get("sadasdad");
        assertFalse(notGet);
        long time = end - start;
        assertTrue(time <= 2000);
        System.out.println("Benchmarks time = " + time);
    }

    @Test
    public void remove() {
        System.out.println("remove");
        setUp();
        long start = System.currentTimeMillis();
        boolean remove = powerSet.remove("5000");
        long end = System.currentTimeMillis();
        assertEquals(17999, powerSet.size());
        assertTrue(remove);
        boolean remove2 = powerSet.remove("5000");
        assertFalse(remove2);
        boolean remove3 = powerSet.remove("fadsf");
        assertFalse(remove3);
        long time = end - start;
        assertTrue(time <= 2000);
        System.out.println("Benchmarks time = " + time);
    }

    @Test
    public void intersection() {
        System.out.println("intersection");
        setUp();
        setUp3();
        long start = System.currentTimeMillis();
        PowerSet res = powerSet.intersection(powerSet3);
        long end = System.currentTimeMillis();
        assertEquals(1000, res.size());
        long time = end - start;
        assertTrue(time <= 2000);
        System.out.println("Benchmarks time = " + time);
    }

    @Test
    public void intersection2() {
        System.out.println("intersection2");
        setUp();
        setUp2();
        long start = System.currentTimeMillis();
        PowerSet res = powerSet.intersection(powerSet2);
        long end = System.currentTimeMillis();
        assertEquals(0, res.size());
        long time = end - start;
        assertTrue(time <= 2000);
        System.out.println("Benchmarks time = " + time);
    }

    @Test
    public void union() {
        System.out.println("union");
        setUp();
        setUp3();
        long start = System.currentTimeMillis();
        PowerSet res = powerSet.union(powerSet3);
        long end = System.currentTimeMillis();
        assertEquals(28000, res.size());
        long time = end - start;
        System.out.println("Benchmarks time = " + time);
        assertTrue(time <= 2000);
    }

    @Test
    public void union2() {
        System.out.println("union2");
        setUp();
        setUp2();
        long start = System.currentTimeMillis();
        PowerSet res = powerSet.union(powerSet2);
        long end = System.currentTimeMillis();
        assertEquals(33000, res.size());
        long time = end - start;
        System.out.println("Benchmarks time = " + time);
        assertTrue(time <= 2000);
    }

    @Test
    public void difference() {
        System.out.println("difference");
        setUp();
        setUp2();
        long start = System.currentTimeMillis();
        PowerSet res = powerSet.difference(powerSet2);
        long end = System.currentTimeMillis();
        assertEquals(18000, res.size());
        long time = end - start;
        assertTrue(time <= 2000);
        System.out.println("Benchmarks time = " + time);
    }

    @Test
    public void difference2() {
        System.out.println("difference2");
        setUp();
        setUp3();
        long start = System.currentTimeMillis();
        PowerSet res = powerSet.difference(powerSet3);
        long end = System.currentTimeMillis();
        assertEquals(17000, res.size());
        long time = end - start;
        assertTrue(time <= 2000);
        System.out.println("Benchmarks time = " + time);
    }

    @Test
    public void isSubset() {
        System.out.println("isSubset");
        setUp();
        setUp3();
        long start = System.currentTimeMillis();
        boolean res = powerSet.isSubset(powerSet3);
        long end = System.currentTimeMillis();
        assertFalse(res);
        long time = end - start;
        assertTrue(time <= 2000);
        System.out.println("Benchmarks time = " + time);
    }

    @Test
    public void isSubset2() {
        System.out.println("isSubset2");
        setUp();
        setUp2();
        long start = System.currentTimeMillis();
        boolean res = powerSet.isSubset(powerSet2);
        long end = System.currentTimeMillis();
        assertFalse(res);
        long time = end - start;
        assertTrue(time <= 2000);
        System.out.println("Benchmarks time = " + time);
    }

    @Test
    public void isSubset3() {
        System.out.println("isSubset3");
        setUp();
        setUp4();
        long start = System.currentTimeMillis();
        boolean res = powerSet.isSubset(powerSet4);
        long end = System.currentTimeMillis();
        assertTrue(res);
        long time = end - start;
        assertTrue(time <= 2000);
        System.out.println("Benchmarks time = " + time);
    }

    @Test
    public void remove2() {
        PowerSet ps = new PowerSet();
        ps.put("abc");
        ps.put("bac");
        ps.put("bca");

        assertEquals(3, ps.size());
        assertTrue(ps.remove("bac"));
        assertFalse(ps.remove("sss"));
        assertEquals(2, ps.size());
    }
}
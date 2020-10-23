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
        int asd = powerSet.find("asd");
        assertEquals("asd", powerSet.slots[asd]);
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
    public void sizeZ() {
        PowerSet ps = new PowerSet();
        ps.put("sdf");
        ps.put("sdvf");
        ps.put("sdfsf");
        ps.put("sd");
        assertEquals(4, ps.size());
    }

    @Test
    public void putZ() {
        PowerSet ps = new PowerSet();
        ps.put("sdf");
        ps.put("sdg");
        ps.put("sd");
        ps.put("sd");
        ps.put("sdf");
        ps.put("s");
        ps.put("ss");
        ps.put("sss");
        ps.put("ssss");
        assertEquals(7, ps.size());
    }

    @Test
    public void getZ() {
        PowerSet ps = new PowerSet();
        ps.put("sdf");
        ps.put("sdg");
        ps.put("sd");
        ps.put("sd");
        ps.put("sdf");
        ps.put("s");
        ps.put("ss");
        ps.put("sss");
        ps.put("ssss");
        assertTrue(ps.get("sd"));
        assertFalse(ps.get("sdq"));
    }

    @Test
    public void removeZ() {
        PowerSet ps = new PowerSet();
        ps.put("sdf");
        ps.put("sdg");
        ps.put("sd");
        ps.put("sd2");
        ps.put("sdf2");
        ps.put("s");
        ps.put("ss");
        ps.put("sss");
        ps.put("ssss");

        ps.remove("s");
        ps.remove("sd");
        assertEquals(7, ps.size());
        assertFalse(ps.remove("aaa"));
        assertTrue(ps.get("sdg"));
        assertTrue(ps.get("sdf2"));
        assertTrue(ps.get("ss"));
        assertTrue(ps.get("sdf"));
        assertTrue(ps.get("ssss"));
        assertTrue(ps.get("sss"));
        assertTrue(ps.get("sd2"));
        assertTrue(ps.remove("sss"));
    }

    @Test
    public void removeZ2() {
        PowerSet ps = new PowerSet();
        ps.put("abc");
        ps.put("bac");
        ps.put("bca");

        assertEquals(3, ps.size());
        assertTrue(ps.remove("bac"));
        assertFalse(ps.remove("sss"));
        assertEquals(2, ps.size());
    }

    @Test
    public void intersectionZ() {
        PowerSet ps = new PowerSet();
        ps.put("sdf");
        ps.put("sdv");
        ps.put("sdfsf");
        ps.put("sd");
        PowerSet ps2 = new PowerSet();
        ps2.put("aaa");
        ps2.put("sdv");
        ps2.put("hg");
        ps2.put("sd");
        assertEquals(2, ps.intersection(ps2).size());
    }

    @Test
    public void intersectionEmpty() {
        PowerSet ps = new PowerSet();
        ps.put("sdf");
        ps.put("sdv");
        ps.put("sdfsf");
        ps.put("sd");
        PowerSet ps2 = new PowerSet();
        ps2.put("aaa");
        ps2.put("sdv1");
        ps2.put("hg");
        ps2.put("sd11");
        assertEquals(0, ps.intersection(ps2).size());
    }

    @Test
    public void unionZ() {
        PowerSet ps = new PowerSet();
        ps.put("sdf");
        ps.put("sdv");
        ps.put("sdfsf");
        ps.put("sd");
        ps.put("hg");
        PowerSet ps2 = new PowerSet();
        ps2.put("aaa");
        ps2.put("sdv1");
        ps2.put("hg");
        for (String s : ps.union(ps2).slots) {
            System.out.println(s);
        }
    }

    @Test
    public void unionEmpty() {
        PowerSet ps = new PowerSet();
        ps.put("sdf");
        ps.put("sdv");
        ps.put("sdfsf");
        ps.put("sd");
        PowerSet ps2 = new PowerSet();
        assertEquals(4, ps.union(ps2).size());
    }

    @Test
    public void differenceZ() {
        PowerSet ps = new PowerSet();
        ps.put("sdf");
        ps.put("sdv");
        ps.put("sdfsf");
        ps.put("sd");
        PowerSet ps2 = new PowerSet();
        ps2.put("aaa");
        ps2.put("sdv1");
        ps2.put("sd");
        assertEquals(3, ps.difference(ps2).size());
        /*for (String s : ps.difference(ps2).slots) {
            System.out.println(s);
        }*/
    }

    @Test
    public void differenceEmpty() {
        PowerSet ps = new PowerSet();
        ps.put("111");
        ps.put("222");
        PowerSet ps2 = new PowerSet();
        ps2.put("111");
        ps2.put("222");
        assertEquals(0, ps.difference(ps2).size());
    }

    @Test
    public void isSubsetFalse() {
        PowerSet ps = new PowerSet();
        ps.put("sdf");
        ps.put("sdv");
        ps.put("sdfsf");
        ps.put("sd");
        PowerSet ps2 = new PowerSet();
        ps2.put("aaa");
        ps2.put("sdv1");
        ps2.put("sd");
        assertFalse(ps.isSubset(ps2));
    }

    @Test
    public void isSubset1() {
        PowerSet ps = new PowerSet();
        ps.put("sdf");
        ps.put("sdv");
        ps.put("sdfsf");
        ps.put("sd");
        PowerSet ps2 = new PowerSet();
        ps2.put("sdv");
        ps2.put("sdf");
        assertTrue(ps.isSubset(ps2));
    }

    @Test
    public void isSubset2Z() {
        PowerSet ps = new PowerSet();
        ps.put("sdf");
        ps.put("sdv");
        ps.put("sdfsf");
        PowerSet ps2 = new PowerSet();
        ps2.put("sdv");
        ps2.put("sdf");
        ps2.put("sdfsf");
        assertTrue(ps.isSubset(ps2));
    }

    @Test
    public void isSubset3Z() {
        PowerSet ps = new PowerSet();
        ps.put("sdf");
        ps.put("sdv");
        ps.put("sdfsf");
        PowerSet ps2 = new PowerSet();
        ps2.put("sdv");
        ps2.put("sdf");
        ps2.put("sdfsf");
        ps2.put("aaa");
        assertFalse(ps.isSubset(ps2));
    }
}
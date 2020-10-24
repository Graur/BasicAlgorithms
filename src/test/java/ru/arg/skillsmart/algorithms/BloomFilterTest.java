package ru.arg.skillsmart.algorithms;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class BloomFilterTest {
    private String string0 = "0123456789";
    private String string1 = "1234567890";
    private String string2 = "2345678901";
    private String string3 = "3456789012";
    private String string4 = "4567890123";
    private String string5 = "5678901234";
    private String string6 = "6789012345";
    private String string7 = "7890123456";
    private String string8 = "8901234567";
    private String string9 = "9012345678";

    @Test
    public void hash1() {
        BloomFilter bf = new BloomFilter(32);
        System.out.println(Integer.toBinaryString(bf.hash1(string0)));
        System.out.println(Integer.toBinaryString(bf.hash1(string1)));
        System.out.println(Integer.toBinaryString(bf.hash1(string2)));
        System.out.println(Integer.toBinaryString(bf.hash1(string3)));
        System.out.println(Integer.toBinaryString(bf.hash1(string4)));
        System.out.println(Integer.toBinaryString(bf.hash1(string5)));
        System.out.println(Integer.toBinaryString(bf.hash1(string6)));
        System.out.println(Integer.toBinaryString(bf.hash1(string7)));
        System.out.println(Integer.toBinaryString(bf.hash1(string8)));
        System.out.println(Integer.toBinaryString(bf.hash1(string9)));
    }

    @Test
    public void hash2() {
        BloomFilter bf = new BloomFilter(32);
        System.out.println(Integer.toBinaryString(bf.hash2(string0)));
        System.out.println(Integer.toBinaryString(bf.hash2(string1)));
        System.out.println(Integer.toBinaryString(bf.hash2(string2)));
        System.out.println(Integer.toBinaryString(bf.hash2(string3)));
        System.out.println(Integer.toBinaryString(bf.hash2(string4)));
        System.out.println(Integer.toBinaryString(bf.hash2(string5)));
        System.out.println(Integer.toBinaryString(bf.hash2(string6)));
        System.out.println(Integer.toBinaryString(bf.hash2(string7)));
        System.out.println(Integer.toBinaryString(bf.hash2(string8)));
        System.out.println(Integer.toBinaryString(bf.hash2(string9)));
    }

    @Test
    public void add() {
        BloomFilter bf = new BloomFilter(32);
        bf.add(string0);
        bf.add(string1);
        bf.add(string2);
    }

    @Test
    public void isValue() {
        BloomFilter bf = new BloomFilter(32);
        bf.add(string0);
        bf.add(string1);
        bf.add(string2);
        bf.add(string3);
        bf.add(string4);
        bf.add(string5);
        assertTrue(bf.isValue(string0));
        assertTrue(bf.isValue(string1));
        assertTrue(bf.isValue(string2));
        assertTrue(bf.isValue(string3));
        assertTrue(bf.isValue(string4));
        assertTrue(bf.isValue(string5));
        assertFalse(bf.isValue("dsfasdfasdf"));
    }
}
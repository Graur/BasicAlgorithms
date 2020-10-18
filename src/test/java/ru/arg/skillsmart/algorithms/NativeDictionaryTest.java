package ru.arg.skillsmart.algorithms;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashMap;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class NativeDictionaryTest {

    private NativeDictionary<Integer> simple;

    private NativeDictionary<Integer> collision;

    public void setUp() {
        simple = new NativeDictionary<>(11, Integer.class);
        simple.put("1", 1);
        simple.put("2", 2);
        collision = new NativeDictionary<>(11, Integer.class);
        collision.put("1", 1);
        collision.put("2", 2);
    }

    @Test
    public void hashFun() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("1", 2);
        map.entrySet().forEach(e -> {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        });
    }

    @Test
    public void isKey() {
        setUp();
        simple.put("3", 3);
        assertTrue(simple.isKey("3"));
        assertFalse(simple.isKey("asdfasdgasgsg"));
        collision.put("ab", 100);
        collision.put("ba", 200);
        assertTrue(collision.isKey("ab"));
        assertTrue(collision.isKey("ba"));
        assertFalse(collision.isKey("fasfasdfasf"));
    }

    @Test
    public void put() {
        setUp();
        simple.put("3", 3);
        assertEquals(Integer.valueOf(3), simple.get("3"));
        collision.put("ab", 100);
        collision.put("ba", 200);
        assertEquals(Integer.valueOf(100), collision.get("ab"));
        assertEquals(Integer.valueOf(200), collision.get("ba"));
        collision.put("1", 777);
        assertEquals(Integer.valueOf(777), collision.get("1"));
    }

    @Test
    public void get() {
        setUp();
        simple.put("3", 3);
        assertEquals(Integer.valueOf(3), simple.get("3"));
        collision.put("ab", 100);
        collision.put("ba", 200);
        assertEquals(Integer.valueOf(100), collision.get("ab"));
        assertEquals(Integer.valueOf(200), collision.get("ba"));
        assertNull(simple.get("sdfasdfsffSF"));
        assertNull(collision.get("sdfasdfsffSF"));
    }
}
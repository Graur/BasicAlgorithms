package ru.arg.skillsmart.algorithms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class HashTableTest {

    private HashTable simpleTable;

    private HashTable collisionTable;

    public void setUp() {
        simpleTable = new HashTable(13, 3);
        simpleTable.put("1");
        simpleTable.put("2");
        simpleTable.put("3");
        simpleTable.put("4");
        simpleTable.put("5");
        simpleTable.put("6");
        simpleTable.put("7");
        simpleTable.put("8");
        simpleTable.put("9");
        simpleTable.put("10");
        simpleTable.put("11");
        simpleTable.put("12");
        simpleTable.put("13");

        collisionTable = new HashTable(11, 3);
        collisionTable.put("1");
        collisionTable.put("2");
        collisionTable.put("3");
        collisionTable.put("4");
        collisionTable.put("5");
    }

    @Test
    public void hashFun() {
        simpleTable = new HashTable(17, 3);
        int i = simpleTable.hashFun("98");
        assertTrue(i>=0 && i < simpleTable.size);
    }

    @Test
    public void seekSlot() {
        setUp();
        assertEquals(-1 ,collisionTable.put(null));
        assertEquals(-1 ,collisionTable.find(null));
    }

    @Test
    public void put() {
        setUp();
        assertEquals(13, simpleTable.size);
        assertEquals(-1, simpleTable.put("zzz"));
        System.out.println("SIMPLE TABLE");
        for (String s : simpleTable.slots) {
            System.out.println(s);
        }

        System.out.println("COLLISION TABLE");
        assertNotEquals(-1, collisionTable.put("1"));
        assertNotEquals(-1, collisionTable.put("1"));
        assertNotEquals(-1, collisionTable.put("1"));
        assertNotEquals(-1, collisionTable.put("1"));
        assertNotEquals(-1, collisionTable.put("1"));
        assertNotEquals(-1, collisionTable.put("1"));
        assertEquals(-1, collisionTable.put("1"));

        System.out.println("============================");
        for (String s : collisionTable.slots) {
            System.out.println(s);
        }
    }

    @Test
    public void find() {
        setUp();
        int simpleIndex = simpleTable.find("1");
        assertNotEquals(-1, simpleIndex);
        assertEquals(simpleTable.slots[simpleIndex], "1");
        assertEquals(-1, simpleTable.find("ffffff"));
        int collusionIndex = collisionTable.find("1");
        assertNotEquals(-1, collusionIndex);
        assertEquals(collisionTable.slots[collusionIndex], "1");
        collisionTable.put("1");
        int collusionIndex2 = collisionTable.find("1");
        assertEquals(collisionTable.slots[collusionIndex2], "1");
        assertEquals(-1, collisionTable.find("ffffff"));
    }
}
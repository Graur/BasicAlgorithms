package ru.arg.skillsmart.algorithms;

import java.util.ArrayList;

public class PowerSet {
    ArrayList<String> powerSetList;

    public PowerSet() {
        powerSetList = new ArrayList<>(20000);
    }

    public int size() {
        return powerSetList.size();
    }

    public void put(String value) {
        if (!powerSetList.contains(value)) powerSetList.add(value);
    }

    public boolean get(String value) {
        return powerSetList.contains(value);
    }

    public String find(int i) {
        return powerSetList.get(i);
    }

    public boolean remove(String value) {
        return powerSetList.remove(value);
    }

    public PowerSet intersection(PowerSet set2) {
        PowerSet result = new PowerSet();
        for (String i : powerSetList) {
            if (set2.get(i)) result.put(i);
        }
        return result;
    }

    public PowerSet union(PowerSet set2) {
        PowerSet result = new PowerSet();
        for (String i : powerSetList) {
            result.put(i);
        }
        for (int i = 0; i < set2.size(); i++) {
            result.put(set2.find(i));
        }
        return result;
    }

    public PowerSet difference(PowerSet set2) {
        PowerSet result = new PowerSet();
        for (String i : powerSetList) {
            if (!set2.get(i)) result.put(i);
        }
        return result;
    }

    public boolean isSubset(PowerSet set2) {
        for (int i = 0; i < set2.size(); i++) {
            if(!powerSetList.contains(set2.find(i))) return false;
        }
        return true;
    }
}

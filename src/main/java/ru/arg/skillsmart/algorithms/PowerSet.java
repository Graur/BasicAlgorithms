package ru.arg.skillsmart.algorithms;

import java.util.Arrays;

public class PowerSet
{
    public int size;
    public int step;
    public String[] slots;
    public int count;

    public PowerSet()
    {
        // ваша реализация хранилища
        size = 20000;
        step = 3;
        slots = new String[size];
        for(int i=0; i<size; i++) slots[i] = null;
    }

    public PowerSet(int sz)
    {
        // ваша реализация хранилища
        size = sz;
        step = 3;
        slots = new String[size];
        for(int i=0; i<size; i++) slots[i] = null;
    }

    public int size()
    {
        // количество элементов в множестве
        return count;
    }

    public int hashFun(String value)
    {
        // всегда возвращает корректный индекс слота
        int h = 0;
        byte[] bytes = value.getBytes();
        for (byte v : bytes) {
            h += v;
        }
        return h % size;
    }

    private int seekSlot(String key)
    {
        // находит индекс пустого слота для значения, или -1
        int index = hashFun(key);
        if (slots[index] == null || slots[index].equals(key)) {
            return index;
        } else {
            int cnt = 0;
            int newIndex = index + step >= size ? step - (size - index) : index + step;
            while (cnt != size) {
                if (slots[newIndex] == null) {
                    return newIndex;
                } else {
                    newIndex = newIndex + step >= size ? step - (size - newIndex) : newIndex + step;
                    cnt++;
                }
            }
        }
        return -1;
    }

    public void put(String value)
    {
        // всегда срабатывает
        if (get(value)) {
            return;
        }
        int index = seekSlot(value);
        if (index != -1) {
            slots[index] = value;
            count++;
        }
    }

    public boolean get(String value)
    {
        // возвращает true если value имеется в множестве,
        // иначе false
        int index = hashFun(value);
        if (slots[index] == null) {
            return false;
        } else if (slots[index].equals(value)) {
            return true;
        } else {
            int count = 0;
            int newIndex = index + step >= size ? step - (size - index) : index + step;
            while (count != size) {
                if (slots[newIndex] != null && slots[newIndex].equals(value))  {
                    return true;
                } else {
                    newIndex = newIndex + step >= size ? step - (size - newIndex) : newIndex + step;
                    count++;
                }
            }
        }
        return false;
    }

    public int find(String value)
    {
        if (value == null) {
            return -1;
        }
        int index = hashFun(value);
        if (slots[index].equals(value)) {
            return index;
        } else {
            int count = 0;
            int newIndex = index + step >= size ? step - (size - index) : index + step;
            while (count != size) {
                if (slots[newIndex] != null && slots[newIndex].equals(value))  {
                    return newIndex;
                } else {
                    newIndex = newIndex + step >= size ? step - (size - newIndex) : newIndex + step;
                    count++;
                }
            }
        }
        return -1;
    }

    public boolean remove(String value)
    {
        // возвращает true если value удалено
        // иначе false
        if (!get(value)) {
            return false;
        }
        int index = find(value);
        if (index != -1 && slots[index] != null) {
            slots[index] = null;
            count--;
            return true;
        }
        return false;
    }

    public PowerSet intersection(PowerSet set2)
    {
        // пересечение текущего множества и set2
        if (set2 == null) {
            return new PowerSet();
        }
        PowerSet result = new PowerSet();
        for (int i = 0; i < set2.size; i++) {
            if (set2.slots[i] != null && get(set2.slots[i])) {
                result.put(set2.slots[i]);
            }
        }
        return result;
    }

    public PowerSet union(PowerSet set2)
    {
        // объединение текущего множества и set2
        PowerSet result = new PowerSet(size() + set2.size());
        for (int i = 0; i < size; i++) {
            if (slots[i] != null) {
                result.put(slots[i]);
            }
        }

        for (int i = 0; i < set2.size; i++) {
            if (set2.slots[i] != null) {
                result.put(set2.slots[i]);
            }
        }
        return result;
    }

    public PowerSet difference(PowerSet set2)
    {
        // разница текущего множества и set2
        PowerSet result = new PowerSet();
        for (int i = 0; i < size; i++) {
            if (slots[i] != null && !set2.get(slots[i])) {
                result.put(slots[i]);
            }
        }
        return result;
    }

    public boolean isSubset(PowerSet set2)
    {
        // возвращает true, если set2 есть
        // подмножество текущего множества,
        // иначе false
        for (int i = 0; i < set2.size; i++) {
            if (set2.slots[i] != null && !get(set2.slots[i])) {
                return false;
            }
        }
        return true;
    }
}

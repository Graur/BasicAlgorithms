package ru.arg.skillsmart.algorithms;

public class HashTable
{
    public int size;
    public int step;
    public String[] slots;

    public HashTable(int sz, int stp)
    {
        size = sz;
        step = stp;
        slots = new String[size];
        for(int i=0; i<size; i++) slots[i] = null;
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

    public int seekSlot(String value)
    {
        // находит индекс пустого слота для значения, или -1
        int index = hashFun(value);
        if (slots[index] == null) {
            return index;
        } else {
            int count = 0;
            int newIndex = index + step >= size ? step - (size - index) : index + step;
            while (count != size) {
                if (slots[newIndex] == null)  {
                    return newIndex;
                } else {
                    newIndex = newIndex + step >= size ? step - (size - newIndex) : newIndex + step;
                    count++;
                }
            }
        }
        return -1;
    }

    public int put(String value)
    {
        // записываем значение по хэш-функции
        int index = seekSlot(value);
        // возвращается индекс слота или -1
        // если из-за коллизий элемент не удаётся разместить
        if (index != -1) {
            slots[index] = value;
        }
        return index;
    }

    public int find(String value)
    {
        int index = hashFun(value);
        if (slots[index].equals(value)) {
            return index;
        } else {
            return -1;
        }
    }
}
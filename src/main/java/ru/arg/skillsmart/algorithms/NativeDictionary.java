package ru.arg.skillsmart.algorithms;
import java.lang.reflect.Array;

class NativeDictionary<T>
{
    public int size;
    private int step;
    public String [] slots;
    public T [] values;

    public NativeDictionary(int sz, Class clazz)
    {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
        step = 3;
    }

    public int hashFun(String key)
    {
        // всегда возвращает корректный индекс слота
//        int h;
//        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        int h = 0;
        byte[] bytes = key.getBytes();
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

    public boolean isKey(String key)
    {
        // возвращает true если ключ имеется,
        // иначе false
       return get(key) != null;
    }

    public void put(String key, T value)
    {
        // гарантированно записываем
        // значение value по ключу key
        int index = seekSlot(key);
        if (index != -1) {
            slots[index] = key;
            values[index] = value;
        }
    }

    public T get(String key)
    {
        // возвращает value для key,
        // или null если ключ не найден
        int index = hashFun(key);
        if (slots[index] == null) {
            return null;
        } else if (slots[index].equals(key)) {
            return values[index];
        } else {
            int count = 0;
            int newIndex = index + step >= size ? step - (size - index) : index + step;
            while (count != size) {
                if (slots[newIndex] != null && slots[newIndex].equals(key))  {
                    return values[newIndex];
                } else {
                    newIndex = newIndex + step >= size ? step - (size - newIndex) : newIndex + step;
                    count++;
                }
            }
        }
        return null;
    }
}
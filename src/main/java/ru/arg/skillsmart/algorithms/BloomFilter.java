package ru.arg.skillsmart.algorithms;

public class BloomFilter
{
    public int filter_len;
    // 00000000000000000000000000000000
    public int bitArray;

    public BloomFilter(int f_len)
    {
        filter_len = f_len;
        // создаём битовый массив длиной f_len ...
        bitArray = 0;
    }

    // хэш-функции
    public int hash1(String str1)
    {
        // 17
        int result = 0;
        for(int i=0; i<str1.length(); i++)
        {
            int code = str1.charAt(i);
            result = (result * 17 + code) % filter_len;
        }
        // реализация ...
        return 1 << result;
    }
    public int hash2(String str1)
    {
        // 223
        // реализация ...
        int result = 0;
        for(int i=0; i<str1.length(); i++)
        {
            int code = str1.charAt(i);
            result = (result * 223 + code) % filter_len;
        }
        return 1 << result;
    }

    public void add(String str1)
    {
        // добавляем строку str1 в фильтр
        bitArray = bitArray | hash1(str1) | hash2(str1);
    }

    public boolean isValue(String str1)
    {
        // проверка, имеется ли строка str1 в фильтре
        int bitMask = hash1(str1) | hash2(str1);
        return bitMask ==  (bitArray & bitMask);
    }
}
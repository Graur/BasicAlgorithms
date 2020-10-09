import java.lang.reflect.Array;

public class DynArray<T>
{
    public T [] array;
    public int count;
    public int capacity;
    private static final int DEFAULT_CAPACITY = 16;
    Class clazz;

    public DynArray(Class clz)
    {
        clazz = clz; // нужен для безопасного приведения типов
        // new DynArray<Integer>(Integer.class);

        count = 0;
        makeArray(16);
    }

    public void makeArray(int new_capacity)
    {
        if (array == null && new_capacity <= DEFAULT_CAPACITY) {
            array = (T[]) Array.newInstance(this.clazz, new_capacity);
            capacity = DEFAULT_CAPACITY;
        } else if (new_capacity > DEFAULT_CAPACITY) {
            T[] buffer = (T[]) Array.newInstance(this.clazz, new_capacity);
            int newCapacity = capacity * 2;
            System.arraycopy(array, 0, buffer, 0, newCapacity);
            array = buffer;
            capacity = newCapacity;
        }
    }

    public T getItem(int index)
    {
        if (index >=0 && index < count) {
            return array[index];
        } else {
            throw new IndexOutOfBoundsException("Index is: " + index + ", but array size is: " + count);
        }
    }

    public void append(T itm)
    {
        if (count == capacity) {
            makeArray(count + 1);
        }
        array[count] = itm;
        count++;
    }

    public void insert(T itm, int index)
    {
        if (index == count + 1) {
            append(itm);
        } else if (index >= 0 && index <= count) {
            if (count + 1 > capacity) {
                makeArray(capacity + 1);
            }
            System.arraycopy(array, index,
                    array, index + 1,
                    count - index);
            array[index] = itm;
            count++;
        } else {
            throw new IndexOutOfBoundsException("Index is: " + index + ", but array size is: " + count);
        }
    }

    public void remove(int index)
    {
        // ваш код
    }

}
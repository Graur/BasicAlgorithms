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
            System.arraycopy(array, 0, buffer, 0, count);
            int newCapacity = capacity * 2;
            array = (T[]) Array.newInstance(this.clazz, newCapacity);
            capacity = newCapacity;
        }
    }

    public T getItem(int index)
    {
        if (index >=0 && index < count) {
            return array[index];
        } else {
            throw new ArrayIndexOutOfBoundsException("Index is: " + index + ", but array size is: " + count);
        }
    }

    public void append(T itm)
    {
        if (count >= capacity - 1) {
            makeArray(count + 1);
        }
        array[count] = itm;
        count++;
    }

    public void insert(T itm, int index)
    {
        if (index == count) {
            array[index] = itm;
            count++;
        } else if (index >= 0 && index < count) {

        }
    }

    public void remove(int index)
    {
        // ваш код
    }

}
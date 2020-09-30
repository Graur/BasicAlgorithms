import java.util.ArrayList;

public class SumOfLists {
    public ArrayList<Integer> sumOfEqualsLists(LinkedList list1, LinkedList list2) {
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList.ListIteratorI listIterator1 = list1.listIterator();
        LinkedList.ListIteratorI listIterator2 = list2.listIterator();

        if (list1.count() == list2.count()) {
            while (listIterator1.hasNext()) {
                result.add(listIterator1.next() + listIterator2.next());
            }
        }
        return result;
    }
}

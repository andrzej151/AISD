public class CompoundComparator implements Comparator {
//tablica komparatorów ; od najwa¿niejszego
private final List _comparators = new ArrayList();
public void addComparator(Comparator comparator)
{ _comparators.add(comparator); }
public int compare(Object left, Object right) throws ClassCastException {
int result = 0;
Iterator i = _comparators.iterator();
for (i.first(); !i.isDone()&&
(result = ((Comparator) i.current()).compare(left, right))==0; i.next());
return result;
}
}
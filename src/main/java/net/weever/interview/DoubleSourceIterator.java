package net.weever.interview;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

class DoubleSourceIterator {

    Iterator<Integer> sourceA;
    Iterator<Integer> sourceB;

    // those two I added
    Set<Integer> visited = new HashSet<>();
    Integer current = null;

    public DoubleSourceIterator(Iterator sourceA,  Iterator sourceB) {
        this.sourceA = sourceA;
        this.sourceB = sourceB;
    }

    public boolean hasNext() {
        if (sourceA == null || sourceB == null) {
            return false;
        }
        while(sourceA != null && sourceA.hasNext()){
            Integer num = sourceA.next();
            if (!visited.contains(num)) {
                visited.add(num);
                current = num;
                return true;
            }
        }
        while(sourceB != null && sourceB.hasNext()){
            Integer num = sourceB.next();
            if (!visited.contains(num)) {
                visited.add(num);
                current = num;
                return true;
            }
        }
        current = null;
        return false;
    }

    public Integer next() {
        if (current == null)
            throw  new NoSuchElementException("no elements anymore");
        return current;
    }
}

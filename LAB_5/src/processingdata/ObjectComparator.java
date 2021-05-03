package processingdata;

import java.io.*;
import java.lang.*;
import java.util.*;

class ObjectComparator<T extends Comparable<T>> implements Comparator<T> {

    public int compare(T a, T b) {
        return a.compareTo(b);
    }
}

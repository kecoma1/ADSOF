package processingdata;

import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * Class that creates a comparator to compare comparable objects.
 * @author Kevin de la Coba Malam and Marcos Bernuy
 */
class ObjectComparator<T extends Comparable<T>> implements Comparator<T> {

    public int compare(T a, T b) {
        return a.compareTo(b);
    }
}

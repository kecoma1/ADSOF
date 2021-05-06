package processingdata;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
import java.lang.*;
import java.util.*;


/**
 * Class that defines a Data agregator.
 * @author Kevin de la Coba Malam and Marcos Bernuy
 */
public class DataAggregator {

    private Map<String, List<? super Object>> data = new LinkedHashMap<>();

    /**
     * Method to add data.
     * @param m Map to be added.
     * @return Object with all the data.
     */
    public DataAggregator add(Map<String, ?> m){
        for (String key : m.keySet()) {
            // if the key is in the dict, the list is created.
            if (!this.data.containsKey(key)) this.data.put(key, new ArrayList<>());
            this.data.get(key).add(m.get(key));
            Collections.sort(this.data.get(key), new ObjectComparator());
        }
        return this;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }

}
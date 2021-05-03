package processingdata;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


/**
 * Class that defines a Data agregator.author Kevin de la Coba and Marcos Aarón Bernuy.
 */
public class DataAggregator {

    private Map<String, List<? super Comparable>> data = new HashMap<>();

    public DataAggregator add(Map<String, ? super Comparable> m){
        for (String key : m.keySet()) {
            // if the key is in the dict, the list is created.
            if (!this.data.containsKey(key)) this.data.put(key, new ArrayList<>());
            this.data.get(key).add(m.get(key));
            this.data.get(key).sort();
        }
    }
}
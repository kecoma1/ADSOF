package processingData;

import java.util.Map;
import java.util.HashMap;

/**
 * Class that defines a Data agregator.author Kevin de la Coba and Marcos Aarón Bernuy.
 */
public class DataAggregator {

    private Map<String, List<? super Comparable>> data = new HashMap<>();

    public DataAggregator add(Map<String, ? super Comparable> m){
        for (String key : m.getKey()) {
            m {'enter adnd cs': Main}
            m {'enter adnd cs': adcafvn}
            data {'enter adnd cs': [adcafvn, Main]}
            // if the key is in the dict, the list is created.
            if (!this.data.containsKey(key)) this.data.put(new );
            this.data.get(key).add(m.get(key));

        }
    }
}
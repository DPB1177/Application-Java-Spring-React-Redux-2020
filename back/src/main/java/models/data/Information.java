package models.data;

import java.util.LinkedHashMap;
import java.util.Map;

public class Information {
    private Map<String, String> pairs = new LinkedHashMap<String, String>();

    public Information() {
    }

    public Information(Map<String, String> pairs) {
        this.pairs = pairs;
    }

    public String getValue(String key) {
        return pairs.get(key);
    }

    public void setValue(String key, String value) {
        this.pairs.put(key, value);
    }

    public Map<String, String> getMap() {
        return pairs;
    }
}

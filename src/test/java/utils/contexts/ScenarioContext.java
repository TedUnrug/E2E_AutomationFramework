package utils.contexts;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private final Map<String, Object> scenarioContext;

    public ScenarioContext(){
        scenarioContext = new HashMap<>();
    }

    public void setScenarioContext(Context key, Object value){
        scenarioContext.put(key.toString(), value);
    }

    public Object getScenarioContextByKey(Context key) {
        return scenarioContext.get(key.toString());
    }
}
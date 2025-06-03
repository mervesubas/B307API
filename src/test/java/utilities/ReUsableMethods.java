package utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class ReUsableMethods {

    /**
     * JSON formatindaki string i parametre olarak alir
     * ve bir map e dönüstürerek return eder
     * @param json
     * @return Map<String, Object>
     */
    public static Map<String, Object> jsonToMap(String json){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, HashMap.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
import org.json.*;

public class JSONValidator {
    public static boolean isValidConfig(String json) {
        try {
            JSONObject obj = new JSONObject(json);
            return obj.has("serviceName") && obj.has("port") && obj.getInt("port") > 0;
        } catch (JSONException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String config = "{\"serviceName\": \"auth-service\", \"port\": 8080}";
        System.out.println("Valid config: " + isValidConfig(config));
    }
}

package asia.clcheng.inspection;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import org.junit.jupiter.api.Test;

public class Resolver {
    @Test
    void jsonResolver() {
        String json = "{\n" +
                "  \"MAT_ID\": \"H231-03829053\"," +
                "  \"FAULTS\": {" +
                "    \"NUM\": 1," +
                "    \"FAULT\" : [" +
                "      {" +
                "      \"TYPE\": \"CRACK\"," +
                "    \"POS\": 1.0" +
                "    }" +
                "    ]" +
                "  }" +
                "}";
        InspectionResult inspectionResult = JSON.parseObject(json, InspectionResult.class);

        JSONObject jsonObject = JSONObject.parseObject(json);

        String matId = jsonObject.getString("MAT_ID");
        JSONObject faults = jsonObject.getJSONObject("FAULTS");
        Integer num = faults.getInteger("NUM");
        JSONArray fault = faults.getJSONArray("FAULT");
        for (int i = 0; i < num; i++) {
            JSONObject jsonObject1 = fault.getJSONObject(i);
            String string = jsonObject1.getString("TYPE");
            Double pos = jsonObject1.getDouble("POS");
            System.out.println(string + pos);
        }
        System.out.println(matId + num);
    }

}

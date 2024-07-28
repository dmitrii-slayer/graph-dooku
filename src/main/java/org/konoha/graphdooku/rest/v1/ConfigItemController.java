package org.konoha.graphdooku.rest.v1;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.konoha.graphdooku.domain.entity.ConfigItem;
import org.konoha.graphdooku.service.ConfigItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class ConfigItemController {

    private final ConfigItemService configItemService;
    private final ObjectMapper mapper = new ObjectMapper();

//    @PostMapping("/ci")
//    public ResponseEntity<String> saveConfigItem(@RequestBody ConfigItem configItem) {
//        configItemService.saveConfigItem(configItem);
//        return ResponseEntity.ok("OK");
//    }

    @PostMapping("/ci")
    public ResponseEntity<String> saveConfigItem(@RequestBody JsonNode configItemJson) {
        Map<String, Object> ciFields = new HashMap<>();
        Iterator<Map.Entry<String, JsonNode>> fields = configItemJson.get("fields").fields();
        fields.forEachRemaining(entry -> {
            JsonNode value = entry.getValue();
            if (value.isObject() || value.isArray()) {
                ciFields.put(entry.getKey(), value.toPrettyString());
            } else {
                ciFields.put(entry.getKey(), value.asText());
            }
        });
        ConfigItem ci = ConfigItem.builder()
                .businessId(configItemJson.get("businessId").textValue())
                .fields(ciFields)
                .build();
        configItemService.saveConfigItem(ci);
        return ResponseEntity.ok("OK");
    }
}

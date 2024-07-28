package org.konoha.graphdooku.service;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.konoha.graphdooku.domain.entity.ConfigItem;
import org.konoha.graphdooku.domain.repository.ConfigItemRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class ConfigItemServiceImpl implements ConfigItemService {

    private final ConfigItemRepository configItemRepository;

    @Override
    public void processCiEvent(JsonNode ciJson) {
        Map<String, Object> ciFields = new HashMap<>();
        Iterator<Map.Entry<String, JsonNode>> fields = ciJson.get("fields").fields();
        fields.forEachRemaining(entry -> {
            JsonNode value = entry.getValue();
            if (value.isObject() || value.isArray()) {
                ciFields.put(entry.getKey(), value.toPrettyString());
            } else {
                ciFields.put(entry.getKey(), value.asText());
            }
        });
        ConfigItem ci = ConfigItem.builder()
                .businessId(ciJson.get("businessId").textValue())
                .fields(ciFields)
                .build();
        saveConfigItem(ci);
    }

    @Override
    public void saveConfigItem(ConfigItem configItem) {
        configItemRepository.save(configItem);
    }
}

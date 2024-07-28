package org.konoha.graphdooku.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.konoha.graphdooku.domain.entity.ConfigItem;

public interface ConfigItemService {

    void processCiEvent(JsonNode ciJson);

    void saveConfigItem(ConfigItem configItem);
}

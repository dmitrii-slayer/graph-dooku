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

//    @PostMapping("/ci")
//    public ResponseEntity<String> saveConfigItem(@RequestBody ConfigItem configItem) {
//        configItemService.saveConfigItem(configItem);
//        return ResponseEntity.ok("OK");
//    }

    @PostMapping("/ci")
    public ResponseEntity<String> saveConfigItem(@RequestBody JsonNode configItemJson) {
        configItemService.processCiEvent(configItemJson);
        return ResponseEntity.ok("OK");
    }
}

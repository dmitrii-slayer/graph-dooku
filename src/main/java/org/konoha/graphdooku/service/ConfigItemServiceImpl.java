package org.konoha.graphdooku.service;

import lombok.RequiredArgsConstructor;
import org.konoha.graphdooku.domain.entity.ConfigItem;
import org.konoha.graphdooku.domain.repository.ConfigItemRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ConfigItemServiceImpl implements ConfigItemService{

    private final ConfigItemRepository configItemRepository;

    @Override
    public void saveConfigItem(ConfigItem configItem) {
        configItemRepository.save(configItem);
    }
}

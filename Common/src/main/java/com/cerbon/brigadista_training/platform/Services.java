package com.cerbon.brigadista_training.platform;

import com.cerbon.brigadista_training.BrigadistaTraining;

import java.util.ServiceLoader;

public class Services {

    public static <T> T load(Class<T> clazz) {
        final T loadedService = ServiceLoader.load(clazz)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
        BrigadistaTraining.LOGGER.debug("Loaded {} for service {}", loadedService, clazz);
        return loadedService;
    }
}

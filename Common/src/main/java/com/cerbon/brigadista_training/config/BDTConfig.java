package com.cerbon.brigadista_training.config;

import com.cerbon.brigadista_training.BrigadistaTraining;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = BrigadistaTraining.MOD_ID)
public class BDTConfig implements ConfigData {
    public String apiKey = "";
}

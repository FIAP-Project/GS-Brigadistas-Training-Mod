package com.cerbon.brigadista_training;

import com.cerbon.brigadista_training.block.BDTBlocks;
import com.cerbon.brigadista_training.block_entity.BDTBlockEntities;
import com.cerbon.brigadista_training.config.BDTConfig;
import com.cerbon.brigadista_training.item.BDTArmorMaterials;
import com.cerbon.brigadista_training.item.BDTItems;
import com.cerbon.brigadista_training.packet.BDTPackets;
import com.mojang.logging.LogUtils;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import org.slf4j.Logger;

public class BrigadistaTraining {
	public static final String MOD_ID = "brigadista_training";
	public static final String MOD_NAME = "Brigadista Training";

	public static final Logger LOGGER = LogUtils.getLogger();

	public static BDTConfig config;

	public static void init() {
		AutoConfig.register(BDTConfig.class, JanksonConfigSerializer::new);
		AutoConfig.getConfigHolder(BDTConfig.class).save();
		config = AutoConfig.getConfigHolder(BDTConfig.class).get();

		BDTArmorMaterials.register();
		BDTItems.register();

		BDTBlocks.register();
		BDTBlockEntities.register();

		BDTPackets.register();
	}
}

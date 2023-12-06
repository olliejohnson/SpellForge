package io.oliverj.spellforge;

import com.mna.api.guidebook.RegisterGuidebooksEvent;
import com.mna.api.rituals.RitualEffect;
import com.mojang.logging.LogUtils;
import io.oliverj.spellforge.effects.EffectsInit;
import io.oliverj.spellforge.items.ItemInit;
import io.oliverj.spellforge.rituals.SealingSpaceEffect;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SpellForge.MOD_ID)
public class SpellForge {

    public static final String MOD_ID = "spellforge";

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public SpellForge() {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the setup method for modloading
        EffectsInit.register(eventBus);
        ItemInit.register(eventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onRegisterGuidebooks(RegisterGuidebooksEvent event) {
        event.getRegistry().addGuidebookPath(new ResourceLocation(MOD_ID, "guide"));
    }

    @Mod.EventBusSubscriber(
            bus=Mod.EventBusSubscriber.Bus.MOD
    )
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            LOGGER.info("Register Blocks");
        }

        @SubscribeEvent
        public static void onRitualsRegistry(final RegistryEvent.Register<RitualEffect> event) {
            event.getRegistry().register(new SealingSpaceEffect(new ResourceLocation(MOD_ID, "rituals/sealing")).setRegistryName(new ResourceLocation(MOD_ID, "sealing-ritual-effect")));
        }
    }
}

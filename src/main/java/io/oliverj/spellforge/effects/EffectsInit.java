package io.oliverj.spellforge.effects;

import io.oliverj.spellforge.SpellForge;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EffectsInit {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, SpellForge.MOD_ID);

    public static final RegistryObject<MobEffect> SEALING = MOB_EFFECTS.register("sealing",
            () -> new SealingEffect(MobEffectCategory.HARMFUL, 3124687));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}

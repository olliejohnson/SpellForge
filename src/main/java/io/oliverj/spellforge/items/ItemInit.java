package io.oliverj.spellforge.items;

import io.oliverj.spellforge.SpellForge;
import io.oliverj.spellforge.effects.BurningEffect;
import io.oliverj.spellforge.effects.SealingEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS
            = DeferredRegister.create(ForgeRegistries.ITEMS, SpellForge.MOD_ID);

    public static final RegistryObject<Item> BURNING_FRUIT = ITEMS.register(
            "burning_fruit", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
                    .food(new FoodProperties.Builder().nutrition(20).saturationMod(20)
                            .alwaysEat()
                            .effect(new MobEffectInstance(new BurningEffect(MobEffectCategory.HARMFUL, 0), 20, 0, true, false), 1.0f).build()))
    );

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}

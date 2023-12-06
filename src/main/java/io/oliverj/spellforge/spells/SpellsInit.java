package io.oliverj.spellforge.spells;

import com.mna.api.spells.parts.Shape;
import com.mna.api.spells.parts.SpellEffect;
import io.oliverj.spellforge.SpellForge;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(
        bus = Mod.EventBusSubscriber.Bus.MOD,
        modid = SpellForge.MOD_ID
)
public class SpellsInit {
    @SubscribeEvent
    public static void onShapesRegistering(RegistryEvent.Register<Shape> event) {
        event.getRegistry().register(new ShapeTarget(new ResourceLocation(SpellForge.MOD_ID, "target"), new ResourceLocation(SpellForge.MOD_ID, "textures/target.png")));
    }

    @SubscribeEvent
    public static void onComponentsRegistering(RegistryEvent.Register<SpellEffect> event) {
        event.getRegistry().register(new ComponentSealing(new ResourceLocation(SpellForge.MOD_ID, "sealing"), new ResourceLocation(SpellForge.MOD_ID, "textures/sealing.png")));
    }
}

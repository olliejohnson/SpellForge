package io.oliverj.spellforge.effects;

import io.oliverj.spellforge.items.ItemInit;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class SealingEffect extends MobEffect {
    public SealingEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyEffectTick(LivingEntity target, int amplifier) {
        if (!target.level.isClientSide) {
            double x = target.getX() - target.getDeltaMovement().x;
            double y = target.getY();
            double z = target.getZ() - target.getDeltaMovement().z;

            target.teleportTo(x, y, z);
            target.setDeltaMovement(0, 0,0);
        }
        super.applyEffectTick(target, amplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }

    @Override
    public List<ItemStack> getCurativeItems() {
        return List.of(new ItemStack(ItemInit.BURNING_FRUIT.get()));
    }
}

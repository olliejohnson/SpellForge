package io.oliverj.spellforge.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class BurningEffect extends MobEffect {
    public BurningEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyEffectTick(LivingEntity target, int amplifier) {
        target.setSecondsOnFire(5);
        super.applyEffectTick(target, amplifier);
    }

    @Override
    public boolean isInstantenous() {
        return true;
    }
}

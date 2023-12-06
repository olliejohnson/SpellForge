package io.oliverj.spellforge.rituals;

import com.mna.api.rituals.IRitualContext;
import com.mna.api.rituals.RitualEffect;
import io.oliverj.spellforge.effects.EffectsInit;
import io.oliverj.spellforge.effects.SealingEffect;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;

public class SealingSpaceEffect extends RitualEffect {

    public SealingSpaceEffect(ResourceLocation ritualName) {
        super(ritualName);
    }
    @Override
    protected boolean applyRitualEffect(IRitualContext context) {
        LivingEntity target = context.getWorld().getNearestPlayer(TargetingConditions.forNonCombat().ignoreLineOfSight().ignoreInvisibilityTesting(), context.getCaster().getX(), context.getCaster().getY(), context.getCaster().getZ());
        MobEffectInstance sealing_effect = new MobEffectInstance(new SealingEffect(MobEffectCategory.HARMFUL, 3124687), 3600*20, 0, true, false);
        assert target != null;
        target.addEffect(sealing_effect);
        return true;
    }

    @Override
    protected int getApplicationTicks(IRitualContext context) {
        return 10;
    }
}

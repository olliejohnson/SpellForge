package io.oliverj.spellforge.spells;

import com.mna.api.affinity.Affinity;
import com.mna.api.spells.ComponentApplicationResult;
import com.mna.api.spells.SpellReagent;
import com.mna.api.spells.attributes.Attribute;
import com.mna.api.spells.attributes.AttributeValuePair;
import com.mna.api.spells.base.IModifiedSpellPart;
import com.mna.api.spells.parts.SpellEffect;
import com.mna.api.spells.targeting.SpellContext;
import com.mna.api.spells.targeting.SpellSource;
import com.mna.api.spells.targeting.SpellTarget;
import io.oliverj.spellforge.effects.SealingEffect;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.ArrayList;
import java.util.List;

public class ComponentSealing extends SpellEffect {

    public static final ArrayList<SpellReagent> required_reagents = new ArrayList<SpellReagent>();

    static {
        required_reagents.add(new SpellReagent(new ItemStack(Items.CHAIN), false, false, true));
    }

    public ComponentSealing(ResourceLocation registryName, ResourceLocation guiIcon) {
        super(registryName, guiIcon, new AttributeValuePair[] {
                new AttributeValuePair(Attribute.DURATION, 30, 10, 300, 10, 0.5f)
        });
    }

    @Override
    public int requiredXPForRote() {
        return 150;
    }

    @Override
    public ComponentApplicationResult ApplyEffect(SpellSource source, SpellTarget target, IModifiedSpellPart<SpellEffect> attributes, SpellContext context) {
        if (!(target.getEntity() instanceof LivingEntity)) {
            return ComponentApplicationResult.FAIL;
        }

        MobEffectInstance inst = new MobEffectInstance(new SealingEffect(MobEffectCategory.HARMFUL, 3124687), 20);
        ((LivingEntity) target.getEntity()).addEffect(inst);

        return ComponentApplicationResult.SUCCESS;
    }

    @Override
    public Affinity getAffinity() {
        return Affinity.ENDER;
    }

    @Override
    public List<SpellReagent> getRequiredReagents(Player caster, InteractionHand hand) {
        return required_reagents;
    }

    @Override
    public float initialComplexity() {
        return 10;
    }
}

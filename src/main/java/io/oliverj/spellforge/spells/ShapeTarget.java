package io.oliverj.spellforge.spells;

import com.mna.api.spells.attributes.Attribute;
import com.mna.api.spells.attributes.AttributeValuePair;
import com.mna.api.spells.base.IModifiedSpellPart;
import com.mna.api.spells.base.ISpellDefinition;
import com.mna.api.spells.parts.Shape;
import com.mna.api.spells.targeting.SpellSource;
import com.mna.api.spells.targeting.SpellTarget;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

import java.util.Arrays;
import java.util.List;

public class ShapeTarget extends Shape {

    public ShapeTarget(ResourceLocation registryName, ResourceLocation guiIcon) {
        super(registryName, guiIcon, new AttributeValuePair[] {
                new AttributeValuePair(Attribute.RADIUS, 2, 1, 5, 1, 0.5f)
        });
    }

    @Override
    public int requiredXPForRote() {
        return 150;
    }

    @Override
    public List<SpellTarget> Target(SpellSource source, Level world, IModifiedSpellPart<Shape> attributes, ISpellDefinition spell) {
        if (!source.hasCasterReference()) {
            return Arrays.asList(SpellTarget.NONE);
        }

        float radius = attributes.getValue(Attribute.RADIUS);

        return world.getEntities(source.getCaster(), source.getBoundingBox().inflate(radius),
                (candidate) -> {
            return candidate.isAlive() &&
                    candidate instanceof LivingEntity;
                })
                .stream()
                .map(livingentity -> new SpellTarget(livingentity))
                .toList();
    }

    @Override
    public float initialComplexity() {
        return 5; //baseline complexity
    }
}

package hexagon.buzzydrones.client.renderer;

import hexagon.buzzydrones.common.entity.DroneEntity;
import hexagon.buzzydrones.core.BuzzyDrones;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
@MethodsReturnNonnullByDefault
public class DroneRenderer extends MobRenderer<DroneEntity, DroneModel<DroneEntity>> {
    
    private static final ResourceLocation droneBlueTexture = new ResourceLocation(BuzzyDrones.ID, "textures/entity/drone_blue.png");
    private static final ResourceLocation droneGreenTexture = new ResourceLocation(BuzzyDrones.ID, "textures/entity/drone_green.png");
    private static final ResourceLocation droneOrangeTexture = new ResourceLocation(BuzzyDrones.ID, "textures/entity/drone_orange.png");
    private static final ResourceLocation droneRedTexture = new ResourceLocation(BuzzyDrones.ID, "textures/entity/drone_red.png");

    public DroneRenderer(EntityRendererProvider.Context renderProvider) {
        super(renderProvider, new DroneModel<>(), 0.4f);
    }

    @Override
    public ResourceLocation getTextureLocation(DroneEntity entity) {
        return switch (entity.getStatus()) {
            case WORKING -> droneBlueTexture;
            case IDLE -> droneGreenTexture;
            case WARNING -> droneOrangeTexture;
            default -> droneRedTexture;
        };
    }
}

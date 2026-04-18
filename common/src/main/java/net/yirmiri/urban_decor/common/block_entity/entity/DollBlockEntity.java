package net.yirmiri.urban_decor.common.block_entity.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.yirmiri.urban_decor.common.block.appliances.DollBlock;
import net.yirmiri.urban_decor.core.registry.UDBlockEntities;

public class DollBlockEntity extends BlockEntity {
    private ResourceLocation texture;

    public DollBlockEntity(BlockPos pos, BlockState state) {
        super(UDBlockEntities.DOLL.get(), pos, state);
    }

    public int getVariant() {
        return getBlockState().getValue(DollBlock.POSE);
    }

    public void setTexture(ResourceLocation id) {
        this.texture = id;
        setChanged();
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return saveWithoutMetadata(registries);
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public ResourceLocation getTexture() {
        return texture;
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        if (texture != null) {
            tag.putString("Texture", texture.toString());
        }
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        if (tag.contains("Texture")) {
            texture = ResourceLocation.parse(tag.getString("Texture"));
        }
    }
}

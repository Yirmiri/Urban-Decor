package net.yirmiri.urban_decor.datagen;

import net.azurune.runiclib.RunicLib;
import net.minecraft.data.models.BlockModelGenerators;
import net.yirmiri.urban_decor.UrbanDecor;
import net.yirmiri.urban_decor.common.util.WrapColor;

import java.util.Map;

public class UDModelAppliances {
    public static void generatePetBeds(BlockModelGenerators generator, WrapColor colors) {
        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_pet_bed"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/pet_bed"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_pet_bed"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_mattress")
                ));
    }

    public static void generateBooths(BlockModelGenerators generator, WrapColor colors) {
        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_booth"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/booth"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_booth"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_mattress")
                ));
        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_booth_inner"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/booth_inner"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_booth"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_mattress")
                ));
        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_booth_outer"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/booth_outer"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_booth"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_mattress")
                ));
        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_booth_armrests"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/booth_armrests"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_booth"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_mattress")
                ));
    }

    public static void generateBathtubs(BlockModelGenerators generator, WrapColor colors) {
        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_bathtub_back"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/bathtub_back"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_bathtub"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_bathtub_front"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/bathtub_front"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_bathtub"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_bathtub_back"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_bathtub_back"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_bathtub"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_bathtub_front"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_bathtub_front"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_bathtub"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
    }

    public static void generateToilets(BlockModelGenerators generator, WrapColor colors) {
        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_toilet"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/toilet"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_toilet"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_toilet_alt"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/toilet_alt"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_toilet"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_toilet_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/toilet_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_toilet"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_toilet_alt_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/toilet_alt_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_toilet"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_toilet"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_toilet"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_toilet"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_toilet_alt"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_toilet_alt"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_toilet"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_toilet_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_toilet_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_toilet"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_toilet_alt_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_toilet_alt_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_toilet"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
    }

    public static void generateSinks(BlockModelGenerators generator, WrapColor colors) {
        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_sink"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/sink"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_sink"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_sink_bare"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/sink_bare"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_sink"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_sink_cupboard"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/sink_cupboard"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_sink"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_sink_fullsize"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/sink_fullsize"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_sink"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_sink_large"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/sink_large"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_sink"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_sink"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_sink"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_sink"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_sink_bare"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_sink_bare"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_sink"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_sink_cupboard"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_sink_cupboard"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_sink"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_sink_fullsize"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_sink_fullsize"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_sink"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_sink_large"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_sink_large"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_sink"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
    }

    public static void generateWashingMachines(BlockModelGenerators generator, WrapColor colors) {
        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_washing_machine"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/washing_machine"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_washing_machine"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_washing_machine_opaque"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/washing_machine_opaque"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_washing_machine"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_washing_machine_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/washing_machine_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_washing_machine"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_washing_machine_opaque_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/washing_machine_opaque_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_washing_machine"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_washing_machine"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_washing_machine"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_washing_machine"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_washing_machine_opaque"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_washing_machine_opaque"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_washing_machine"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_washing_machine_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_washing_machine_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_washing_machine"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_washing_machine_opaque_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_washing_machine_opaque_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_washing_machine"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
    }

    public static void generateOvens(BlockModelGenerators generator, WrapColor colors) {
        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_oven"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/oven"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_oven"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_oven_opaque"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/oven_opaque"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_oven"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_oven_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/oven_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_oven"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_oven_opaque_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/oven_opaque_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_oven"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_oven"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_oven"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_oven"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_oven_opaque"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_oven_opaque"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_oven"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_oven_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_oven_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_oven"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_oven_opaque_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_oven_opaque_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_oven"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_oven_on"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/oven_on"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_oven_on"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_oven_opaque_on"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/oven_opaque_on"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_oven_on"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_oven_open_on"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/oven_open_on"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_oven_on"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_oven_opaque_open_on"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/oven_opaque_open_on"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_oven_on"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_oven_on"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_oven_on"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_oven_on"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_oven_opaque_on"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_oven_opaque_on"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_oven_on"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_oven_open_on"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_oven_open_on"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_oven_on"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_oven_opaque_open_on"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_oven_opaque_open_on"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_oven_on"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
    }

    public static void generateCupboards(BlockModelGenerators generator, WrapColor colors) {
        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_cupboard"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/cupboard"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_cupboard"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_cupboard_slim"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/cupboard_slim"), Map.of(
                        "1", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_cupboard"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_cupboard_slim_topless"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/cupboard_slim_topless"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_cupboard"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_cupboard_topless"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/cupboard_topless"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_cupboard"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_cupboard"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_cupboard"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_cupboard"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_cupboard_slim"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_cupboard_slim"), Map.of(
                        "1", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_cupboard"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_cupboard_slim_topless"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_cupboard_slim_topless"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_cupboard"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_cupboard_topless"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_cupboard_topless"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_cupboard"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_cupboard_fullsize"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/cupboard_fullsize"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_cupboard"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_cupboard_fullsize_topless"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/cupboard_fullsize_topless"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_cupboard"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_cupboard_fullsize"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_cupboard_fullsize"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_cupboard"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_cupboard_fullsize_topless"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_cupboard_fullsize_topless"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_cupboard"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
    }

    public static void generateDishwashers(BlockModelGenerators generator, WrapColor colors) {
        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dishwasher"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dishwasher"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dishwasher"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dishwasher_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dishwasher_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dishwasher"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_dishwasher"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_dishwasher"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_dishwasher"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_dishwasher_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_dishwasher_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_dishwasher"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
    }

    public static void generateDryers(BlockModelGenerators generator, WrapColor colors) {
        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dryer"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dryer"), Map.of(
                        "1", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dryer"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dryer_opaque"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dryer_opaque"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dryer"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dryer_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dryer_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dryer"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dryer_opaque_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dryer_opaque_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dryer"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_dryer"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_dryer"), Map.of(
                        "1", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_dryer"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_dryer_opaque"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_dryer_opaque"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_dryer"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_dryer_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_dryer_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_dryer"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_dryer_opaque_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_dryer_opaque_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_dryer"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
    }

    public static void generateFreezers(BlockModelGenerators generator, WrapColor colors) {
        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_freezer"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/freezer"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_freezer"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_freezer_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/freezer_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_freezer"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_freezer"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_freezer"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_freezer"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_freezer_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_freezer_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_freezer"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
    }

    public static void generateFridges(BlockModelGenerators generator, WrapColor colors) {
        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_fridge"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/fridge"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_fridge"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_fridge_flipped"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/fridge_flipped"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_fridge"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_fridge_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/fridge_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_fridge"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_fridge_flipped_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/fridge_flipped_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_fridge"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_fridge"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_fridge"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_fridge"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_fridge_flipped"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_fridge_flipped"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_fridge"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_fridge_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_fridge_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_fridge"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));

        UDModelProvider.createParentedModel(generator, RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_fridge_flipped_open"),
                RunicLib.customid(UrbanDecor.MOD_ID, "block/dark_fridge_flipped_open"), Map.of(
                        "0", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_dark_fridge"),
                        "particle", RunicLib.customid(UrbanDecor.MOD_ID, "block/" + colors.getName() + "_wrapped_porcelain_block")
                ));
    }
}

package com.jannik.create_tasty_snacks

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.item.FoodComponent
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.text.Text
import net.minecraft.util.Identifier

object TastySnacks : ModInitializer {
    val SWEETER_MELON = Item(
        Item.Settings()
            .food(
                FoodComponent.Builder()
                    .hunger(6)
                    .saturationModifier(0.8f)
                    .statusEffect(StatusEffectInstance(StatusEffects.GLOWING, 200, 1), 1.0f)
                    .build()
            )
    )

    val RED_LOLLIPOP = Item(
        Item.Settings()
            .food(
                FoodComponent.Builder()
                    .hunger(4)
                    .saturationModifier(0.2f)
                    .statusEffect(StatusEffectInstance(StatusEffects.REGENERATION, 300, 2), 1.0f)
                    .alwaysEdible()
                    .snack()
                    .build()
            )
    )

    val BLUE_LOLLIPOP = Item(
        Item.Settings()
            .food(
                FoodComponent.Builder()
                    .hunger(4)
                    .saturationModifier(0.2f)
                    .statusEffect(StatusEffectInstance(StatusEffects.SPEED, 300, 2), 1.0f)
                    .alwaysEdible()
                    .snack()
                    .build()
            )
    )

    val GREEN_LOLLIPOP = Item(
        Item.Settings()
            .food(
                FoodComponent.Builder()
                    .hunger(4)
                    .saturationModifier(0.2f)
                    .statusEffect(StatusEffectInstance(StatusEffects.LUCK, 6000, 1), 1.0f)
                    .alwaysEdible()
                    .snack()
                    .build()
            )
    )

    val YELLOW_LOLLIPOP = Item(
        Item.Settings()
            .food(
                FoodComponent.Builder()
                    .hunger(4)
                    .saturationModifier(0.2f)
                    .statusEffect(StatusEffectInstance(StatusEffects.HASTE, 3000, 2), 1.0f)
                    .alwaysEdible()
                    .snack()
                    .build()
            )
    )

    val ORANGE_LOLLIPOP = Item(
        Item.Settings()
            .food(
                FoodComponent.Builder()
                    .hunger(4)
                    .saturationModifier(0.2f)
                    .statusEffect(StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 3000, 1), 1.0f)
                    .alwaysEdible()
                    .snack()
                    .build()
            )
    )

    val WARDEN_LOLLIPOP = Item(
        Item.Settings()
            .food(
                FoodComponent.Builder()
                    .hunger(4)
                    .saturationModifier(0.2f)
                    .statusEffect(StatusEffectInstance(StatusEffects.DARKNESS, 200, 2), 1.0f)
                    .alwaysEdible()
                    .snack()
                    .build()
            )
    )

    val BAD_OMEN_LOLLIPOP = Item(
        Item.Settings()
            .food(
                FoodComponent.Builder()
                    .hunger(4)
                    .saturationModifier(0.2f)
                    .statusEffect(StatusEffectInstance(StatusEffects.BAD_OMEN, 60000, 1), 1.0f)
                    .alwaysEdible()
                    .snack()
                    .build()
            )
    )

    val INVISIBLE_LOLLIPOP = Item(
        Item.Settings()
            .food(
                FoodComponent.Builder()
                    .hunger(4)
                    .saturationModifier(0.2f)
                    .statusEffect(StatusEffectInstance(StatusEffects.INVISIBILITY, 3000, 1), 1.0f)
                    .alwaysEdible()
                    .snack()
                    .build()
            )
    )

    val CREATE_TASTY_SNACKS_GROUP: RegistryKey<ItemGroup> = RegistryKey.of(
        Registries.ITEM_GROUP.key,
        Identifier("create-tasty-snacks", "create_tasty_snacks")
    )

    override fun onInitialize() {
        Registry.register(Registries.ITEM, Identifier("create-tasty-snacks", "sweeter-melon"), SWEETER_MELON)
        Registry.register(Registries.ITEM, Identifier("create-tasty-snacks", "red-lollipop"), RED_LOLLIPOP)
        Registry.register(Registries.ITEM, Identifier("create-tasty-snacks", "blue-lollipop"), BLUE_LOLLIPOP)
        Registry.register(Registries.ITEM, Identifier("create-tasty-snacks", "green-lollipop"), GREEN_LOLLIPOP)
        Registry.register(Registries.ITEM, Identifier("create-tasty-snacks", "yellow-lollipop"), YELLOW_LOLLIPOP)
        Registry.register(Registries.ITEM, Identifier("create-tasty-snacks", "orange-lollipop"), ORANGE_LOLLIPOP)
        Registry.register(Registries.ITEM, Identifier("create-tasty-snacks", "warden-lollipop"), WARDEN_LOLLIPOP)
        Registry.register(Registries.ITEM, Identifier("create-tasty-snacks", "bad-omen-lollipop"), BAD_OMEN_LOLLIPOP)
        Registry.register(Registries.ITEM, Identifier("create-tasty-snacks", "invisible-lollipop"), INVISIBLE_LOLLIPOP)

        Registry.register(
            Registries.ITEM_GROUP,
            CREATE_TASTY_SNACKS_GROUP.value,
            FabricItemGroup.builder()
                .icon { ItemStack(SWEETER_MELON) }
                .displayName(Text.translatable("itemGroup.create-tasty-snacks.create_tasty_snacks"))
                .build()
        )

        ItemGroupEvents.modifyEntriesEvent(CREATE_TASTY_SNACKS_GROUP).register { entries ->
            entries.add(SWEETER_MELON)
            entries.add(RED_LOLLIPOP)
            entries.add(BLUE_LOLLIPOP)
            entries.add(GREEN_LOLLIPOP)
            entries.add(YELLOW_LOLLIPOP)
            entries.add(ORANGE_LOLLIPOP)
            entries.add(WARDEN_LOLLIPOP)
            entries.add(BAD_OMEN_LOLLIPOP)
            entries.add(INVISIBLE_LOLLIPOP)
        }
    }
}
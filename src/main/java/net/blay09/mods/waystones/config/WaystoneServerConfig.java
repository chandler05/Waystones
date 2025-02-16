package net.blay09.mods.waystones.config;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Collections;
import java.util.List;

public class WaystoneServerConfig {
    public final ForgeConfigSpec.BooleanValue inverseXpCost;
    public final ForgeConfigSpec.IntValue blocksPerXPLevel;
    public final ForgeConfigSpec.DoubleValue minimumXpCost;
    public final ForgeConfigSpec.DoubleValue maximumXpCost;

    public final ForgeConfigSpec.DoubleValue waystoneXpCostMultiplier;
    public final ForgeConfigSpec.DoubleValue sharestoneXpCostMultiplier;
    public final ForgeConfigSpec.DoubleValue portstoneXpCostMultiplier;

    public final ForgeConfigSpec.DoubleValue warpPlateXpCostMultiplier;
    public final ForgeConfigSpec.IntValue warpPlateUseTime;

    public final ForgeConfigSpec.ConfigValue<String> inventoryButton;
    public final ForgeConfigSpec.DoubleValue inventoryButtonXpCostMultiplier;
    public final ForgeConfigSpec.IntValue inventoryButtonCooldown;

    public final ForgeConfigSpec.DoubleValue globalWaystoneXpCostMultiplier;
    public final ForgeConfigSpec.DoubleValue globalWaystoneCooldownMultiplier;
    public final ForgeConfigSpec.BooleanValue globalWaystoneRequiresCreative;

    public final ForgeConfigSpec.DoubleValue warpStoneXpCostMultiplier;
    public final ForgeConfigSpec.IntValue warpStoneCooldown;
    public final ForgeConfigSpec.IntValue warpStoneUseTime;

    public final ForgeConfigSpec.IntValue scrollUseTime;

    public final ForgeConfigSpec.EnumValue<DimensionalWarp> dimensionalWarp;
    public final ForgeConfigSpec.IntValue dimensionalWarpXpCost;

    public final ForgeConfigSpec.BooleanValue restrictToCreative;
    public final ForgeConfigSpec.BooleanValue restrictRenameToOwner;
    public final ForgeConfigSpec.BooleanValue generatedWaystonesUnbreakable;

    public final ForgeConfigSpec.BooleanValue transportLeashed;
    public final ForgeConfigSpec.BooleanValue transportLeashedDimensional;
    public final ForgeConfigSpec.IntValue costPerLeashed;
    public final ForgeConfigSpec.ConfigValue<List<? extends String>> leashedBlacklist;

    WaystoneServerConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("These options will be synced to joining clients.").push("server");

        builder.comment("Note: Base XP cost is based on the distance travelled.").push("baseXpCost");

        inverseXpCost = builder
                .comment("Set to true if experience cost should be inverted, meaning the shorter the distance, the more expensive. Can be used to encourage other methods for short-distance travel.")
                .translation("config.waystones.inverseXpCost")
                .define("inverseXpCost", false);

        blocksPerXPLevel = builder
                .comment("The amount of blocks per xp level requirement. If set to 500, the base xp cost for travelling 1000 blocks will be 2 levels.")
                .translation("config.waystones.blocksPerXPLevel")
                .defineInRange("blocksPerXPLevel", 1000, 1, Integer.MAX_VALUE);

        minimumXpCost = builder
                .comment("The minimum base xp cost")
                .translation("config.waystones.minimumXpCost")
                .defineInRange("minimumXpCost", 0, 0, Float.POSITIVE_INFINITY);

        maximumXpCost = builder
                .comment("The maximum base xp cost (may be exceeded by multipliers defined below), set to 0 to disable all distance-based XP costs")
                .translation("config.waystones.maximumXpCost")
                .defineInRange("maximumXpCost", 0, 0, Float.POSITIVE_INFINITY);

        builder.pop().comment("These options apply to teleporting from one waystone to another by right-clicking it.").push("waystoneToWaystone");

        waystoneXpCostMultiplier = builder
                .comment("The multiplier applied to the base xp cost when teleporting from one waystone to another.")
                .translation("config.waystones.waystoneXpCostMultiplier")
                .defineInRange("waystoneXpCostMultiplier", 1, 0, Float.POSITIVE_INFINITY);

        sharestoneXpCostMultiplier = builder
                .comment("The multiplier applied to the base xp cost when teleporting from one sharestone to another.")
                .translation("config.waystones.sharestoneXpCostMultiplier")
                .defineInRange("sharestoneXpCostMultiplier", 1, 0, Float.POSITIVE_INFINITY);

        portstoneXpCostMultiplier = builder
                .comment("The multiplier applied to the base xp cost when teleporting from a portstone.")
                .translation("config.waystones.portstoneXpCostMultiplier")
                .defineInRange("portstoneXpCostMultiplier", 0, 0, Float.POSITIVE_INFINITY);

        builder.pop().comment("These options apply to warp plates.").push("warpPlate");

        warpPlateXpCostMultiplier = builder
                .comment("The multiplier applied to the base xp cost when teleporting from one warp plate to another.")
                .translation("config.waystones.warpPlateXpCostMultiplier")
                .defineInRange("warpPlateXpCostMultiplier", 0, 0, Float.POSITIVE_INFINITY);

        warpPlateUseTime = builder
                .comment("The time in ticks that it takes to use a warp plate. This is the time the player has to stand on top for.")
                .translation("config.waystones.warpPlateUseTime")
                .defineInRange("warpPlateUseTime", 20, 0, Integer.MAX_VALUE);

        builder.pop().comment("These options apply to the optional Waystones button displayed in the inventory.").push("inventoryButton");

        inventoryButton = builder
                .comment("Set to 'NONE' for no inventory button. Set to 'NEAREST' for an inventory button that teleports to the nearest waystone. Set to 'ANY' for an inventory button that opens the waystone selection menu. Set to a waystone name for an inventory button that teleports to a specifically named waystone.")
                .translation("config.waystones.inventoryButton")
                .define("inventoryButton", "NONE");

        inventoryButtonXpCostMultiplier = builder
                .comment("The multiplier applied to the base xp cost when teleporting via the inventory button.")
                .translation("config.waystones.inventoryButtonXpCostMultiplier")
                .defineInRange("inventoryButtonXpCostMultiplier", 0, 0, Float.POSITIVE_INFINITY);

        inventoryButtonCooldown = builder
                .comment("The cooldown between usages of the inventory button in seconds.")
                .translation("config.waystones.inventoryButtonCooldown")
                .defineInRange("inventoryButtonCooldown", 300, 0, Integer.MAX_VALUE);

        builder.pop().comment("These options apply to the global waystones.").push("globalWaystones");

        globalWaystoneXpCostMultiplier = builder
                .comment("The multiplier applied to the base xp cost when teleporting to a global waystone through any method.")
                .translation("config.waystones.globalWaystonesXpCostMultiplier")
                .defineInRange("globalWaystonesXpCostMultiplier", 1, 0, Float.POSITIVE_INFINITY);

        globalWaystoneCooldownMultiplier = builder
                .comment("The multiplier applied to the cooldown when teleporting to a global waystone via inventory button or warp stone.")
                .translation("config.waystones.globalWaystoneCooldownMultiplier")
                .defineInRange("globalWaystoneCooldownMultiplier", 1, 0, Float.POSITIVE_INFINITY);

        globalWaystoneRequiresCreative = builder
                .comment("Set to false to allow non-creative players to make waystones globally activated for all players.")
                .translation("config.waystones.globalWaystoneRequiresCreative")
                .define("globalWaystoneRequiresCreative", true);

        builder.pop().comment("These options apply to teleporting using the Warp Stone item.").push("warpStone");

        warpStoneXpCostMultiplier = builder
                .comment("The multiplier applied to the base xp cost when teleporting using a Warp Stone item (not the Waystone block, John)")
                .translation("config.waystones.warpStoneXpCostMultiplier")
                .defineInRange("warpStoneXpCostMultiplier", 0, 0, Float.POSITIVE_INFINITY);

        warpStoneCooldown = builder
                .comment("The cooldown between usages of the warp stone in seconds. This is bound to the player, not the item, so multiple warp stones share the same cooldown.")
                .translation("config.waystones.warpStoneCooldown")
                .defineInRange("warpStoneCooldown", 300, 0, Integer.MAX_VALUE);

        warpStoneUseTime = builder
                .comment("The time in ticks that it takes to use a warp stone. This is the charge-up time when holding right-click.")
                .translation("config.waystones.warpStoneUseTime")
                .defineInRange("warpStoneUseTime", 32, 1, Integer.MAX_VALUE);

        builder.pop().comment("These options apply to teleporting using the scroll items.").push("scrolls");

        scrollUseTime = builder
                .comment("The time in ticks it takes to use a scroll. This is the charge-up time when holding right-click.")
                .translation("config.waystones.scrollUseTime")
                .defineInRange("scrollUseTime", 32, 1, Integer.MAX_VALUE);

        builder.pop().comment("These options apply to teleporting between dimensions.").push("dimensionalWarp");

        dimensionalWarp = builder
                .comment("Set to 'ALLOW' to allow dimensional warp in general. Set to 'GLOBAL_ONLY' to restrict dimensional warp to global waystones. Set to 'DENY' to disallow all dimensional warps.")
                .translation("config.waystones.dimensionalWarp")
                .defineEnum("dimensionalWarp", DimensionalWarp.ALLOW);

        dimensionalWarpXpCost = builder
                .comment("The base xp level cost when travelling between dimensions. Ignores block distance.")
                .translation("config.waystones.dimensionalWarpXpCost")
                .defineInRange("dimensionalWarpXpCost", 3, 0, Integer.MAX_VALUE);

        builder.pop().comment("These options apply to taking leashed mobs with you when teleporting.").push("leashedMobs");

        transportLeashed = builder
                .comment("If enabled, leashed mobs/animals will be teleported with you")
                .translation("config.waystones.transportLeashed")
                .define("transportLeashed", true);

        transportLeashedDimensional = builder
                .comment("Take animals with you when travelling between dimensions")
                .translation("config.waystones.transportLeashedDimensional")
                .define("transportLeashedDimensional", true);

        costPerLeashed = builder
                .comment("How much xp is need per leashed animal to travel with you")
                .translation("config.waystones.costPerLeashed")
                .defineInRange("costPerLeashed", 1, 0, Integer.MAX_VALUE);

        leashedBlacklist = builder
                .comment("Which leashed mobs cannot be taken with you when travelling.")
                .translation("config.waystones.leashedBlacklist")
                .defineList("leashedBlacklist", Collections.singletonList("minecraft:wither"), $ -> true);

        builder.pop().comment("These options define restrictions when managing waystones.").push("restrictions");

        restrictRenameToOwner = builder
                .comment("If enabled, only the owner of a waystone (the one who placed it) can rename it.")
                .translation("config.waystones.restrictRenameToOwner")
                .define("restrictRenameToOwner", false);

        restrictToCreative = builder
                .comment("If enabled, only creative players can place, edit or break waystones. This does NOT disable the crafting recipe.")
                .translation("config.waystones.restrictToCreative")
                .define("restrictToCreative", false);

        generatedWaystonesUnbreakable = builder
                .comment("If enabled, waystones generated in worldgen are unbreakable.")
                .translation("config.waystones.generatedWaystonesUnbreakable")
                .define("generatedWaystonesUnbreakable", false);
    }
}

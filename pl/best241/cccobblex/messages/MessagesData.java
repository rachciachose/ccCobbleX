// 
// Decompiled by Procyon v0.5.30
// 

package pl.best241.cccobblex.messages;

import org.bukkit.plugin.Plugin;

public class MessagesData
{
    public static String putOnGroundToHaveFun;
    public static String cobblexName;
    public static String youHaveOpenedCobbleX;
    public static String youNeedItemsToCraftIt;
    public static String youChangedCobblestone;
    public static String commandOnlyForPlayers;
    public static String youHaventGotEnoughtCobble;
    public static String youCraftedCobbleX;
    private static MessagesConfig config;
    
    public static void loadMessages(final Plugin plugin) {
        (MessagesData.config = new MessagesConfig(plugin, "messages.yml")).saveDefaultConfig();
        MessagesData.config.reloadCustomConfig();
        MessagesData.putOnGroundToHaveFun = MessagesData.config.getString("putOnGroundToHaveFun");
        MessagesData.cobblexName = MessagesData.config.getString("cobblexName");
        MessagesData.youHaveOpenedCobbleX = MessagesData.config.getString("youHaveOpenedCobbleX");
        MessagesData.youNeedItemsToCraftIt = MessagesData.config.getString("youNeedItemsToCraftIt");
        MessagesData.youChangedCobblestone = MessagesData.config.getString("youChangedCobblestone");
        MessagesData.commandOnlyForPlayers = MessagesData.config.getString("commandOnlyForPlayers");
        MessagesData.youHaventGotEnoughtCobble = MessagesData.config.getString("youHaventGotEnoughtCobble");
        MessagesData.youCraftedCobbleX = MessagesData.config.getString("youCraftedCobbleX");
    }
}

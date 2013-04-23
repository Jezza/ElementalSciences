package me.jezzadabomb.es.handlers;

import me.jezzadabomb.es.handlers.ServerHandler;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientHandler extends ServerHandler {
        
        @Override
        public void registerRenderers() {
                MinecraftForgeClient.preloadTexture(ITEMS_PNG);
                MinecraftForgeClient.preloadTexture(BLOCK_PNG);
        }
        
}
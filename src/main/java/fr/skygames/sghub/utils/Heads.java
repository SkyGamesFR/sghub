package fr.skygames.sghub.utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public enum Heads
{
    YOUTUBE("ZDJmNmMwN2EzMjZkZWY5ODRlNzJmNzcyZWQ2NDU0NDlmNWVjOTZjNmNhMjU2NDk5YjVkMmI4NGE4ZGNlIn19fQ==","youtube"),
    EARTH("YmRkZTU5NGRlYWQ4OGIzNWJjMjFhZDFhYjIzOGRjYWU0MTEyNTNlMzRhNTg1ZDkyNTI1OGNlNjc0YzY0MjYxNyJ9fX0=","earth"),
    DISCORD("Nzg3M2MxMmJmZmI1MjUxYTBiODhkNWFlNzVjNzI0N2NiMzlhNzVmZjFhODFjYmU0YzhhMzliMzExZGRlZGEifX19", "discord");

    private ItemBuilder item;
    private String idTag;
    private String prefix = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUv";
    private Heads(String texture, String id)
    {
        item = createSkull(prefix + texture, id);
        idTag = id;
    }

    public static ItemBuilder getHead(String name)
    {
        for (Heads head : Heads.values())
        {
            if (head.getName().equalsIgnoreCase(name))
            {
                return head.item;
            }
        }
        return null;
    }

    public static ItemBuilder createSkull(String url, String name)
    {
        ItemBuilder head = new ItemBuilder(Material.SKULL_ITEM, 1 , 3);
        if (url.isEmpty()) return head;

        SkullMeta headMeta = (SkullMeta) head.getMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);

        profile.getProperties().put("textures", new Property("textures", url));

        try
        {
            Field profileField = headMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(headMeta, profile);

        }
        catch (IllegalArgumentException|NoSuchFieldException|SecurityException | IllegalAccessException error)
        {
            error.printStackTrace();
        }
        head.setMeta(headMeta);
        return head;
    }

    public ItemStack getDiscordHead() {
        return Objects.requireNonNull(Heads.getHead("discord")).setName("§6§lDiscord").setLore("§7Cliquez acceder à discord.skygames.fr").toItemStack();
    }

    public ItemStack getEarthHead() {
        return Objects.requireNonNull(Heads.getHead("earth")).setName("§6§lSite Web").setLore("§7Cliquez acceder à skygames.fr").toItemStack();
    }


    public ItemStack getItemStack()
    {
        return item.toItemStack();
    }

    public String getName()
    {
        return idTag;
    }


}
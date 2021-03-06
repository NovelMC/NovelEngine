package net.novelmc.novelengine.config;

import net.novelmc.novelengine.NovelEngine;
import net.novelmc.novelengine.util.NLog;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.bukkit.configuration.InvalidConfigurationException;

public class Config extends YamlConfiguration
{

    private static Config config;
    private final NovelEngine plugin;
    private final File file;

    public Config(NovelEngine plugin)
    {
        this.plugin = plugin;
        this.file = new File(plugin.getDataFolder(), "config.yml");

        if ( ! file.exists())
        {
            saveDefault();
        }
    }

    public String getServerName()
    {
        return super.getString("general.name");
    }

    public List<String> getMOTD()
    {
        return super.getStringList("general.motd");
    }

    public String getWebsite()
    {
        return super.getString("general.website");
    }

    public boolean isEventModeEnabled()
    {
        return super.getBoolean("general.eventmode");
    }

    public void setEventModeEnabled(boolean enable)
    {
        super.set("general.eventmode", enable);
    }

    public boolean isDevModeEnabled()
    {
        return super.getBoolean("general.devmode");
    }

    public void setDevModeEnabled(boolean enable)
    {
        super.set("general.devmode", enable);
    }

    public boolean isDevelModeEnabled()
    {
        return super.getBoolean("general.develmode");
    }

    public void setDevelModeEnabled(boolean enable)
    {
        super.set("general.develmode", enable);
    }

    public boolean isStaffModeEnabled()
    {
        return super.getBoolean("general.staffmode");
    }

    public void setStaffModeEnabled(boolean enable)
    {
        super.set("general.staffmode", enable);
    }

    public List<String> getDefaultCommands()
    {
        return super.getStringList("permissionblocker.default");
    }

    public List<String> getStaffCommands()
    {
        return super.getStringList("permissionblocker.staff");
    }

    public boolean isSQLEnabled()
    {
        return super.getBoolean("sql.enabled");
    }

    public String getSQLUsername()
    {
        return super.getString("sql.username");
    }

    public String getSQLPassword()
    {
        return super.getString("sql.password");
    }

    public String getSQLHost()
    {
        return super.getString("sql.host");
    }

    public int getSQLPort()
    {
        return super.getInt("sql.port");
    }

    public String getSQLDatabase()
    {
        return super.getString("sql.database");
    }

    public Boolean isLavaEnabled()
    {
        return super.getBoolean("allow.lava_place");
    }

    public void setLavaEnabled(boolean lava)
    {
        super.set("allow.lava_place", lava);
    }

    public Boolean isWaterEnabled()
    {
        return super.getBoolean("allow.water_place");
    }

    public void setWaterEnabled(boolean water)
    {
        super.set("allow.water_place", water);
    }

    public void load()
    {
        try
        {
            super.load(file);
        } catch (IOException | InvalidConfigurationException ex)
        {
            NLog.severe(ex);
        }
    }

    public void save()
    {
        try
        {
            super.save(file);
        } catch (IOException ex)
        {
            NLog.severe(ex);
        }
    }

    private void saveDefault()
    {
        plugin.saveResource("config.yml", false);
    }
}

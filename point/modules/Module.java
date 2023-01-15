package point.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.network.Packet;
import point.hatsune;

public class Module {

    public String name, description;
    public int key;
    public boolean enabled;
    public Category category;

    public Minecraft mc = Minecraft.getMinecraft();

    public Module(String name, String description, Category category) {
        this.name = name;
        this.description = description;
        this.enabled = enabled;
        this.category = category;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        if(enabled) {
            onEnable();
        } else{
            onDisable();
        }
        this.enabled = enabled;
    }

    public void onEnable() {
        hatsune.INSTANCE.getBus().register(this);
        System.out.print("Module " + name + " enabled!");

    }

    public void onDisable() {
        hatsune.INSTANCE.getBus().unregister(this);
        System.out.print("Module " + name + " disabled!");

    }

    public void sendPacket(Packet p) {
        mc.getNetHandler().addToSendQueue(p);
    }

    public void silentSendPacket(Packet p) {
        mc.getNetHandler().addToSendQueueSilent(p);
    }
}



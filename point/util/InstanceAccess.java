package point.util;

import net.minecraft.client.Minecraft;
import point.hatsune;

public interface InstanceAccess {
    Minecraft mc = Minecraft.getMinecraft();
    hatsune instance = hatsune.INSTANCE;
}

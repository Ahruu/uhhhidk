package point.modules.impl.combat;

import com.google.common.eventbus.Subscribe;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.client.C02PacketUseEntity;
import point.events.impl.EventUpdate;
import point.modules.Category;
import point.modules.Module;
import point.util.TimeUtil;

public class Killaura  extends Module {

    EntityLivingBase target = null;
    TimeUtil timer = new TimeUtil();

    public Killaura() {
        super("Killaura", "Automatically hits players", Category.COMBAT);
    }

    @Subscribe
    public void onUpdate(EventUpdate e) {
        for (EntityPlayer player : mc.theWorld.playerEntities) {
            if(player.getHealth() != 0) {
                if(mc.thePlayer.getDistanceToEntity(player)< 3) target = player;
                }
            }

        if(target == null)
            return;

        if(mc.thePlayer.getDistanceToEntity(target) < 3) {
            target = null;
            return;
        }

        if(target.getHealth() == 0) {
            target = null;
            return;
        }

        int cps = 10;
        if(timer.hasReached(1000 / cps)) {
            attackEntity(target);
            timer.reset();
        }

}
    public void attackEntity(EntityLivingBase entity) {
        mc.thePlayer.swingItem();
        mc.thePlayer.sendQueue.addToSendQueue(new C02PacketUseEntity(entity, C02PacketUseEntity.Action.ATTACK));
        }


}



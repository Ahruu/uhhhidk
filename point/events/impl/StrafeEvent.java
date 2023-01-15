package point.events.impl;

import point.events.Event;
import point.util.InstanceAccess;
import point.util.MoveUtil;


public final class StrafeEvent extends Event implements InstanceAccess {
    private float forward, strafe, friction;

    public void setSpeedPartialStrafe(float friction, final float strafe) {
        final float remainder = 1 - strafe;

        if (forward != 0 && this.strafe != 0) {
            friction *= 0.91;
        }

        if (mc.thePlayer.onGround) {
            setSpeed(friction);
        } else {
            mc.thePlayer.motionX *= strafe;
            mc.thePlayer.motionZ *= strafe;
            setFriction(friction * remainder);
        }
    }

    public float getForward() {
        return forward;
    }

    public void setForward(float forward) {
        this.forward = forward;
    }

    public float getStrafe() {
        return strafe;
    }

    public void setStrafe(float strafe) {
        this.strafe = strafe;
    }

    public float getFriction() {
        return friction;
    }

    public void setFriction(float friction) {
        this.friction = friction;
    }

    public void setSpeed(final float speed, final double motionMultiplier) {
        setFriction(getForward() != 0 && getStrafe() != 0 ? speed * 0.99F : speed);
        mc.thePlayer.motionX *= motionMultiplier;
        mc.thePlayer.motionZ *= motionMultiplier;
    }

    public void setSpeed(final float speed) {
        setFriction(getForward() != 0 && getStrafe() != 0 ? speed * 0.99F : speed);
        MoveUtil.stop();
    }
}

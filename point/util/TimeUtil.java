package point.util;

public final class TimeUtil {

    public long lastMS = 0L;


    public int convertToMS(final int d) {
        return 1000 / d;
    }


    public long getCurrentMS() {
        return System.nanoTime() / 1000000L;
    }

    public long getElapsedTime() {
        return System.currentTimeMillis() - this.lastMS;
    }


    public boolean hasReached(final long milliseconds) {
        return getCurrentMS() - lastMS >= milliseconds;
    }

    public long getDelay() {
        return System.currentTimeMillis() - lastMS;
    }

    public void reset() {
        lastMS = getCurrentMS();
    }

    public void setLastMS() {
        lastMS = System.currentTimeMillis();
    }

    public void setLastMS(final long lastMS) {
        this.lastMS = lastMS;
    }
}




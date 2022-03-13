public class Tumbler {
    volatile private boolean status;

    public void tumblerOn() {
        status = true;
    }

    public void tumblerOff() {
        status = false;
    }

    public boolean isStatus() {
        return status;
    }
}

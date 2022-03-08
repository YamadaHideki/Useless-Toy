public class Tumbler {
    volatile private boolean status;

    public void TumblerOn () {
        status = true;
    }

    public void TumblerOff () {
        status = false;
    }

    public boolean isStatus() {
        return status;
    }
}

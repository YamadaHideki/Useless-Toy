public class Main {

    private static final int USER_DELAY = 2000;
    private static final int TOY_DELAY = 100;

    public static void main(String[] args) throws InterruptedException {

        Tumbler tumbler = new Tumbler();

        Thread user = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                tumbler.tumblerOn();
                System.out.println(i + ": Пользователь включил тумблер");
                try {
                    Thread.sleep(USER_DELAY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread toy = new Thread(() -> {
            while (true) {
                if(tumbler.isStatus()) {
                    tumbler.tumblerOff();
                    try {
                        Thread.sleep(TOY_DELAY);
                    } catch (InterruptedException ignored) { }
                    System.out.println("Игрушка выключила тумблер");
                }
            }
        });

        toy.setDaemon(true);
        toy.start();

        user.start();
        user.join();
    }
}

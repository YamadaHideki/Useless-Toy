public class Main {
    public static void main(String[] args) throws InterruptedException {

        Tumbler tumbler = new Tumbler();

        Thread user = new Thread(() -> {
            final int userDelay = 2000;
            for (int i = 1; i <= 5; i++) {
                tumbler.tumblerOn();
                System.out.println(i + ": Пользователь включил тумблер");
                try {
                    Thread.sleep(userDelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread toy = new Thread(() -> {
            final int toyDelay = 100;

            while (true) {
                if(tumbler.isStatus()) {
                    tumbler.tumblerOff();
                    try {
                        Thread.sleep(toyDelay);
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

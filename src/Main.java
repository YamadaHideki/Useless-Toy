public class Main {
    public static void main(String[] args) throws InterruptedException {

        int userDelay = 2000;
        int toyDelay = 100;

        Tumbler tumbler = new Tumbler();

        Thread user = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    Thread.sleep(userDelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tumbler.TumblerOn();
                System.out.println(i + ": Пользователь включил тумблер");
            }
        });

        Thread toy = new Thread(() -> {
            while (true) {
                if(tumbler.isStatus()) {
                    tumbler.TumblerOff();
                    try {
                        Thread.sleep(toyDelay);
                    } catch (InterruptedException ignored) { }
                    System.out.println("Игрушка выключила тумблер");
                }

                if (!user.isAlive()) {    // 1: option
                    break;
                }
            }
        });

        user.start();
        toy.start();
    }
}

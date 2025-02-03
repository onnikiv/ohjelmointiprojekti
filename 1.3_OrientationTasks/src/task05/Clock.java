package task05;

public class Clock {

    private static Clock instance;
    private int time;

    private Clock() {}

    public static Clock getInstance() {
        if (instance == null) {
            instance = new Clock();
        }
        return instance;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        if (0 < time) {
            this.time = time;
        } else {
            System.out.println("Toope! Ei voi olla alle 0");
        }

    }
    public static void main(String[] args) {
        System.out.println("Aika nyt Alussa: " + Clock.getInstance().getTime());

        Clock.getInstance().setTime(18);
        System.out.println("Aika Muutoksen jälkeen: "+ Clock.getInstance().getTime());

        Clock.getInstance().setTime(0);

        System.out.println("Aika lopuksi: "+ Clock.getInstance().getTime());
    }

}

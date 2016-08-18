package pulse;

import java.io.IOException;


public class ApplicationStart {
    public static void main(String[] args) throws IOException {
        
        int[] param = DataReciever.getInitParam();
        Pulse counter = new Pulse(param);
        long totalPulse = counter.getTotalPulse();

        System.out.println("Wasze tętno: " + totalPulse / 1000 + " tysięcy");
    }
}

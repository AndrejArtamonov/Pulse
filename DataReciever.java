package pulse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class DataReciever {
    public static int[] getInitParam() throws IOException {
        System.out.println("Wprowadźcie datę urodzenia");
        BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Wprowadźcie dzień: ");
        int day = Integer.parseInt(is.readLine());
        System.out.print("Wprowadźcie miesiąc: ");
        int month = Integer.parseInt(is.readLine());
        System.out.print("Wprowadźcie rok: ");
        int year = Integer.parseInt(is.readLine());
        System.out.print("Wprowadźcie godzinę: ");
        int hours = Integer.parseInt(is.readLine());
        System.out.print("Wprowadźcie minuty: ");
        int minutes = Integer.parseInt(is.readLine());
        System.out.print("Wskażcie waszą płec (0 Męski; 1 Żeński): ");
        int sex = Integer.parseInt(is.readLine());
        System.out.println("0-Wyczynowa kondycja");
        System.out.println("1-Świetna kondycja");
        System.out.println("2-Dobra kondycja");
        System.out.println("3-Ponadprzeciętna kondycja");
        System.out.println("4-Przeciętna kondycja");
        System.out.println("5-Słaba kondycja");
        System.out.println("6-Zła kondycja");
        System.out.print("Wybierzcie kondycję na skalę od 0 do 6: ");
        int condition = Integer.parseInt(is.readLine());
        return new int[]{day, month, year, hours, minutes, sex, condition};
    }
}

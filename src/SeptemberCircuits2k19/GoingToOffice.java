package SeptemberCircuits2k19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoingToOffice {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double d = Double.parseDouble(reader.readLine());
        String[] tok = reader.readLine().split(" ");
        long oc = Long.parseLong(tok[0]);
        long of = Long.parseLong(tok[1]);
        long od = Long.parseLong(tok[2]);
        tok = reader.readLine().split(" ");
        double cs = Double.parseDouble(tok[0]);
        double cb = Double.parseDouble(tok[1]);
        double cm = Double.parseDouble(tok[2]);
        double cd = Double.parseDouble(tok[3]);
        double online = oc + ((d <= of) ? 0 : ((d - of) * od));
        double classic = cb + ((d / cs) * cm) + (d * cd);
        if (online <= classic) System.out.println("Online Taxi");
        else System.out.println("Classic Taxi");
    }
}

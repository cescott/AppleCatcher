import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Error: No Argument");
        }
        else if (args[0].equalsIgnoreCase("PrimeDecomposition")) {
            primeDecomposition();
        }
        else if (args[0].equalsIgnoreCase("PrimeNumbers")) {
            primeNumbers();
        }
        else {
            System.out.println("Error: Argument Not Recognized");
        }
    }

    //-------------------------------------------------------------------------------------------//

    public static void primeDecomposition() {
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Type in a whole number to calculate its prime factors.");
            long input = 0;
            String scanned;
            while (true) {
                scanned = scan.nextLine();
                if (scanned.equalsIgnoreCase("stop")) {
                    System.exit(0);
                }
                try {
                    input = Long.parseLong(scanned);
                } catch (Exception e) {
                    System.out.println("Please enter a whole number of at most 19 digits");
                    continue;
                }
                break;
            }
            String product = "1 ";
            if (input < 0) {
                product = "-1 ";
                input = input * -1;
            } else if (input == 0) {
                product = "";
            }
            String[] primes = (prime(input)).split("\\s+");
            long[] longs = new long[primes.length];
            for (int i = 0; i < longs.length; i++) {
                longs[i] = Long.parseLong(primes[i]);
            }
            Arrays.sort(longs);
            for (int i = 0; i < longs.length; i++) {
                product += longs[i] + " ";
            }
            System.out.println("\n" + product + "\n");
        }
    }

    public static String prime(long num) {
        for (long i = 2; i < num; i++) {
            if (num % i == 0) {
                return prime(i) + " " + prime(num / i) + " ";
            }
        }
        return num + "";
    }

    public static void primeNumbers() {
        int i = 900000000;
        boolean cont = false;
        while (true) {
            i++;
            cont = false;
            for (int k = 2; k < (i / 2) + 3; k++) {
                if (i % k == 0) {
                    cont = true;
                    break;
                }
            }
            if (cont) {
                continue;
            }
            System.out.println(i + "");
        }
    }

    //-------------------------------------------------------------------------------------------//


}

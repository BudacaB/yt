package change;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        float change;

        do
        {
            System.out.println("Please input the change amount");
            change = in.nextFloat();
        }
        while(change <= 0);

        int cents = Math.round(change * 100);
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int pennies = 0;

        while(cents - 25 >= 0)
        {
            cents = cents - 25;
            quarters++;
        }

        while(cents - 10 >= 0)
        {
            cents = cents - 10;
            dimes++;
        }

        while(cents - 5 >= 0)
        {
            cents = cents - 5;
            nickels++;
        }

        while(cents - 1 >= 0)
        {
            cents = cents - 1;
            pennies++;
        }

        int coinsCount = quarters + dimes + nickels + pennies;

        System.out.println("The number of needed quarters is " + quarters);
        System.out.println("The number of needed dimes is " + dimes);
        System.out.println("The number of needed nickels is " + nickels);
        System.out.println("The number of needed pennies is " + pennies);
        System.out.println("The total number of needed coins is " + coinsCount);
    }
}

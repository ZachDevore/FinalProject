
import java.util.Scanner;
public class CreditCardValidator {

    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
        // get the user to input their credit card number
        System.out.print("Enter a credit card number: ");
        long creditCard = input.nextLong();
        input.close();

        // System.out.println(sumOfDoubleEvenPlace(creditCard));
        // System.out.println(getDigit(creditCard));
        // System.out.println(prefixMatched(creditCard));

        if (isValid(creditCard)) {
            System.out.println("the credit card is valid.");
        }  else {
            System.out.println("the credit card is not valid");
        }


    }


    public static int sumOfDoubleEvenPlace(long number) {
        String card = Long.toString(number);
        int num2 = 0;
        int sum = 0;

        for (int i = 0; i < getSize(number); i += 2) {

            char num = card.charAt(i);

            int num1 = Character.getNumericValue(num);
            if (num1 * 2 > 9) {

                int num3 = num1 * 2;

                 String sum2 = Long.toString(num3);

                 char number1 = sum2.charAt(0);
                 char number2 = sum2.charAt(1);

                 int number3 = Character.getNumericValue(number1);
                 int number4 = Character.getNumericValue(number2);

                 num2 = number3 + number4;

                 sum += num2;
            } else {
                num2 = num1 * 2;
                sum += num2;
            }

        }
        return sum;
    }

    public static int getDigit(long number) {
        String card = Long.toString(number);

        int sum = 0;

        for (int i = 1; i < getSize(number); i += 2) {
            char num = card.charAt(i);
            int num1 = Character.getNumericValue(num);
            sum += num1;
        }
        return sum;
    }

    public static int getSize(long number) {
       // not sure why I need a new method for this?
        String card = Long.toString(number);
        return card.length();
    }

    public static boolean prefixMatched(long number) {
        String card = Long.toString(number);
        char pre = card.charAt(0);
        char pre1 = card.charAt(1);
        int num1 = Character.getNumericValue(pre);
        int num2 = Character.getNumericValue(pre1);

        if ( (num1 == 4 || num1 == 5 || num1 == 6) || (num1 == 3 && num2 == 7) )  {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValid(long number) {
        int cardSum = sumOfDoubleEvenPlace(number) + getDigit(number);

        if ( (cardSum % 10 == 0) && prefixMatched(number)  ) {
            return true;
        } else {
            return false;
        }

    }




}

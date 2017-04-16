package Challange_306_Easy_Pandigital_Roman_Numbers;

/**
 * Created by Wiktoria on 15.03.2017.
 * Challenge description in README file.
 */
public class Pandigital
{
    public static void checkPandigital(int number)
    {
        Convert numerals = new Convert(number);
        String romanNums = "MDCLXVI";
        char[] romanNumerals = romanNums.toCharArray();

        char[] checkPandigital = numerals.roman.toCharArray();
        boolean repetition = true;
        int count = 0;

        for(int i = 0; i < romanNumerals.length && repetition == true && checkPandigital.length >= 7; i++)
        {
            for(int j = 0; j < checkPandigital.length; j++)
            {
                if(romanNumerals[i] == checkPandigital[j])
                {
                    count++;
                }
            }
            if(count == 0 || count > 1)
            {
                repetition = false;
            }
            if(i == romanNumerals.length - 1 && repetition == true)
            {
                System.out.println("Pandigital number: " + numerals.keepNumber
                + "\nfrom Roman numeral: " + numerals.roman + "\n");
            }
            count = 0;
        }
    }

    public static void main(String[] args)
    {
        for(int i = 1000; i < 2001; i++)
        {
            checkPandigital(i);
        }
    }
}

/* output:

Pandigital number: 1444
from Roman numeral: MCDXLIV

Pandigital number: 1446
from Roman numeral: MCDXLVI

Pandigital number: 1464
from Roman numeral: MCDLXIV

Pandigital number: 1466
from Roman numeral: MCDLXVI

Pandigital number: 1644
from Roman numeral: MDCXLIV

Pandigital number: 1646
from Roman numeral: MDCXLVI

Pandigital number: 1664
from Roman numeral: MDCLXIV

Pandigital number: 1666
from Roman numeral: MDCLXVI

*/

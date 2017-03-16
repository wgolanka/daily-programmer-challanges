package Challange_306_Easy_Pandigital_Roman_Numbers;

/**
 * Created by Wiktoria on 15.03.2017.
 */

public class Convert
{
    final String[] oneNine = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    final String[] tenNinety = {"X", "XX", "XXX", "XL", "L", "LX", "LXX","LXXX", "XC"};
    final String[] hundreds = {"C", "CC", "CCC", "CD", "D", "DC","DCC", "DCCC", "CM"};
    int keepNumber;
    int number;
    String roman;

    public Convert(int number)
    {
        this.number = number;
        keepNumber = this.number;
        roman = this.arabicToRoman();
    }
    public String arabicToRoman()
    {
        String romanNumber = "";

        if(this.countDigits() == 1)
        {
            if(this.number < 0)
            {
                return "Number can't be 0";
            }
            else
                return oneNine[this.number - 1];
        }
        else if(this.countDigits() == 2)
        {
            romanNumber += tenNinety[this.firstDigit() - 1];

            if(this.digit(2) > 0)
                romanNumber += oneNine[this.digit(2) - 1];

        }
        else if(this.countDigits() == 3)
        {
            if(this.digit(2) == 0 && this.digit(3) == 0)
            {
               return romanNumber += hundreds[this.firstDigit() - 1];
            }

            romanNumber += hundreds[this.firstDigit() - 1];

            if(this.digit(2) == 0 )
            {
                this.number = this.getUnits();
                romanNumber += oneNine[this.number - 1];
                return romanNumber;
            }
            else if(!(this.digit(2) == 0 && this.digit(3) == 0))
            {
                this.number = this.getTensUnits();
                return romanNumber += this.countTwoDigitNumber();
            }
            return romanNumber;
        }
        else if(this.countDigits() == 4)
        {
            romanNumber += "M";

            if(this.digit(2) == 0 && this.digit(3) == 0 && this.digit(4) == 0)
            {
                return romanNumber;
            }
            else if(this.digit(2) == 0 && this.digit(3) == 0)
            {
                this.number = this.getHundredsTensUnits();
                return romanNumber += oneNine[this.digit(1) - 1];
            }
            else if(this.digit(2) == 0)
            {
                this.number = this.getHundredsTensUnits();
                return romanNumber += this.countTwoDigitNumber();
            }
            else
            {
                this.number = this.getHundredsTensUnits();
                return romanNumber += this.countThreeDigitNumber();
            }
        }
        return romanNumber;
    }
    public String countThreeDigitNumber()
    {
        String romanNumber = "";

        if(this.digit(2) == 0 && this.digit(3) == 0)
        {
            return romanNumber += hundreds[this.firstDigit() - 1];
        }

        romanNumber += hundreds[this.firstDigit() - 1];

        if(this.digit(2) == 0 )
        {
            this.number = getUnits();
            romanNumber += oneNine[this.number - 1];
        }
        else if(!(this.digit(2) == 0 && this.digit(3) == 0))
        {
            this.number = this.getTensUnits();
            romanNumber += this.countTwoDigitNumber();
        }
        return romanNumber;
    }

    public String countTwoDigitNumber()
    {
        String romanNumber = "";
        romanNumber += tenNinety[this.firstDigit() - 1];

        if(!(this.countDigits() == 2))
        {
            return romanNumber += oneNine[this.number - 1];
        }

        if(this.digit(2) > 0)
            romanNumber += oneNine[this.digit(2) - 1];

        return romanNumber;
    }

    public int getTensUnits()
    {
        if(this.countDigits() == 3)
        {
            String value = String.valueOf(this.number);
            char[] digits = value.toCharArray();
            value = String.copyValueOf(digits, 1, 2);
            this.number = Integer.valueOf(value);
        }
        return this.number;
    }

    public int getUnits()
    {
        if(this.countDigits() == 3)
        {
            String value = String.valueOf(this.number);
            char[] digits = value.toCharArray();
            value = String.copyValueOf(digits, 2, 1);
            this.number = Integer.valueOf(value);
        }
        return this.number;
    }

    public int getHundredsTensUnits()
    {
        if(this.countDigits() == 4)
        {
            String value = String.valueOf(this.number);
            char[] digits = value.toCharArray();
            value = String.copyValueOf(digits, 1, 3);
            this.number = Integer.valueOf(value);
        }
        return this.number;
    }

    public int countDigits()
    {
        char[] digits = Integer.toString(this.number).toCharArray();
        return digits.length;
    }

    public int digit(int digit)
    {
        char[] digits = Integer.toString(this.number).toCharArray();
        int dig = 0;
        if(digit < 0 || digit > digits.length)
        {
            System.out.println("Digit out of bounds");
        }
        else
            dig = Character.getNumericValue(digits[digit - 1]);
        return dig;
    }

    public int firstDigit()
    {
        char[] digits = Integer.toString(this.number).toCharArray();
        int fDigit = Character.getNumericValue(digits[0]);
        return fDigit;
    }

    public String toString()
    {
        return "Arabic number: " + keepNumber
                + "  Roman numeral: " + roman;
    }
}

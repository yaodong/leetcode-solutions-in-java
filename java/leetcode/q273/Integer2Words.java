package leetcode.q273;

public class Integer2Words {

    private static String[] numbersLessThan20 = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    private static String[] tens = {
            "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private static String[] thousands = {
            "", "Thousand", "Million", "Billion"
    };

    public String toWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        StringBuilder words = new StringBuilder();

        int t = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                words.insert(0, parseSegment(num % 1000) + thousands[t] + " ");
            }
            num /= 1000;
            t++;
        }

        return words.toString().trim();
    }

    private String parseSegment(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return numbersLessThan20[num] + " ";
        } else if (num < 100) {
            return tens[num / 10] + " " + parseSegment(num % 10);
        } else {
            return numbersLessThan20[num / 100] + " Hundred " + parseSegment(num % 100);
        }
    }


}

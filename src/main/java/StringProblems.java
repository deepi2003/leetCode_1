import java.util.HashMap;
import java.util.Map;

public class StringProblems {

    public int findNeedleInHaystack(String hayStack, String needle) {
        int hayStackLeftIndex = 0;
        int hayStackRightIndex = 0;
        int needleIndex = 0;
        int result = -1;
        int hayStackLength = hayStack.length();
        int needleLength = needle.length();
        if(needleLength > hayStackLength) {
            return -1;
        }

        while(hayStackRightIndex < hayStackLength && needleIndex < needleLength ) {
            if(hayStack.charAt(hayStackRightIndex) == needle.charAt(needleIndex)) {
                needleIndex++;
                if(result == -1) {
                    hayStackLeftIndex = hayStackRightIndex;
                    result = hayStackRightIndex;
                }
            } else if(result != -1){
                needleIndex = 0;
                result = -1;
                hayStackRightIndex = hayStackLeftIndex;
            }
                hayStackRightIndex++;

        }
        if(needleIndex != needle.length()) {
            return  -1;
        }
        return result;
    }


    public int romanToInt(String input) {
        Map<Character, Integer> romanToIntMapping= Map.of(
                'I',1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000);

        Map<String, Integer> TwoDigitMapping = Map.of(
          "IV", 4 ,
          "IX", 9,
          "XL", 40,
            "XC", 90,
            "CD", 400,
            "CM" , 900
        );

        Map<Character, Character> prevCharMapping = Map.of(
                'I', 'V' ,
                'I', 'X',
                'X', 'L',
                'X', 'C',
                'C', 'D',
                'C' , 'M'
        );
        int length = input.length();
        int currentIndex = 0;
        int result = 0;
        Character previousChar = 'K';
        while(currentIndex < length) {
            Character ch = input.charAt(currentIndex);
            String temp = ""+previousChar + ch;
            if(TwoDigitMapping.containsKey(temp)) {
                result = result - romanToIntMapping.get(previousChar) + TwoDigitMapping.get(temp);

            } else {
                result = result + romanToIntMapping.get(ch);
            }
            currentIndex ++;
            previousChar = ch;
        }

        return result;
    }


    public int romanToInt2(String input) {

        Map<Character, Integer> romanToIntMapping= Map.of(
                'I',1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000);

        if(input.length() == 1) {
                return romanToIntMapping.get(input.charAt(0));
        }
        Map<Character, Character> prevCharMapping = Map.of(
                'V', 'I' ,
                'X', 'I',
                'L', 'X',
                'C', 'X',
                'D', 'C',
                'M' , 'C'
        );
        int length = input.length();
        int currentIndex = 1;
        int result = romanToIntMapping.get(input.charAt(0));
        while(currentIndex < length) {
            Character ch = input.charAt(currentIndex);
            Character previousChar = prevCharMapping.get(ch);
            if(previousChar != null &&  prevCharMapping.get(ch) == input.charAt(currentIndex-1)) {
                result = result + romanToIntMapping.get(ch) - (2*romanToIntMapping.get(input.charAt(currentIndex-1))) ;
            }
            else {
                result = result + romanToIntMapping.get(ch);
            }
            currentIndex ++;
        }

        return result;
    }

    public int lengthOfLastWord(String s) {
        s = s.strip();
        int spaceIndex = s.lastIndexOf(" ");
       return s.length()-spaceIndex -1;
    }


    public int lengthOfLastWord2(String s) {
        String[] spillted = s.trim().split(" ");
        int len = spillted.length;
        return spillted[len-1].length();

    }
}

package CountLetters;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//given a string, count the letters
public class CountLetters {

    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(input);

        solution(input);
    }

    public static void solution(String input){
        char[] letters = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int[] count = new int[26];

        for(int i = 0; i < input.length(); i++){
            char letter = input.charAt(i);
            for (int j = 0; j < letters.length; j++) {
                if (letter == letters[j] ){
                    count[j] = count[j] +1;
                    break;
                }
            }
        }

        print(letters, count);
    }

    public static void print(char[] letters, int[] count){
        for (int i = 0; i < letters.length; i++) {
            if (count[i] != 0){
                System.out.print(letters[i] + String.valueOf(count[i]));
            }
        }
    }


}

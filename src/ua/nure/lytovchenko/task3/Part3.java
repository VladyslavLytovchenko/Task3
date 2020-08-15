package ua.nure.lytovchenko.task3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
    static String convert(String input){
        StringBuffer sb = new StringBuffer();
        Pattern pattern =  Pattern.compile("([\\S&&[^,.\\-?!']]{3,})");
        Matcher matcher=  pattern.matcher(input);
        while(matcher.find()){
            String word = matcher.group(1);
            if(Character.isLowerCase(word.charAt(0))) {
                matcher.appendReplacement(sb, Character.toUpperCase(word.charAt(0)) + word.substring(1));
            }else{
                matcher.appendReplacement(sb, Character.toLowerCase(word.charAt(0)) + word.substring(1));
            }
        }
        matcher.appendTail(sb);
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(convert(Util.readFile("part3.txt")));
    }
}
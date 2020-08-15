package ua.nure.lytovchenko.task3;

import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {


    public static final int LIMIT = 8999;
    public static final int LOWLIMIT = 1000;

    public static String convert1(String input) {
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("(.+)?;(.+)?;(.+)");
        Matcher matcher = pattern.matcher(input);
        matcher.find();
        while (matcher.find()) {
            sb.append(matcher.group(1)).append(": ").append(matcher.group(3)).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static String convert2(String input) {

        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("(?m)^(\\S+?);(\\S+?)\\s(\\S+?);(\\S+?)$",Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            sb.append(matcher.group(3)).append(" ").append(matcher.group(2));
            sb.append(" (email: ").append(matcher.group(4)).append(")\n");
        }
        return sb.toString().trim();
    }

    public static String convert3(String input) {
        StringBuilder sb = new StringBuilder();
        Pattern mailPattern = Pattern.compile("@(.+)");
        Matcher mailMatcher = mailPattern.matcher(input);
        while (mailMatcher.find()) {
            if (!contains(mailMatcher.group(1),sb.toString())) {
                sb.append(mailMatcher.group(1)).append(" ==> ");
                Pattern namePattern = Pattern.compile(String.format("(.+)?;(.+)?;.+@%s", mailMatcher.group(1)));
                Matcher nameMatcher = namePattern.matcher(input);
                while (nameMatcher.find()) {
                    sb.append(nameMatcher.group(1)).append(", ");
                }
                sb.setLength(sb.length() - 2);
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }

    public static String convert4(String input) {

        SecureRandom sr = new SecureRandom();
        Pattern pattern = Pattern.compile("(?m)^(.*;.*;.*)$");
        Matcher matcher = pattern.matcher(input);
        StringBuffer sb = new StringBuffer();
        matcher.find();
        matcher.appendReplacement(sb,matcher.group(1)+";Password");
        while(matcher.find()){
            matcher.appendReplacement(sb,matcher.group(1)+";"+(sr.nextInt(LIMIT)+ LOWLIMIT));
        }
        matcher.appendTail(sb);
        return sb.toString()+"\n";
    }

    public static boolean contains(String word, String text){
        Pattern repAgainstPattern = Pattern.compile(word);
        Matcher repAgainstMatcher = repAgainstPattern.matcher(text);
        return repAgainstMatcher.find();
    }

    public static void main(String[] args) {
        System.out.println(convert4(Util.readFile("part1.txt")));
    }
}

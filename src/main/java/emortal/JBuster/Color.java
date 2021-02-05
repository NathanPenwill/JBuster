package emortal.JBuster;

public class Color {
    public static String color(String s) {
        String newString = s + "&r";
        for (EscapeColors v : EscapeColors.values())
            newString = newString.replaceAll("&" + v.getReplaceChar(), v.getEscCode());
        return newString;
    }

    public static String strip(String s) {
        String newString = s;
        for (EscapeColors v : EscapeColors.values())
            newString = newString.replaceAll("&" + v.getReplaceChar(), "");
        return newString;
    }
}

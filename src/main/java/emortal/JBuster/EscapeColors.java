package emortal.JBuster;

public enum EscapeColors {
    RESET("r", "[0m"),

    RED("4", "[0;31m"),
    GREEN("2", "[0;32m"),
    YELLOW("6", "[0;33m"),
    BLUE("1", "[0;34m"),
    PURPLE("5", "[0;35m"),
    CYAN("3", "[0;36m"),

    BOLD_RED("c", "[1;31m"),
    BOLD_GREEN("a", "[1;32m"),
    BOLD_YELLOW("e", "[1;33m"),
    BOLD_BLUE("9", "[1;34m"),
    BOLD_PURPLE("d", "[1;35m"),
    BOLD_CYAN("b", "[1;36m");

    private String replaceChar;
    private String escCode;
    EscapeColors(String replaceChar, String escCode) {
        this.replaceChar = replaceChar;
        this.escCode = escCode;
    }

    public String getReplaceChar() {
        return replaceChar;
    }
    public String getEscCode() {
        // Use different escape code if it is running on Windows
        return System.getProperty("os.name").contains("Windows") ? "¤" + escCode : "\033" + escCode;
    }
}

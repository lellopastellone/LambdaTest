package it.unibs.pajc;

public class Colorizer {
    public static final Colorizer RESET = new Colorizer("\u001B[0m");
	/** Inverts <i>background</i> with foreground. */
	public static final Colorizer INVERT = new Colorizer("\u001B[7m");
	/** Colors the words <i>black</i>. */
	public static final Colorizer BLACK= new Colorizer("\u001B[30m");
	/** Colors the words <i>red</i>. */
    public static final Colorizer RED = new Colorizer("\u001B[31m");

    private String ansiCode;
    
    public Colorizer(String ansicode) {
        this.ansiCode = ansicode;
    }

    public String colorize(String s) {
        return ansiCode + s + RESET;
    }

    public String highlight(String s, String pattern) {

        // StringBuilder result = new StringBuilder();
        // Pattern regexPattern = Pattern.compile(pattern, 1);
        // Matcher matcher = regexPattern.matcher(s);

        // int lastIndex = 0;
        // while (matcher.find()) {
        //     result.append(s.substring(lastIndex, matcher.start()));
        //     result.append(this.colorize(matcher.group()));
        //     lastIndex = matcher.end();
        // }

        // result.append(s.substring(lastIndex));
        // return result.toString();
        return s.replaceAll(pattern, colorize(pattern));
    }

    public String toString() {
        return ansiCode;
    }
}
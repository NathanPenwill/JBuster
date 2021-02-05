package emortal.JBuster;

import java.io.FileWriter;
import java.io.IOException;

public class FinishListener {
    StringBuilder results = new StringBuilder();

    private long lineCount;
    private long currentIndex = 1L;
    private String successFile;
    FinishListener(long lineCount, String successFile) {
        this.lineCount = lineCount;
        this.successFile = successFile;
    }

    public void finish(int statusCode, String url, String directory) {
        double percent = (double)Math.round(((double)(currentIndex)/(double)(lineCount)) * 100 * 100) / 100;
        System.out.print("\rTesting directories... " + percent + "%");

        switch (statusCode) {
            case 200:
                results.append("&a[" + statusCode + "] &rDirectory exists - &5Directory: " + directory);
                break;
            case 404:
                results.append("&c[" + statusCode + "] &rDirectory does not exist - &5Directory: " + directory);
                break;
            default:
                results.append("&c[" + statusCode + "] &rDirectory unknown (Other) - &5Directory: " + directory);
                break;
        }
        results.append("\n");

        currentIndex++;
        if (currentIndex == lineCount) allDone();
    }

    public void allDone() {
        System.out.println(Color.color("\nPrinting results...\n\n" + results.toString()));

        System.out.println("Saving results to '" + successFile + "'...");

        try {
            FileWriter fw = new FileWriter(successFile);

            fw.write(Color.strip(results.toString()));

            fw.close();
        } catch (IOException e) {
            System.out.println("The file '" + successFile + "' does not exist!");
            System.exit(1);
        }
    }
}

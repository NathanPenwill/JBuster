package emortal.JBuster;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println(Color.color("&cYou did not specify enough arguments. &rCheck the GitHub for more information &r- &5https://github.com/NathanPenwill/JBuster&r\nFormat: &1java -jar JBuster.jar url directoriesfile successoutputfile\n   &re.g. &3java -jar JBuster.jar https://example.com/ dirs.txt successful.txt"));
            System.exit(1);
        }

        String directoriesFile = "dirs.txt";
        String successFile = "successful.txt";
        if (args.length > 1) directoriesFile = args[1];
        if (args.length > 2) successFile = args[2];

        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(directoriesFile));
        } catch (IOException ignored) {
            System.out.println("The file '" + directoriesFile + "' does not exist!");
            System.exit(1);
        }

        // Tell the FinishListener how many directories there are (so it knows when to log results)
        // and tell it where to store the success file
        FinishListener listener = new FinishListener(lines.size(), successFile);

        System.out.println(Color.color("&dFound " + lines.size() + " directories"));
        System.out.print("Testing directories... 0%");

        // Loop through each line in "dirs.txt" and send a request to each directory
        for (String line : lines) {
            // Send the request in a separate thread
            new Thread(new RequestRunnable(args[0], line, listener)).start();
        }
    }
}

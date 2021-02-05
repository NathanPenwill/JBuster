package emortal.JBuster;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequestRunnable implements Runnable {
    private String requestUrl;
    private String directory;
    private FinishListener finishListener;

    public RequestRunnable(String requestUrl, String directory, FinishListener finishListener) {
        this.requestUrl = requestUrl;
        this.directory = directory;
        this.finishListener = finishListener;
    }

    @Override
    public void run() {
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            finishListener.finish(con.getResponseCode(), requestUrl, directory);
            con.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package za.co.bbd.jokeGenerator.Model;

/* Imports for data structures */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.http.HttpException;
/* Imports for HTTP request */
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Joke {
    private final String url = "https://backend-omega-seven.vercel.app/api/getjoke"; // site to get jokes
    public List<PunchLine> punchlines = new ArrayList<>();
    public List<BaseJoke> baseJokes = new ArrayList<>();
    private String baseJoke;

    public Joke() {
       Random rnd = new Random();
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            for (int i = 0; i < 50; i++) {

                String responseBody = httpClient.execute(httpGet, response -> EntityUtils.toString(response.getEntity()));
                String[] dataArr = responseBody.split("\"");
                if(dataArr.length != 9){
                    i--;
                    continue;
                }
                baseJokes.add(new BaseJoke(dataArr[3]));
                punchlines.add(new PunchLine(rnd.nextInt(1, 6), dataArr[7]));
            }
        } catch (Exception ex) {
            System.out.println("Couldn't get the joke XD");
            ex.printStackTrace();
        }
    }
}

package za.co.bbd.jokeGenerator.Model;

/* Imports for data structures */
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpException;
/* Imports for HTTP request */
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Joke {
    private final String url = "https://backend-omega-seven.vercel.app/api/getjoke"; // site to get jokes
    private List<PunchLine> punchlines = new ArrayList<>();
    private List<BaseJoke> baseJokes = new ArrayList<>();
    private String baseJoke;

    public Joke() {

        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            for (int i = 0; i < 5; i++) {

                String responseBody = httpClient.execute(httpGet,
                        response -> EntityUtils.toString(response.getEntity())); // maybe just split here ??

                //maybe replace this with an object mapper ?? 
                String[] dataArr = responseBody.split("\"");
                if(dataArr.length != 9){  //if our response isn't formatted appropritely, make another request 
                    i--;
                    continue;
                }

                    baseJokes.add(new BaseJoke(dataArr[5]));
                    punchlines.add(new PunchLine(5, dataArr[7]));
            }
        } catch (Exception ex) {
            System.out.println("Couldn't get the joke XD");
            ex.printStackTrace();
        }
    }
}

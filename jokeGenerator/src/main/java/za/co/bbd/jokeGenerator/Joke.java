package za.co.bbd.jokeGenerator;

/* Imports for data structures */
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpException;
/* Imports for HTTP request */
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Joke {
    private final String url = "https://backend-omega-seven.vercel.app/api/getjoke"; // site to get jokes
    private List<Punchline> punchlines = new ArrayList<>();
    private String baseJoke;
   private String removeSquareBrackets(String str){
       str.replace('[',' ');
       str.replace(']',' ');
       str.trim();
       return str;
   };
    public Joke() {

        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            for (int i = 0; i < 5; i++) {

                String responseBody = httpClient.execute(httpGet,
                        response -> EntityUtils.toString(response.getEntity())); // maybe just split here ??
                responseBody = responseBody.substring(1,responseBody.length()-1);
                ObjectMapper objectMapper = new ObjectMapper();
                Response resp = objectMapper.readValue(responseBody, Response.class);
                if (i == 0) {
                    baseJoke = resp.getQuestion();
                    punchlines.add(new Punchline(5, resp.getQuestion()));

                } else {
                    punchlines.add(new Punchline( (int) (Math.random() * 4), resp.getPunchline())); // change 4 to random number between 0 and 5 !
                }

            }

        } catch (Exception ex) {
            System.out.println("Couldn't get the joke XD");
            ex.printStackTrace();
            // do database things here
        }

        // testing constructor out
        System.out.println(
                "----------------------------------------------------------------------------------------------------\n"
                        + "base joke " + baseJoke);
        int count = 1;
        for (Punchline p : punchlines) {
            System.out.println("Punchline " + count + " : " + p.getPunchLine());
            count++;
        }
    }

    public String getBaseJoke(){
        return this.baseJoke;
    }

    public List<Punchline> getPunchlines(){
        return this.punchlines;
    }

}
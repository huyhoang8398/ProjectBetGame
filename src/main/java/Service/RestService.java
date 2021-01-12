package Service;

import Model.Matche;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

// APIkey: XtIEuBoXbtAr3FAlbaVX2UqJS
// APIsecretKey: rmgxGffpka1I5l0uhoYmwSjDnmpxuvMsMEdCDW1IGpRRDAQ2lz
// Bearer token: AAAAAAAAAAAAAAAAAAAAAH6VKwEAAAAA5ARe5HkYVZ6oMyGzlBWsPHbPxek%3DDFlfjoAyUspasR733kxF1i0tMXIwVopbErYyb5P1TSDqd3q6P0
// Access token: 1341519224309772294-uv719zY4of9Qw9RABT0vMzTSXyvULy
// Access tokken secret: wIwlLQMaUBIgokAdnalHSnztgLm5gKSwhx67mjOIJd0wF
@Stateless
@Path("/service")
public class RestService {
    static Twitter twitter;
    String competition = "PL"; // Premier League

    static {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("XtIEuBoXbtAr3FAlbaVX2UqJS")
                .setOAuthConsumerSecret("rmgxGffpka1I5l0uhoYmwSjDnmpxuvMsMEdCDW1IGpRRDAQ2lz")
                .setOAuthAccessToken("1341519224309772294-YmAtojWAgYrIxiYdMMGbuFArgQlHw0")
                .setOAuthAccessTokenSecret("DLWejXyKRBE0ba1px9z5RXNy25fH1qhKC4w25qZGwc71m");
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();

    }


    @GET
    @Path("/parieur/result")
    public int notifyResult(@QueryParam("userId") long userId, @QueryParam("result") int result) {
        try {
            String directMessage = "Hi, you have won.";
            if(result == 0){
                directMessage = "Sorry, you lose.";
            }
            String twitterName = "Anhabcxyz";
            twitter.sendDirectMessage(twitterName, directMessage);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return 1;
    }

    @GET
    @Path("/parieur/newmatch")
    public int notifyNewMatch(@QueryParam("userId") long userId,@QueryParam("idmatch") long idmatch) {
        try {
            String directMessage = "There is new match " + idmatch;
            String twitterName = "Anhabcxyz";
            twitter.sendDirectMessage(twitterName, directMessage);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return 1;
    }

    @GET
    @Path("/checkuser")
    public boolean isExistUserTwitter(@QueryParam("username") String username){
        try {
            ResponseList<User> userFound = twitter.users().lookupUsers(username);
            if(userFound != null){
                return true;
            }
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return false;
    }
}

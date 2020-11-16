package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                 
        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        List<Player> playerList = new ArrayList<>(Arrays.asList(players));
        playerList.sort(new Comparator<Player>() {
            public int compare(Player p1, Player p2) {
                if (p1.getScore() < p2.getScore()) {
                    return 1;
                } else if (p1.getScore() == p2.getScore()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        System.out.println("Players from Finland:\n");

        for (Player player : playerList) {
            if (player.getNationality().equals("FIN")) {
                System.out.println(player);
            }
        }   
    }  
}

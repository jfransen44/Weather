import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.util.Scanner;


/**
 * Created by jeremyfransen on 3/10/17.
 */
public class Main {
    static String city = "";
    static String state = "";
    static String zipCode = "";
    public static void main (String[] args) throws MalformedURLException {

        JFrame frame = new JFrame("Weather");
        frame.setContentPane(new WeatherGui().weatherView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(500, 400);
        frame.setPreferredSize(new Dimension(500, 200));
        frame.pack();
        frame.setVisible(true);
    }



}

/**
 * Created by jeremyfransen on 3/15/17.
 */
public class InputHandler {

    //Receives string from search bar and returns either city and state, or zip code
    public static String parseUserInput(String s){
        int zipCodeInt = 0;
        String cityState = "";

        s = s.trim();
        if (s.contains(" ")){
            System.out.println("String length = " + s.length() + " last space = " + s.lastIndexOf(' '));
            if (s.lastIndexOf(' ' ) > s.length() - 3){
                System.out.println("Bad city and state format");
            }
            else {
                //remove whitespace
                for (int i = 0; i < s.length(); i++){
                    if (s.charAt(i) != ' '){
                        cityState += s.charAt(i);
                    }
                    else{
                        cityState += "_";
                    }
                }
            }
            System.out.println(cityState);
        }

        else if (s.length() == 5 ) {
            try {
                zipCodeInt = Integer.parseInt(s);
                System.out.println(Integer.toString(zipCodeInt));
            } catch (NumberFormatException e) {
                //e.printStackTrace();
                System.out.println("Invalid zip code format");
            }
        }
        if (cityState == ""){
            return Integer.toString(zipCodeInt);
        }
        else
            return cityState;
    }
}

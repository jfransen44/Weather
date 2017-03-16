import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by jeremyfransen on 3/13/17.
 */
public class WeatherGui {
    public JPanel weatherView;
    private JTextField getSearchInfoTextField;
    private JButton OKButton;
    private JLabel outputLabel;
    private String searchInfo = "";
    GetWeatherData gwd = new GetWeatherData();

    public WeatherGui (){
        OKButton.addActionListener(new okButtonListener());
        getSearchInfoTextField.addKeyListener(new TextFieldListener());
    }

    private class okButtonListener implements ActionListener{
        //@Override
        String[] res = new String[3];
        int zipCode = 0;
        public void actionPerformed(ActionEvent e) {
            String value = getSearchInfoTextField.getText();
            value = InputHandler.parseUserInput(value);
            if (value.length() > 5){
                res = gwd.getDataFromCity(value);
            }
            else{
                zipCode = Integer.parseInt(value);
                if (zipCode != 0){
                    res = gwd.getDataFromZip(value);
                }
                else{
                    res = gwd.getDataFromCity(value);
                }
            }
            if (res[0].contains("No data")) {
                outputLabel.setText("No data");
            }
            else
                outputLabel.setText("The current temp is " + res[0] + ", feels like " + res[1] + " and is " + res[2]);
        }
    }

    private class TextFieldListener implements KeyListener{
        String[] res = new String[3];
        int zipCode = 0;

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                String value = getSearchInfoTextField.getText();
                value = InputHandler.parseUserInput(value);
                if (value.length() > 5) {
                    res = gwd.getDataFromCity(value);
                } else {
                    zipCode = Integer.parseInt(value);
                    if (zipCode != 0) {
                        res = gwd.getDataFromZip(value);
                    } else {
                        res = gwd.getDataFromCity(value);
                    }
                }
                if (res[0].contains("No data")) {
                    outputLabel.setText("No data");
                } else
                    outputLabel.setText("The current temp is " + res[0] + ", feels like " + res[1] + " and is " + res[2]);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}

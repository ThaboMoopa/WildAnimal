package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import sample.Domain.Play;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by thabomoopa on 12/05/2018.
 */
public class PlayController implements ActionListener, Initializable {

    private static final Object URL = "";
    private static final Object ResourceBundle = "";
    private Play play;
    private String[][] animals;
    SecureRandom random = new SecureRandom();

    @FXML
    private ImageView imageView;

    @FXML
    private Text myLabel;

    @FXML
    private TextField txtAnswer;

    @FXML
    private Button btnAnswer;
    private String val = "";



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //animals = new String[][]{{"lion","lion.png"}, {"Elephant","elephant.png"},{"Rhinoceros","rhinoceros.png"},{"Leopard","leopard.png"},{"Buffalo","buffalo.png"}};

        //File file = new File("src/sample/images/buffalo.png");
        //Image image = new Image(file.toURI().toString());
        //imageView.setImage(image);
        //imageView.setImage(animals[0][0]);
        //System.out.println("intializer");
        //System.out.println(imageView.getImage());


        //imageView.setImage(animals[0][0]);
        System.out.println("intializer");

        displayImage();


    }

    public void displayImage(){
        String url = "src/sample/images/"+generateRandomAnimal();
        File file = new File(url);
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public String generateRandomAnimal(){
        animals = new String[][]{{"lion","lion.png"}, {"Elephant","elephant.png"},{"Rhinoceros","rhinoceros.png"},{"Leopard","leopard.png"},{"Buffalo","buffalo.png"}};
        String url = "";

        SecureRandom random = new SecureRandom();
        int newIndex = random.nextInt(animals.length);
        int current = -1;

        if(newIndex == current){
            random = new SecureRandom();
            newIndex = random.nextInt(animals.length);
        }
        else{
            url = animals[newIndex][1];
            current = newIndex;

        }
        String name = animals[newIndex][0];
        //txtAnimal = new Label(name);
        myLabel.setText(shuffle(name));
        val = url;
        return url;
    }


    private static String shuffle(String sentence) {
        String[] words = sentence.split("\\s+");
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            List<Character> letters = new ArrayList<Character>();
            for (char letter : word.toCharArray()) {
                letters.add(letter);
            }
            if (letters.size() > 2) {
                Collections.shuffle(letters.subList(1, letters.size() - 1));
            }
            for (char letter : letters) {
                builder.append(letter);
            }
            builder.append(" ");
        }
        return builder.toString();
    }

    public void calculate(ActionEvent actionEvent) {
    }

    public void calc(ActionEvent actionEvent) {
    }

    public void buttonPressed(javafx.event.ActionEvent actionEvent) {

        Play play = new Play();
        play.setName(txtAnswer.getText());

        //System.out.println(s.substring(0, s.length() - 2));

        //String val = generateRandomAnimal();


        String value = val.substring(0, val.length() - 4);
        String valueToCompare = play.getName();
        int count;
        for(count = 0; count <=2; count++){
            //if(value.equals(valueToCompare))
                if(value.equalsIgnoreCase(valueToCompare)){
                System.out.println("Congratulation");
                JOptionPane.showMessageDialog(null, "Congratulations you got it right!!", "Congratulation", JOptionPane.PLAIN_MESSAGE);
                break;
            }
            else{

                displayImage();
                System.out.println("Wrong answer try again!");
            }

            System.out.println(count);


        }

            //JOptionPane.showConfirmDialog(null,
                   // "You have exceded your chances, do you want to try again", "Game Over", JOptionPane.YES_NO_OPTION);




        System.out.println(play.getName());

        System.out.println("Pressed");
    }
}

package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Domain.Person;


import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PersonController implements ActionListener {

    private Person person;

    @FXML
    private Button btnPlay;

    @FXML
    private TextField txtName;


    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {

    }

    public void callNextView(ActionEvent e)
    {

        person = new Person();
        person.setName(txtName.getText());

        System.out.println(person.getName());

        String message = "Welcome How the game is played?????";
       //JOptionPane.showMessageDialog(null,message);
        txtName.setText("");


       try{
           Stage primaryStage = new Stage();
           Parent root = FXMLLoader.load(getClass().getResource("../Views/PlayView.fxml"));
           primaryStage.setTitle("Play View");
           primaryStage.setScene(new Scene(root, 735, 590));
           primaryStage.show();
       }
       catch(IOException ex)
       {

       }



    }
}

package controllers;

import classes.Bill;
import classes.Client;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import main.App;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static main.App.clientsList;
import static main.App.loggedIn_Client;

public class ClientBills_Controller implements Initializable {
    @FXML
    private ComboBox billsComboBox;
    @FXML
    private Label amount, date, label_1;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AddToDropDown();
    }

    public void back() throws IOException {
        new App().changeScene("client/client_dashboard.fxml");
    }

    public void AddToDropDown() {
        for (int i = 0; i < loggedIn_Client.getBills().size(); i++) {
            billsComboBox.getItems().add(loggedIn_Client.getBills().get(i).getName());
        }
    }

    private Bill findBill(String billName) {
        for (int i = 0; i < loggedIn_Client.getBills().size(); i++) {
            if (billName.equals(loggedIn_Client.getBills().get(i).getName())) {
                return loggedIn_Client.getBills().get(i);
            }
        }
        return null;
    }

    public void showBillDetails() {
        if (!billsComboBox.getSelectionModel().isEmpty()) {
            Bill bill = findBill(billsComboBox.getSelectionModel().getSelectedItem().toString());
            if(bill == null){
                return;
            }
            amount.setText(String.valueOf(bill.getAmount()));
            date.setText(String.valueOf(bill.getDueDate()));
        }
    }


    public void payBill() {
        resetLabels();
        Client currentClient = loggedIn_Client;
        double selectedAmount = Double.parseDouble(amount.getText());

        if (billsComboBox.getSelectionModel().isEmpty()) {
            label_1.setText("Choose a bill");
            return;
        }

        Bill bill = findBill(billsComboBox.getValue().toString());
        if(bill == null){
            return;
        }
        if(billsComboBox==null){
            return;
        }
        if (loggedIn_Client.payBill(bill) > -1) {
            amount.setText("-");
            date.setText("-");
            billsComboBox.getItems().remove(billsComboBox.getValue());
            label_1.setText("Payment Successful");

            currentClient.AddTransaction("Bill Successfully payed ",selectedAmount*-1);

            AddToDropDown();
        } else {

            label_1.setText("Insufficient Balance");
        }
    }

    private void resetLabels() {
        label_1.setText("");
//        label_2.setText("");
//        label_3.setText("");
//        label_4.setText("");
    }


}

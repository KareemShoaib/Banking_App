package controllers;

import classes.Client;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.App;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import classes.Transaction;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import static main.App.loggedIn_Client;

public class Transaction_Controller  {

    @FXML
    void BACK(ActionEvent event) throws IOException {
        new App().changeScene("client/client_dashboard.fxml");
    }

    @FXML
    void BILLSTRANS(ActionEvent event) throws IOException {
        new App().changeScene("client/BillsTransaction.fxml");
    }

    @FXML
    void TRANSTRANS(ActionEvent event) throws IOException {
        new App().changeScene("client/AllTransactions.fxml");
    }

    }


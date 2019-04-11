package com.mycompany.library.controller;

import com.mycompany.library.model.DBManager;
import com.mycompany.library.view.View;
import javax.swing.JTextField;

public class Controller {

    private View view;
    private DBManager dbManager;

    public Controller() {
        view = new View(this);
    }

    public void handleBookQueryButtons(int choice) {
        DBManager.getDbManager().getBookList().clear();
        DBManager.getDbManager().fillBookList(choice);
        String[] listOfBooks = new String[DBManager.getDbManager().getBookList().size()];

        for (int i = 0; i < DBManager.getDbManager().getBookList().size(); i++) {
            listOfBooks[i] = i + 1 + ". " + DBManager.getDbManager().getBookList().get(i).toString();
        }
        view.getDisplayList().setListData(listOfBooks);
    }

    public void handleSearchRadioButtons(int choice, String searchTerm) {
        if (choice == 1) {
            DBManager.getDbManager().getSearchingResultsFromDb(1, searchTerm);
        } else {
            DBManager.getDbManager().getSearchingResultsFromDb(2, searchTerm);
        }
        String[] listOfBooks = new String[DBManager.getDbManager().getBookList().size()];

        for (int i = 0; i < DBManager.getDbManager().getBookList().size(); i++) {
            listOfBooks[i] = i + 1 + ". " + DBManager.getDbManager().getBookList().get(i).toString();
        }
        view.getDisplayList().setListData(listOfBooks);
    }

    public void createNewReader(String name, String address) {
        DBManager.getDbManager().addNewReaderToDB(name, address);
        view.getLbUserLoggedIn().setText("Welcome, " + name + "!");
    }

    public void authenticateReader(String name, int reader_id) {
        DBManager.getDbManager().loginReader(name, reader_id);
        if (DBManager.getDbManager().getLoggedReader() == null) {
            view.getLbUserLoggedIn().setText("Authentication failure!");
            
        } else {
            view.getLbUserLoggedIn().setText("Welcome, " + name + "!");
        }
    }

    public void executeRental() {
        int[] rentedBooks = view.getDisplayList().getSelectedIndices();
        DBManager.getDbManager().addRentalsToDb(rentedBooks);

    }

}

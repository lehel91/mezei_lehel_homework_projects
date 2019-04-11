package com.mycompany.library.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBManager {

    private static DBManager dbManager = null;

    private List<Book> bookList = new ArrayList<>();
    private List<Reader> readers = new ArrayList<>();
    private Reader loggedReader = null;

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USERNAME = "lehel91";
    private static final String PASSWORD = "Ml19911224";

    private DBManager() {

    }

    public static DBManager getDbManager() {
        if (dbManager == null) {
            dbManager = new DBManager();
        }
        return dbManager;
    }

    public Reader getLoggedReader() {
        return loggedReader;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public List<Book> fillBookList(int queryChoice) {
        
        String sqlAllBooks = "SELECT A.TITLE, B.BOOK_ID, B.ISBN, D.AUTHOR_NAME\n"
                + "FROM LEHEL91.BOOKS A\n"
                + "LEFT JOIN LEHEL91.BOOK_INSTANCES B\n"
                + "ON A.ISBN = B.ISBN\n"
                + "LEFT JOIN LEHEL91.BOOK_AUTHORS C\n "
                + "ON B.ISBN = C.ISBN\n"
                + "LEFT JOIN LEHEL91.AUTHORS D\n"
                + "ON C.AUTHOR_ID = D.AUTHOR_ID\n"
                + "ORDER BY B.BOOK_ID";

        String sqlAvailableBooks = "SELECT A.TITLE, B.BOOK_ID, B.ISBN, D.AUTHOR_NAME\n"
                + "FROM LEHEL91.BOOKS A\n"
                + "LEFT JOIN LEHEL91.BOOK_INSTANCES B\n"
                + "ON A.ISBN = B.ISBN\n"
                + "LEFT JOIN LEHEL91.BOOK_AUTHORS C\n"
                + "ON B.ISBN = C.ISBN\n"
                + "LEFT JOIN LEHEL91.AUTHORS D\n"
                + "ON C.AUTHOR_ID = D.AUTHOR_ID\n"
                + "WHERE B.AVAILABLE = 1\n"
                + "ORDER BY B.BOOK_ID";

        String sqlUnavailableBooks = "SELECT A.TITLE, B.BOOK_ID, B.ISBN, D.AUTHOR_NAME\n"
                + "FROM LEHEL91.BOOKS A\n"
                + "LEFT JOIN LEHEL91.BOOK_INSTANCES B\n"
                + "ON A.ISBN = B.ISBN\n"
                + "LEFT JOIN LEHEL91.BOOK_AUTHORS C\n"
                + "ON B.ISBN = C.ISBN\n"
                + "LEFT JOIN LEHEL91.AUTHORS D\n"
                + "ON C.AUTHOR_ID = D.AUTHOR_ID\n"
                + "WHERE B.AVAILABLE = 0\n"
                + "ORDER BY B.BOOK_ID";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            Statement statement = connection.createStatement();
            ResultSet rs;
            switch (queryChoice) {
                case 1:
                    rs = statement.executeQuery(sqlAllBooks);
                    break;
                case 2:
                    rs = statement.executeQuery(sqlAvailableBooks);
                    break;
                default:
                    rs = statement.executeQuery(sqlUnavailableBooks);
                    break;
            }

            while (rs.next()) {
                Book book = new Book(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4));
                bookList.add(book);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return bookList;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    //1 - Searching by Author | 2 - Searching by Title
    public List<Book> getSearchingResultsFromDb(int searchChoice, String searchTerm) {
        bookList.clear();

        String sqlSearchByAuthor = "SELECT A.TITLE, C.AUTHOR_NAME\n"
                + "FROM LEHEL91.BOOKS A\n"
                + "LEFT JOIN LEHEL91.BOOK_AUTHORS B\n"
                + "ON A.ISBN = B.ISBN\n"
                + "LEFT JOIN LEHEL91.AUTHORS C\n"
                + "ON B.AUTHOR_ID = C.AUTHOR_ID\n"
                + "WHERE LOWER (C.AUTHOR_NAME) LIKE \'%" + searchTerm + "%\'\n"
                + "ORDER BY A.TITLE";

        String sqlSearchByTitle = "SELECT A.TITLE, C.AUTHOR_NAME\n"
                + "FROM LEHEL91.BOOKS A\n"
                + "LEFT JOIN LEHEL91.BOOK_AUTHORS B\n"
                + "ON A.ISBN = B.ISBN\n"
                + "LEFT JOIN LEHEL91.AUTHORS C\n"
                + "ON B.AUTHOR_ID = C.AUTHOR_ID\n"
                + "WHERE LOWER (A.TITLE) LIKE '" + '%' + searchTerm + '%' + "' "
                + "ORDER BY A.TITLE";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            Statement statement = connection.createStatement();
            ResultSet rs;
            switch (searchChoice) {
                case 1:
                    rs = statement.executeQuery(sqlSearchByAuthor);
                    break;
                default:
                    rs = statement.executeQuery(sqlSearchByTitle);
                    break;
            }

            while (rs.next()) {
                Book book = new Book(rs.getString(1), rs.getString(2));
                bookList.add(book);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return bookList;
    }

    public void addNewReaderToDB(String name, String address) {
        String sqlMaxID = "SELECT MAX(READER_ID) FROM LEHEL91.READERS";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet rsMaxId = statement.executeQuery(sqlMaxID);
            rsMaxId.next();
            int id = rsMaxId.getInt(1) + 1;

            String sqlNewReader = "INSERT INTO LEHEL91.READERS(READER_ID,READER_NAME,ADDRESS)"
                    + "VALUES(" + id + ",\'" + name + "\',\'" + address + "\')";
            Statement statement2 = connection.createStatement();
            statement2.executeUpdate(sqlNewReader);

            loggedReader = new Reader(id, name, address);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void addRentalsToDb(int[] rentedBooks) {
        String sqlHowMuchRentals = "select count(*) from lehel91.book_rentals";
        String sqlMaxRental_id = "select max(rental_id) from lehel91.book_rentals";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet rsNumberOfRentals = statement.executeQuery(sqlHowMuchRentals);
            rsNumberOfRentals.next();

            if (rentedBooks.length >= 1) {

                for (int i = 0; i < rentedBooks.length; i++) {
                    Statement statement3 = connection.createStatement();
                    ResultSet rsMaxId = statement3.executeQuery(sqlMaxRental_id);
                    rsMaxId.next();
                    int maxRentalId = rsMaxId.getInt(1);
                    String sqlAdditionalRentals = "INSERT INTO LEHEL91.book_rentals(RENTAL_ID,READER_ID,BOOK_ID,RENTAL_DATE,RETURN_DATE)"
                            + "VALUES(" + (maxRentalId + 1) + "," + loggedReader.getReader_id() + "," + bookList.get(rentedBooks[i]).getBook_id() + ","
                            + "sysdate,sysdate + 30)";
                    Statement statement4 = connection.createStatement();
                    statement4.executeUpdate(sqlAdditionalRentals);

                    String sqlSetAvailability2 = "UPDATE LEHEL91.BOOK_INSTANCES SET AVAILABLE = 0 "
                            + "WHERE BOOK_ID = " + bookList.get(rentedBooks[i]).getBook_id();
                    Statement statement5 = connection.createStatement();
                    statement5.executeUpdate(sqlSetAvailability2);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void loginReader(String name, int reader_id) {
        String sqlAuthenticate = "SELECT READER_NAME, READER_ID FROM LEHEL91.READERS "
                + "WHERE READER_NAME = " + "\'" + name + "\' AND READER_ID = " + reader_id;

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet rsReaderToAuthenticate = statement.executeQuery(sqlAuthenticate);

            while (rsReaderToAuthenticate.next()) {
                loggedReader = new Reader(rsReaderToAuthenticate.getString(1), rsReaderToAuthenticate.getInt(2));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

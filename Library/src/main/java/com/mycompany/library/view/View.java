package com.mycompany.library.view;

import com.mycompany.library.controller.Controller;
import com.mycompany.library.model.DBManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class View extends JFrame implements ActionListener {

    private Controller controller;

    private DefaultListModel listModel = new DefaultListModel();
    private JList displayList = new JList(listModel);
    private JButton btAllBooks = new JButton("All of the books");
    private JButton btAllBooksAvailable = new JButton("Available books");
    private JButton btAllBooksRented = new JButton("Rented books");
    private JButton btSearch = new JButton("Search");
    private JButton btRentingBook = new JButton("Rent a book");
    private JButton btVirtualShelf = new JButton("Use Virtual Shelf");
    private JButton btStartSelectingToTheShelf = new JButton("Starting selection");
    private JButton btGetSearchResults = new JButton("Scan");
    private JButton btRentSelected = new JButton("Rent the selected book");
    private JLabel lbUserLoggedIn = new JLabel();
    private JRadioButton rbExistingReader = new JRadioButton("Registered Reader");
    private JRadioButton rbRegisteringNewReader = new JRadioButton("Add new Reader");
    private ButtonGroup bgSettingReaderOptions = new ButtonGroup();
    private JRadioButton rbSearchingByAuthorName = new JRadioButton("By Author Name", true);
    private JRadioButton rbSearchingByBookTitle = new JRadioButton("By Book Title");
    private ButtonGroup bgSearchingOptions = new ButtonGroup();
    private JTextField tfSearchingForText = new JTextField();
    private JTextField tfReaderToLogin = new JTextField();
    private JCheckBox cbOrderShelfByAuthors = new JCheckBox("Order by Authors", false);
    private final String[] CAPACITY_OPTIONS = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
        "13", "14", "15", "16", "17", "18", "19", "20"};
    private JComboBox cbCapacityOfShelf = new JComboBox(CAPACITY_OPTIONS);

    public View(Controller controller) {
        this.controller = controller;
        init();
    }

    public JList getDisplayList() {
        return displayList;
    }

    public JLabel getLbUserLoggedIn() {
        return lbUserLoggedIn;
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("BH Library");
        setSize(400, 600);
        setLocationRelativeTo(this);

        setLayout(new GridLayout(2, 1));

        JPanel screenPanel = new JPanel();
        /* az alabbi layout beállítással eléred, hogy az ide rakott egyetlen list kitöltse a teljes panelt, 
         mivel centerbe fogja rakni */
        screenPanel.setLayout(new BorderLayout());

        JPanel operationPanel = new JPanel();
        operationPanel.setLayout(new GridLayout(2, 2));

        displayList.setVisibleRowCount(15);
        JScrollPane displayScrollPane = new JScrollPane(displayList);
        screenPanel.add(displayScrollPane);

        //Itt allitjuk be a listazo panelhez kotodo komponenseket
        JPanel queryPanel = new JPanel(new GridLayout(3, 1));
        queryPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.lightGray));
        queryPanel.add(btAllBooks);
        btAllBooks.addActionListener(this);
        queryPanel.add(btAllBooksAvailable);
        btAllBooksAvailable.addActionListener(this);
        queryPanel.add(btAllBooksRented);
        btAllBooksRented.addActionListener(this);
        operationPanel.add(queryPanel);

        //Itt allitjuk be a kereso panelhez kotodo komponenseket
        JPanel searchPanel = new JPanel(new GridLayout(5, 1));
        searchPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.lightGray));
        searchPanel.add(btSearch);
        btSearch.addActionListener(this);
        searchPanel.add(rbSearchingByAuthorName);
        bgSearchingOptions.add(rbSearchingByAuthorName);
        rbSearchingByAuthorName.setVisible(false);
        searchPanel.add(rbSearchingByBookTitle);
        bgSearchingOptions.add(rbSearchingByBookTitle);
        rbSearchingByBookTitle.setVisible(false);
        searchPanel.add(tfSearchingForText);
        tfSearchingForText.setVisible(false);
        searchPanel.add(btGetSearchResults);
        btGetSearchResults.addActionListener(this);
        btGetSearchResults.setVisible(false);
        operationPanel.add(searchPanel);

        //Itt allitjuk be a kolcsonzesi panelhez kotodo komponenseket
        JPanel rentalPanel = new JPanel(new GridLayout(5, 1));
        rentalPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.lightGray));
        rentalPanel.add(btRentingBook);
        btRentingBook.addActionListener(this);
        bgSettingReaderOptions.add(rbExistingReader);
        rbExistingReader.addActionListener(this);
        rbExistingReader.setVisible(false);
        rentalPanel.add(rbExistingReader);
        bgSettingReaderOptions.add(rbRegisteringNewReader);
        rbRegisteringNewReader.addActionListener(this);
        rbRegisteringNewReader.setVisible(false);
        rentalPanel.add(rbRegisteringNewReader);
        rentalPanel.add(btRentSelected);
        btRentSelected.addActionListener(this);
        btRentSelected.setVisible(false);
        rentalPanel.add(lbUserLoggedIn);
        lbUserLoggedIn.setVisible(false);
        operationPanel.add(rentalPanel);

        //Itt allitjuk be a virtualis konyvespolc panelt
        JPanel virtualShelfPanel = new JPanel(new GridLayout(4, 1));
        virtualShelfPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.lightGray));
        virtualShelfPanel.add(btVirtualShelf);
        btVirtualShelf.addActionListener(this);
        virtualShelfPanel.add(cbCapacityOfShelf);
        cbCapacityOfShelf.setSize(25, 25);
        cbCapacityOfShelf.setVisible(false);
        virtualShelfPanel.add(cbOrderShelfByAuthors);
        cbOrderShelfByAuthors.setVisible(false);
        virtualShelfPanel.add(btStartSelectingToTheShelf);
        btStartSelectingToTheShelf.addActionListener(this);
        btStartSelectingToTheShelf.setVisible(false);
        operationPanel.add(virtualShelfPanel);

        add(screenPanel);
        add(operationPanel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btAllBooks)) {
            listModel.clear();
            controller.handleBookQueryButtons(1);

        } else if (e.getSource().equals(btAllBooksAvailable)) {
            listModel.clear();
            controller.handleBookQueryButtons(2);

        } else if (e.getSource().equals(btAllBooksRented)) {
            listModel.clear();
            controller.handleBookQueryButtons(3);

        } else if (e.getSource().equals(btSearch)) {
            rbSearchingByAuthorName.setVisible(true);
            rbSearchingByBookTitle.setVisible(true);
            tfSearchingForText.setVisible(true);
            btGetSearchResults.setVisible(true);

        } else if (e.getSource().equals(btGetSearchResults)) {
            if (rbSearchingByAuthorName.isSelected()) {
                controller.handleSearchRadioButtons(1, tfSearchingForText.getText());
            } else {
                controller.handleSearchRadioButtons(2, tfSearchingForText.getText());
            }

        } else if (e.getSource().equals(btRentingBook)) {
            rbRegisteringNewReader.setVisible(true);
            rbExistingReader.setVisible(true);
            tfReaderToLogin.setVisible(true);
            controller.handleBookQueryButtons(2); // itt még egyszer lekérdezzük a kölcsönözhető könyveket. 
            btRentSelected.setVisible(true);

        } else if (e.getSource().equals(rbExistingReader)) {
            lbUserLoggedIn.setVisible(true);
            showLoginOptionPane();
            listModel.clear();
            controller.handleBookQueryButtons(2); // itt még egyszer lekérdezzük a kölcsönözhető könyveket. 
            btRentSelected.setVisible(true);

        } else if (e.getSource().equals(btRentSelected)) {
            controller.executeRental();
            controller.handleBookQueryButtons(2);

        } else if (e.getSource().equals(rbRegisteringNewReader)) {
            lbUserLoggedIn.setVisible(true);
            showRegisterOptionPane();
            listModel.clear();
            controller.handleBookQueryButtons(2); // itt még egyszer lekérdezzük a kölcsönözhető könyveket. 

        } else if (e.getSource().equals(btVirtualShelf)) {
            cbCapacityOfShelf.setVisible(true);
            cbOrderShelfByAuthors.setVisible(true);
            btStartSelectingToTheShelf.setVisible(true);

        } else if (e.getSource().equals(btStartSelectingToTheShelf)) {
            controller.handleBookQueryButtons(1);
            showShelfView();
        }
    }

    public void showRegisterOptionPane() {
        JTextField nameField = new JTextField(25);
        JTextField addressField = new JTextField(25);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Name:"));
        myPanel.add(nameField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Address:"));
        myPanel.add(addressField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter the reader's Name and Address", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String address = addressField.getText();
            controller.createNewReader(name, address);
        }
    }

    public void showLoginOptionPane() {
        JTextField nameField = new JTextField(25);
        JTextField reader_idField = new JTextField(5);

        reader_idField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9')
                        || (c == KeyEvent.VK_BACK_SPACE)
                        || (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Name:"));
        myPanel.add(nameField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Reader_ID:"));
        myPanel.add(reader_idField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter the reader's Name and Reader_ID", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            int reader_id = Integer.parseInt(reader_idField.getText());
            controller.authenticateReader(name, reader_id);
        }
    }

    public void showShelfView() {
        new ShelfView(cbCapacityOfShelf.getSelectedIndex() + 1);
    }
}

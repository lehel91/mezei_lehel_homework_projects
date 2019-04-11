package com.mycompany.library.view;

import com.mycompany.library.model.DBManager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class ShelfView extends JFrame implements ActionListener, ListSelectionListener {

    private DefaultListModel dfmLeft = new DefaultListModel();
    private JList listOnLeftSide = new JList(dfmLeft);
    private DefaultListModel dfmRight
            = new DefaultListModel();
    private JList listOnTheRightSide = new JList(dfmRight);
    private JButton btOneToTheRight = new JButton(" > ");
    private JButton btnToTheRight = new JButton(" >> ");
    private JButton btOneToTheLeft = new JButton(" < ");
    private JButton btnToTheLeft = new JButton(" << ");

    public ShelfView(int capacity) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("BookShelf");
        setSize(400, 200);
        setLocationRelativeTo(this);
        setResizable(false);
        JPanel panel = new JPanel(new GridLayout(1, 3));
        panel.add(new JLabel("Left List"));
        panel.add(new JLabel());
        panel.add(new JLabel("Right List"));
        add(panel, BorderLayout.NORTH);
        JPanel pnLists = new JPanel(new GridLayout(1, 3));

        for (int i = 0; i < DBManager.getDbManager().getBookList().size(); i++) {
            dfmLeft.addElement(i + 1 + ". book: " + DBManager.getDbManager().getBookList().get(i));
        }
        pnLists.add(listOnLeftSide);
        JPanel pnGomb = new JPanel(new GridLayout(4, 1));
        pnGomb.add(btOneToTheRight);
        pnGomb.add(btnToTheRight);
        pnGomb.add(btOneToTheLeft);
        pnGomb.add(btnToTheLeft);
        pnLists.add(pnGomb);
        pnLists.add(listOnTheRightSide);
        Dimension dimension = new Dimension(15, capacity);
        listOnTheRightSide.setMaximumSize(dimension);

        add(pnLists);
        btOneToTheRight.addActionListener(this);
        btnToTheRight.addActionListener(this);
        btOneToTheLeft.addActionListener(this);
        btnToTheLeft.addActionListener(this);
        listOnLeftSide.addListSelectionListener(this);
        listOnTheRightSide.addListSelectionListener(this);
        setVisible(true);
        setupButton();
    }

    private void setupButton() {
        btOneToTheRight.setEnabled(listOnLeftSide.getSelectedIndices().length == 1);
        btnToTheRight.setEnabled(listOnLeftSide.getSelectedIndices().length > 1);
        btOneToTheLeft.setEnabled(listOnTheRightSide.getSelectedIndices().length == 1);
        btnToTheLeft.setEnabled(listOnTheRightSide.getSelectedIndices().length > 1);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        setupButton();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setupButton();
        Object chosen1;
        Object[] chosenN;
        if (e.getSource() == btOneToTheRight) {
            chosen1 = listOnLeftSide.getSelectedValue();
            dfmRight.addElement(chosen1);
            dfmLeft.removeElement(chosen1);

        } else if (e.getSource() == btOneToTheLeft) {
            chosen1 = listOnTheRightSide.getSelectedValue();
            dfmLeft.addElement(chosen1);
            dfmRight.removeElement(chosen1);
        } else if (e.getSource() == btnToTheRight) {
            chosenN = listOnLeftSide.getSelectedValues();
            for (int i = chosenN.length - 1; i >= 0; i--) {
                dfmRight.addElement(chosenN[i]);
                dfmLeft.removeElement(chosenN[i]);
            }
        } else if (e.getSource() == btnToTheLeft) {
            chosenN = listOnTheRightSide.getSelectedValues();
            for (int i = chosenN.length - 1; i >= 0; i--) {
                dfmLeft.addElement(chosenN[i]);
                dfmRight.removeElement(chosenN[i]);
            }
        }
    }
}

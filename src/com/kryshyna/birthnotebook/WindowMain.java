package com.kryshyna.birthnotebook;

import javax.swing.*;
import javax.xml.bind.JAXBException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Vadym Kryshyna
 * Date: 30.09.14
 * Time: 23:17
 */
public class WindowMain extends JFrame{

    public static void main(String[] args) throws JAXBException {
        JFrame frame = new WindowMain();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public WindowMain() throws JAXBException {
        initComponents();
    }

    private void initComponents() throws JAXBException {
        final WindowMain windowMain = this;
        this.setTitle("Birth notebook");

        menuBar1 = new JMenuBar();
        menu1 = new JMenu("Menu");
        menuItemAbout = new JMenuItem("About");
        scrollPane1 = new JScrollPane();
        table1 = new JTable(new TablePerson(BaseManager.readBase()));
        scrollPane1.setViewportView(table1);
        buttonAddPerson = new JButton("Add person");
        buttonSave = new JButton("Save");

        table1.setToolTipText("List person");
        buttonAddPerson.setToolTipText("Press for add new person");
        buttonSave.setToolTipText("Press for save change");

        Container contentPane = getContentPane();
        menu1.add(menuItemAbout);
        menuBar1.add(menu1);
        setJMenuBar(menuBar1);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(buttonAddPerson)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                                .addComponent(buttonSave)
                                .addGap(67, 67, 67))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttonAddPerson)
                                        .addComponent(buttonSave))
                                .addContainerGap(66, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());

        menuItemAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, messageAbout);
            }
        });

        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(saveDate()){
                    JOptionPane.showMessageDialog(null, "Saving complete.");
                }else{
                    JOptionPane.showMessageDialog(null, "Saving abort. Please try again.");
                }
            }
        });

        buttonAddPerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WindowAddPerson windowAddPerson = new WindowAddPerson(windowMain, table1.getRowCount()+1);
            }
        });

    }
    public void addPersonToTable(Person person){
        ((TablePerson) table1.getModel()).addPerson(person);
        if(saveDate()){
            JOptionPane.showMessageDialog(null, "Add complete.");
        }else{
            JOptionPane.showMessageDialog(null, "Please save date.");
        }
        table1.updateUI();
    }

    private boolean saveDate(){
        TablePerson temp = (TablePerson) table1.getModel();
        try {
            BaseManager.saveBase(temp.getPeople());
            return true;
        } catch (JAXBException e1) {
            e1.printStackTrace();
            return false;
        }
    }

    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItemAbout;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton buttonAddPerson;
    private JButton buttonSave;
    private String messageAbout = "@Author: Vadym Kryshyna \n     2014";
}

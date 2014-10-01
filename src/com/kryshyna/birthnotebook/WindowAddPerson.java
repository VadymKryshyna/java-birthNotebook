package com.kryshyna.birthnotebook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Vadym Kryshyna
 * Date: 30.09.14
 * Time: 23:48
 */
public class WindowAddPerson extends JFrame {



    public WindowAddPerson(WindowMain windowMain, int id){
        initComponents(id);
        this.windowMain = windowMain;
        this.setVisible(true);
    }

    private void initComponents(final int id) {
        final JFrame frame = this;
        this.setTitle("Add person");
        labelD = new JLabel("ID");
        labelSecondName = new JLabel("Second name");
        labelFirstName = new JLabel("First name");
        labelBirthDate = new JLabel("Birth date");
        labelValueID = new JLabel(id+"");
        textFieldSecondName = new JTextField();
        textFieldFirstName = new JTextField();
        textFieldBirthDate = new JTextField();
        buttonSavePerson = new JButton("Save");
        buttonCancel = new JButton("Cancel");

        labelValueID.setToolTipText("ID new person");
        textFieldSecondName.setToolTipText("Input second name");
        textFieldFirstName.setToolTipText("Input first name");
        textFieldBirthDate.setToolTipText("Input birth date");
        buttonCancel.setToolTipText("Press for cancel");
        buttonSavePerson.setToolTipText("Press for add person");

        Container contentPane = getContentPane();

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(labelBirthDate, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(textFieldBirthDate, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(labelSecondName, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(labelFirstName, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(textFieldSecondName, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                                        .addComponent(textFieldFirstName, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(labelD, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                                .addGap(33, 33, 33)
                                                .addComponent(labelValueID, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonSavePerson, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonCancel, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelValueID, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelD, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(textFieldSecondName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelSecondName, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(textFieldFirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelFirstName, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(textFieldBirthDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelBirthDate, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttonSavePerson)
                                        .addComponent(buttonCancel))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());

        buttonSavePerson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textFieldSecondName.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Please input second name");
                }else if(textFieldFirstName.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Please input first name");
                }else if(textFieldBirthDate.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Please input birth date");
                }else{
                    Person person = new Person();
                    person.setId(id);
                    person.setSecondName(textFieldSecondName.getText());
                    person.setFirstName(textFieldFirstName.getText());
                    person.setBirthDate(textFieldBirthDate.getText());
                    windowMain.addPersonToTable(person);
                    frame.dispose();
                }
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    private JLabel labelD;
    private JLabel labelValueID;
    private JTextField textFieldSecondName;
    private JTextField textFieldFirstName;
    private JTextField textFieldBirthDate;
    private JLabel labelSecondName;
    private JLabel labelFirstName;
    private JLabel labelBirthDate;
    private JButton buttonSavePerson;
    private JButton buttonCancel;
    private final WindowMain windowMain;
}

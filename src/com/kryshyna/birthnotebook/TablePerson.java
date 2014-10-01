package com.kryshyna.birthnotebook;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vadym Kryshyna
 * Date: 30.09.14
 * Time: 15:46
 */
public class TablePerson extends AbstractTableModel {
    private List<Person> people;
    private List<String> columnName;

    public TablePerson(People people){
        this.people = people.getPeople();
        this.columnName= new ArrayList<String>();
        this.columnName.add("ID");
        this.columnName.add("Second name");
        this.columnName.add("First name");
        this.columnName.add("Birth date");
    }

    public People getPeople(){
        People p = new People();
        p.setPeople(people);
        return p;
    }

    public void addPerson(Person person){
        this.people.add(person);
    }

    @Override
    public int getRowCount() {
        return people.size();
    }

    @Override
    public int getColumnCount() {
        return columnName.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object object;
        if(columnIndex==0){
             object = people.get(rowIndex).getId();
        }else if(columnIndex==1){
            object = people.get(rowIndex).getSecondName();
        } else if(columnIndex==2){
            object = people.get(rowIndex).getFirstName();
        }else{
            object = people.get(rowIndex).getBirthDate();
        }
        return object;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex==0){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnName.get(column);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(columnIndex==1){
            people.get(rowIndex).setSecondName((String) aValue);
        }else if(columnIndex==2){
            people.get(rowIndex).setFirstName((String) aValue);
        }else{
            people.get(rowIndex).setBirthDate((String) aValue);
        }
    }
}

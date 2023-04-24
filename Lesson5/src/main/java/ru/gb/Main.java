package ru.gb;

import ru.gb.dao.StudentDAO;
import ru.gb.utils.FillTable;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        if (studentDAO.getAllStudents().isEmpty()){
            FillTable.fillTable();
        }
    }
}
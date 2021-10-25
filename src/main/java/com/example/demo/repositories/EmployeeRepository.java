package com.example.demo.repositories;

import com.example.demo.models.Employee;
import utilities.DbConnectionManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();

        try {
            var dbManager = new DbConnectionManager();
            var conn = dbManager.getConnection();
            var statement = conn.prepareStatement("SELECT * FROM employees;");
            var rs = statement.executeQuery();

            while(rs.next()) {
                var employee = new Employee(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8));
                employees.add(employee);
            }

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return employees;
    }
}

package com.niantic.services;

import com.niantic.models.Employees;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Repository
public class MySqlEmployeesDao implements EmployeesDao{
    JdbcTemplate jdbcTemplate;

    public MySqlEmployeesDao() {
        String databaseUrl = "jdbc:mysql://localhost:3306/northwind";
        String userName = "root";
        String password = "P@ssw0rd";
        DataSource dataSource = new BasicDataSource() {{
            setUrl(databaseUrl);
            setUsername(userName);
            setPassword(password);
        }};

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Employees> getEmployees() {
        List<Employees> employees = new ArrayList<>();

        String sql = """
                SELECT employee_id
                    , last_name
                    , first_name
                    , title
                    , title_of_courtesy
                    , birth_date
                    , hire_date
                    , address
                    , city
                    , region
                    , postal_code
                    , country
                    , home_phone
                    , extension
                    , notes
                    , reports_to
                    , salary
                FROM employees;
                """;
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql);

//                    , cast(birth_date as date) as birth_date
//                    , cast(hire_date as date) as hire_date
        try {
            while (row.next()) {
                int employeeId = row.getInt("employee_id");
                String lastName = row.getString("last_name");
                String firstName = row.getString("first_name");
                String title = row.getString("title");
                String titleOfCourtesy = row.getString("title_of_courtesy");
                LocalDateTime birthDate = null;
                LocalDateTime hireDate = null;
                String address = row.getString("address");
                String city = row.getString("city");
                String region = row.getString("region");
                String postalCode = row.getString("postal_code");
                String country = row.getString("country");
                String homePhone = row.getString("home_phone");
                String extension = row.getString("extension");
                String notes = row.getString("notes");
                int reportsTo = row.getInt("reports_to");
                float salary = row.getFloat("salary");

                var convertBirth = row.getString("birth_date");
                if (convertBirth != null) {
                    birthDate = LocalDateTime.parse((convertBirth));
                }

                var convertHire = row.getString("hire_date");
                if (convertHire != null) {
                    hireDate = LocalDateTime.parse(convertHire);
                }

                var employee = new Employees(employeeId, lastName, firstName, title
                        , titleOfCourtesy, birthDate, hireDate, address, city, region
                        , postalCode, country, homePhone, extension, notes, reportsTo, salary);

                employees.add(employee);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return employees;

    }
}

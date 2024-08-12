package com.niantic.services;

import com.niantic.models.Transactions;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;


import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;


public class TransactionsDao
{
    private JdbcTemplate jdbcTemplate;
    private static TransactionsDao dao = new TransactionsDao();

    public TransactionsDao()
    { //create my datasource
        String databaseUrl = "jdbc:mysql://localhost:3306/budget";
        String userName = "root";
        String password = "P@ssw0rd";
        DataSource dataSource = new BasicDataSource(){{
            setUrl(databaseUrl);
            setUsername(userName);
            setPassword(password);
        }};

        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public ArrayList<Transactions> getAllTransactions()
    {

        var transactions = new ArrayList<Transactions>();

        String sql = """
                SELECT transaction_id
                    , user_id
                    , sub_category_id
                    , vendor_id
                    , transaction_date
                    , amount
                FROM transactions;
                """;

        var row =jdbcTemplate.queryForRowSet(sql);

        //loop through the rows to find transaction data of all transactions

        while(row.next())
        {
            int transactionId = row.getInt("transaction_id");
            int userId = row.getInt("user_id");
            int subcategoryId = row.getInt("sub_category_id");
            int vendorId = row.getInt("vendor_id");
            LocalDate transactionDate = row.getDate("transaction_date").toLocalDate();
            double amount = row.getDouble("amount");

            //list for all the 'pulled' data to be stored in. will be used if there is new data populated
            var transaction = new Transactions(transactionId, userId, subcategoryId, vendorId, transactionDate, amount);
            transactions.add(transaction); //add that into the original list
        }

        return transactions;
    }

    public void addTransaction (Transactions transactions)
    {
        String sql = """
                INSERT INTO transactions (user_id
                                        , sub_category_id
                                        , vendor_id
                                        , transaction_date
                                        , amount
                                        )
                VALUES (?,?,?,?,?);
                """;

        jdbcTemplate.update(sql,
                transactions.getUserId(),
                transactions.getSubCategoryId(),
                transactions.getVendorId(),
                transactions.getTransactionDate(),
                transactions.getAmount());

    }

    public Transactions getTransactionById(int searchUId) {
        String sql = """
                SELECT transaction_id
                    , user_id
                    , sub_category_id
                    , vendor_id
                    , transaction_date
                    , amount
                FROM transactions;
                WHERE user_id = ?;
                """;
        var row = jdbcTemplate.queryForRowSet(sql, searchUId);

        while (row.next()) {
            int transactionId = row.getInt("transaction_id");
            int userId = row.getInt("user_id");
            int subcategoryId = row.getInt("sub_category_id");
            int vendorId = row.getInt("vendor_id");
            LocalDate transactionDate = row.getDate("transaction_date").toLocalDate();
            double amount = row.getDouble("amount");

            return new Transactions(transactionId, userId, subcategoryId, vendorId, transactionDate, amount);
        }

        return null;
    }

    public void deleteTransaction (int id)
    {
        String sql = """
                DELETE FROM transactions WHERE transaction_id = ?;
                """;
        jdbcTemplate.update(sql, id);
    }






}

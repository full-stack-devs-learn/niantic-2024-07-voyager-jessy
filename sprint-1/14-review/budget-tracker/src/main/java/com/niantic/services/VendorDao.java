package com.niantic.services;



import com.niantic.models.Category;
import com.niantic.models.Vendor;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;


import javax.sql.DataSource;
import java.util.ArrayList;

public class VendorDao
{
    private JdbcTemplate jdbcTemplate;

    public VendorDao()
    {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/budget");
        dataSource.setUsername("root");
        dataSource.setPassword("P@ssw0rd");

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public ArrayList<Vendor> getAllVendors()
    {
        var vendors = new ArrayList<Vendor>();

        String sql = """
                SELECT vendor_id
                    , vendor_name
                    , website
                FROM vendors;
                """;
        SqlRowSet row = jdbcTemplate.queryForRowSet(sql);

        while(row.next())
        {
            int vendorId = row.getInt("vendor_id");
            String vendorName = row.getString("vendor_name");
            String website = row.getString("website");

            var vendor = new Vendor(vendorId, vendorName, website);
            vendors.add(vendor);
        }
        return vendors;

    }

    public void addVendor (Vendor vendors)
    {
        String sql = """
                INSERT INTO vendors (vendor_id
                                    , vendor_name
                                    , website
                                    )
                VALUES (?
                    ,?
                    ,?
                    );
                """;

        jdbcTemplate.update(sql,
                vendors.getVendorId(),
                vendors.getVendorName(),
                vendors.getWebsite());

    }

    public void deleteVendor(int vendorId)
    {
        String sql = """
                DELETE FROM vendors
                WHERE vendor_id = ?;
                """;

        jdbcTemplate.update(sql, vendorId);
    }


}

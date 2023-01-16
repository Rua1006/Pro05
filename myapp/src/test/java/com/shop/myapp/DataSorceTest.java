package com.shop.myapp;


import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootTest
@Log4j2
public class DataSorceTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void test() throws Exception {
        @Cleanup
        Connection con = dataSource.getConnection();
        log.info(con);
        Assertions.assertNotNull(con);
    }
}

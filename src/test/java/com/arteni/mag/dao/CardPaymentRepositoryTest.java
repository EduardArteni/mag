package com.arteni.mag.dao;

//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.arteni.mag.Models.CardPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;


class CardPaymentRepositoryTest {


    private CardPaymentRepositoryDAO cardPaymentRepositoryDAO = new CardPaymentRepositoryDAO();

    @Test
    void findByCardNumber() {

        CardPayment testCardPayment = cardPaymentRepositoryDAO.findById(1);
        assertEquals(1, testCardPayment.getId());

    }

    @Test
    void findById() {
    }

    @Test
    public void whenInjectInMemoryDataSource_thenReturnCorrectEmployeeCount() {
        DataSource dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:db-schema/db_updates.sql")
                .build();

        CardPaymentRepositoryDAO cardPaymentRepositoryDAO = new CardPaymentRepositoryDAO();
        cardPaymentRepositoryDAO.setDataSource(dataSource);

        assertEquals(4, cardPaymentRepositoryDAO.findById(0));
    }

}
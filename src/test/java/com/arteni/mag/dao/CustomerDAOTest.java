package com.arteni.mag.dao;

import com.arteni.mag.Models.Customer;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;

@DataJdbcTest
class CustomerDAOTest {

    @Mock
    private JdbcTemplate jdbcTemplate;


    @Test
    public void whenMockJdbcTemplate_thenReturnCorrectEmployeeCount() {
        CustomerDAO customerDAO = new CustomerDAO();
        ReflectionTestUtils.setField(customerDAO, "jdbcTemplate", jdbcTemplate);
        Mockito.when(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM EMPLOYEE", Integer.class))
                .thenReturn(4);

        assertEquals(4, customerDAO.findAll());
    }

//    private JdbcTemplate jdbcTemplate;
//    private CustomerDAO dao;
//
//    @Autowired
//    public CustomerDAOTest(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//        dao = new CustomerDAO(jdbcTemplate);
//    }
//
//    @Test
//    public void findById() {
//
//        Customer customer = dao.findById(1L);
//        assertEquals(1l, customer.getId());
//    }




//    @Test
//    public void whenMockJdbcTemplate_thenReturnCorrectEmployeeCount() {
//
//        CardPaymentRepositoryDAO cardPaymentRepositoryDAO = new CardPaymentRepositoryDAO();
//        cardPaymentRepositoryDAO.setJdbcTemplate(jdbcTemplate);
//
////        ReflectionTestUtils.setField(cardPaymentRepositoryDAO, "jdbcTemplate", jdbcTemplate);
////        Mockito.when(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM EMPLOYEE", Integer.class))
////                .thenReturn(4);
//
//        assertEquals(0, cardPaymentRepositoryDAO.findById(0));
//    }
}
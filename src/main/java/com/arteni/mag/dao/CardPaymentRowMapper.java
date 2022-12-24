package com.arteni.mag.dao;

import com.arteni.mag.Models.CardPayment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CardPaymentRowMapper implements RowMapper {
    @Override
    public CardPayment mapRow(ResultSet rs, int rowNum) throws SQLException {

        CardPayment cardPayment = new CardPayment();
        cardPayment.setId(rs.getLong("id"));
        cardPayment.setCardType(rs.getString("card_Type"));
        cardPayment.setCardNumber(rs.getString("card_Number"));
        cardPayment.setTransactionAmount(rs.getDouble("transaction_Amount"));
        cardPayment.setCardHolderName(rs.getString("card_Holder_Name"));
        cardPayment.setExpDate(rs.getDate("exp_Date"));
        cardPayment.setCV2(rs.getString("CV2"));

        return cardPayment;
    }
}
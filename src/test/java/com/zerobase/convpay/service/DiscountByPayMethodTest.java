package com.zerobase.convpay.service;

import static org.junit.jupiter.api.Assertions.*;

import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethodType;
import org.junit.jupiter.api.Test;

class DiscountByPayMethodTest {

  DiscountByPayMethod discountByPayMethod = new DiscountByPayMethod();

  @Test
  void discount_success() {
    //given
    PayRequest payRequestMoney = new PayRequest(PayMethodType.MONEY, ConvenienceType.G25, 1000);
    PayRequest payRequestCard = new PayRequest(PayMethodType.CARD, ConvenienceType.G25, 1000);

    //when
    Integer discountedAmountMoney = discountByPayMethod.getDiscountedAmount(payRequestMoney);
    Integer discountedAmountCard = discountByPayMethod.getDiscountedAmount(payRequestCard);

    //then
    assertEquals(700, discountedAmountMoney);
    assertEquals(1000, discountedAmountCard);
  }

}
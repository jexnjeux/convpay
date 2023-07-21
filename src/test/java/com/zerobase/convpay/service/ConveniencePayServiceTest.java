package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.ConvenienceType;
import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.dto.PayResponse;
import com.zerobase.convpay.dto.PayResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConveniencePayServiceTest {

  ConveniencePayService conveniencePayService = new ConveniencePayService();

  @Test
  void pay_success() {
    //given
    PayRequest payRequest = new PayRequest(ConvenienceType.G25, 100);

    //when
    PayResponse payResponse = conveniencePayService.pay(payRequest);

    //then
    Assertions.assertEquals(PayResult.SUCCESS, payResponse.getPayResult());
    Assertions.assertEquals(100, payResponse.getPaidAmount());
  }

}
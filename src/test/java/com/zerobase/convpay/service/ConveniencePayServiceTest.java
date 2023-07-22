package com.zerobase.convpay.service;

import static org.junit.jupiter.api.Assertions.*;

import com.zerobase.convpay.dto.PayCancelRequest;
import com.zerobase.convpay.dto.PayCancelResponse;
import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.dto.PayResponse;
import com.zerobase.convpay.type.PayCancelResult;
import com.zerobase.convpay.type.PayMethodType;
import com.zerobase.convpay.type.PayResult;
import java.util.Arrays;
import java.util.HashSet;
import org.junit.jupiter.api.Test;

class ConveniencePayServiceTest {
  // ConveniencePayService 의 단독 기능이 아니라 moneyAdapter 를 활용하고 있기 때문에 완벽한 Unit Test 는 아님!

  ConveniencePayService conveniencePayService = new ConveniencePayService(
      new HashSet<>(
          Arrays.asList(new MoneyAdapter(), new CardAdapter())
      ),
      new DiscountByConvenience()
  );

  @Test
  void pay_success() {
    //given
    PayRequest payRequest = new PayRequest(PayMethodType.MONEY, ConvenienceType.G25, 50);

    //when
    PayResponse payResponse = conveniencePayService.pay(payRequest);

    //then
    assertEquals(PayResult.SUCCESS, payResponse.getPayResult());
    assertEquals(35, payResponse.getPaidAmount());
  }

  @Test
  void pay_fail() {
    //given
    PayRequest payRequest = new PayRequest(PayMethodType.MONEY, ConvenienceType.G25, 1_500_001);

    //when
    PayResponse payResponse = conveniencePayService.pay(payRequest);

    //then
    assertEquals(PayResult.FAIL, payResponse.getPayResult());
    assertEquals(0, payResponse.getPaidAmount());
  }

  @Test
  void pay_cance_success() {
    //given
    PayCancelRequest payCancelRequest = new PayCancelRequest(PayMethodType.MONEY,
        ConvenienceType.G25, 1000);

    //when
    PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);

    //then
    assertEquals(PayCancelResult.PAY_CANCEL_SUCCESS, payCancelResponse.getPayCancelResult());
  }

  @Test
  void pay_cancel_fail() {
    //given
    PayCancelRequest payCancelRequest = new PayCancelRequest(PayMethodType.MONEY,
        ConvenienceType.G25, 99);

    //when
    PayCancelResponse payCancelResponse = conveniencePayService.payCancel(
        payCancelRequest);

    //then
    assertEquals(PayCancelResult.PAY_CANCEL_FAIL, payCancelResponse.getPayCancelResult());
  }

}
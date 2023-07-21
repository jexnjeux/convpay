package com.zerobase.convpay.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.zerobase.convpay.type.MoneyUseCancelResult;
import com.zerobase.convpay.type.MoneyUseResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MoneyAdapterTest {

  MoneyAdapter moneyAdapter = new MoneyAdapter();

  @Test
  void use_fail() {
    //given
    Integer payAmount = 1_000_001;

    //when
    MoneyUseResult moneyUseResult = moneyAdapter.use(payAmount);

    //then
    assertEquals(MoneyUseResult.USE_FAIL, moneyUseResult);
  }

  @Test
  void use_success() {
    //given
    Integer payAmount = 1_000_000;

    //when
    MoneyUseResult moneyUseResult = moneyAdapter.use(payAmount);

    //then
    assertEquals(MoneyUseResult.USE_SUCCESS, moneyUseResult);
  }

  @Test
  void use_cancel_success() {
    //given
    Integer payCancelAmount = 101;

    //when
    MoneyUseCancelResult moneyUseCancelResult = moneyAdapter.useCancel(payCancelAmount);

    //then
    assertEquals(MoneyUseCancelResult.MONEY_USE_CANCEL_SUCCESS, moneyUseCancelResult);

  }

  @Test
  void use_cancel_fail() {
    //given
    Integer payCancelAmount = 99;

    //when
    MoneyUseCancelResult moneyUseCancelResult = moneyAdapter.useCancel(payCancelAmount);

    //then
    assertEquals(MoneyUseCancelResult.MONEY_USE_CANCEL_FAIL, moneyUseCancelResult);

  }
}
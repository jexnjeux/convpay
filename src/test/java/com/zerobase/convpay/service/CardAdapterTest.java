package com.zerobase.convpay.service;

import static org.junit.jupiter.api.Assertions.*;

import com.zerobase.convpay.type.CardUseCancelResult;
import com.zerobase.convpay.type.CardUseResult;
import org.junit.jupiter.api.Test;

class CardAdapterTest {

  private CardAdapter cardAdapter = new CardAdapter();

  @Test
  void capture_successs() {
    //given
    Integer payAmount = 99;

    //when
    CardUseResult cardUseResult = cardAdapter.capture(payAmount);

    //then
    assertEquals(CardUseResult.CARD_USE_SUCCESS, cardUseResult);
  }

  @Test
  void capture_fail() {
    //given
    Integer payAmount = 101;

    //when
    CardUseResult cardUseResult = cardAdapter.capture(payAmount);

    //then
    assertEquals(CardUseResult.CARD_USE_FAIL, cardUseResult);
  }

  @Test
  void cancel_capture_success() {
    //given
    Integer cancelAmount = 1001;

    //when
    CardUseCancelResult cardUseCancelResult = cardAdapter.cancelCapture(cancelAmount);

    //then
    assertEquals(CardUseCancelResult.CARD_USE_CANCEL_SUCCESS, cardUseCancelResult);
  }

  @Test
  void cancel_capture_fail() {
    //given
    Integer cancelAmount = 999;

    //when
    CardUseCancelResult cardUseCancelResult = cardAdapter.cancelCapture(cancelAmount);

    //then
    assertEquals(CardUseCancelResult.CARD_USE_CANCEL_FAIL, cardUseCancelResult);
  }
}
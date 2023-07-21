package com.zerobase.convpay.service;

import com.zerobase.convpay.type.MoneyUseCancelResult;
import com.zerobase.convpay.type.MoneyUseResult;
import com.zerobase.convpay.dto.PayCancelRequest;
import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.dto.PayResponse;
import com.zerobase.convpay.type.PayCancelResult;
import com.zerobase.convpay.type.PayResult;
import com.zerobase.convpay.dto.PayCancelResponse;

public class ConveniencePayService { // 편결이

  private final MoneyAdapter moneyAdapter = new MoneyAdapter(); // 한 번 만들면 바꿀 일이 없기 떄문에 final

  public PayResponse pay(PayRequest payRequest) {
    MoneyUseResult moneyUseResult = moneyAdapter.use(payRequest.getPayAmount());

    // 성공과 실패를 if / else 로 하는 것은 피하자

    // fail fast
    // Method()

    // Exception case1
    // Exception case2
    // Exception case 3

    // Success case (Only one)

    if (moneyUseResult == MoneyUseResult.USE_FAIL) {
      return new PayResponse(PayResult.FAIL, 0);
    }

    return new PayResponse(PayResult.SUCCESS, payRequest.getPayAmount());
  }

  public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) {
    MoneyUseCancelResult moneyUseCancelResult = moneyAdapter.useCancel(
        payCancelRequest.getPayCancelAmount());

    if (moneyUseCancelResult == MoneyUseCancelResult.MONEY_USE_CANCEL_FAIL) {
      return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
    }

    return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS,
        payCancelRequest.getPayCancelAmount());

  }

}

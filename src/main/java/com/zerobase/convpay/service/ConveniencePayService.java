package com.zerobase.convpay.service;

import com.zerobase.convpay.type.CancelPaymentResult;
import com.zerobase.convpay.type.CardUseResult;
import com.zerobase.convpay.type.MoneyUseCancelResult;
import com.zerobase.convpay.type.MoneyUseResult;
import com.zerobase.convpay.dto.PayCancelRequest;
import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.dto.PayResponse;
import com.zerobase.convpay.type.PayCancelResult;
import com.zerobase.convpay.type.PayMethodType;
import com.zerobase.convpay.type.PayResult;
import com.zerobase.convpay.dto.PayCancelResponse;
import com.zerobase.convpay.type.PaymentResult;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class ConveniencePayService { // 편결이
  private final Map<PayMethodType, PaymentInterface> paymentInterfaceMap = new HashMap<>();
  private final DiscountInterface discountInterface;


  public ConveniencePayService(Set<PaymentInterface> paymentInterfaceSet,
      DiscountInterface discountInterface) {
    paymentInterfaceSet.forEach(
        paymentInterface -> paymentInterfaceMap.put(
            paymentInterface.getPayMethodType(),
            paymentInterface
        )
    );
    this.discountInterface = discountInterface;
  }

  public PayResponse pay(PayRequest payRequest) {
    PaymentInterface paymentInterface = paymentInterfaceMap.get(payRequest.getPaymethodType());

    // 성공과 실패를 if / else 로 하는 것은 피하자

    // fail fast
    // Method()

    // Exception case1
    // Exception case2
    // Exception case 3

    // Success case (Only one)
    Integer discountedAmount = discountInterface.getDiscountedAmount(payRequest);
    PaymentResult paymentResult = paymentInterface.payment(discountedAmount);

    if (paymentResult == PaymentResult.PAYMENT_FAIL) {
      return new PayResponse(PayResult.FAIL, 0);
    }

    return new PayResponse(PayResult.SUCCESS, discountedAmount);
  }

  public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) {
    PaymentInterface paymentInterface = paymentInterfaceMap.get(payCancelRequest.getPayMethodType());

    CancelPaymentResult cancelPaymentResult = paymentInterface.cancelPayment(
        payCancelRequest.getPayCancelAmount());

    if (cancelPaymentResult == CancelPaymentResult.CANCEL_PAYMENT_FAIL) {
      return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
    }

    return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS,
        payCancelRequest.getPayCancelAmount());

  }

}

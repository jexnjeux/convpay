package com.zerobase.convpay.dto;

import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethodType;

public class PayRequest {
  // 결제 수단
  PayMethodType paymethodType;
  // 편의점 종류
  ConvenienceType convenienceType;

  // 결제 금액
  Integer payAmount;

  public PayRequest(PayMethodType paymethodType, ConvenienceType convenienceType, Integer payAmount) {
    this.paymethodType = paymethodType;
    this.convenienceType = convenienceType;
    this.payAmount = payAmount;
  }

  public PayMethodType getPaymethodType() {
    return paymethodType;
  }

  public void setPaymethodType(PayMethodType paymethodType) {
    this.paymethodType = paymethodType;
  }

  public ConvenienceType getConvenienceType() {
    return convenienceType;
  }

  public void setConvenienceType(ConvenienceType convenienceType) {
    this.convenienceType = convenienceType;
  }

  public Integer getPayAmount() {
    return payAmount;
  }

  public void setPayAmount(Integer payAmount) {
    this.payAmount = payAmount;
  }
}

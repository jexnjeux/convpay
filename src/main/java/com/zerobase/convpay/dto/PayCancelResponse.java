package com.zerobase.convpay.dto;

import com.zerobase.convpay.type.PayCancelResult;

public class PayCancelResponse {

  PayCancelResult payCancelResult;
  Integer payCanceledAmount;

  public PayCancelResponse(PayCancelResult payCancelResult, Integer payCanceledAmount) {
    this.payCancelResult = payCancelResult;
    this.payCanceledAmount = payCanceledAmount;
  }

  public PayCancelResult getPayCancelResult() {
    return payCancelResult;
  }

  public void setPayCancelResult(PayCancelResult payCancelResult) {
    this.payCancelResult = payCancelResult;
  }

  public Integer getPayCanceledAmount() {
    return payCanceledAmount;
  }

  public void setPayCanceledAmount(Integer payCanceledAmount) {
    this.payCanceledAmount = payCanceledAmount;
  }

  // toString() 은 제일 아래 만드는게 컨벤션
  @Override
  public String toString() {
    return "PayCancelResponse{" +
        "payCancelResult=" + payCancelResult +
        ", payCanceledAmount=" + payCanceledAmount +
        '}';
  }
}

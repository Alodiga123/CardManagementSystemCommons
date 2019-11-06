package com.cms.commons.util;


import java.io.Serializable;


public class TopUpCurrent implements Serializable {

  private String topUpId;
  private String topUpSender; 
  private String topUpDestination; 
  private String topUpName;
  private String operatorName;
  private String operatorId;
  private String totalAmount;
  private String countryName;

    public String getTopUpId() {
        return topUpId;
    }

    public void setTopUpId(String topUpId) {
        this.topUpId = topUpId;
    }

    public String getTopUpSender() {
        return topUpSender;
    }

    public void setTopUpSender(String topUpSender) {
        this.topUpSender = topUpSender;
    }

    public String getTopUpDestination() {
        return topUpDestination;
    }

    public void setTopUpDestination(String topUpDestination) {
        this.topUpDestination = topUpDestination;
    }

    public String getTopUpName() {
        return topUpName;
    }

    public void setTopUpName(String topUpName) {
        this.topUpName = topUpName;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }
    
    
 
}

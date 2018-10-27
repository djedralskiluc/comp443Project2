package com.company.ecomerce.customer;

public class PaymentType {
	private int Id;
	private String CardType;
	private String CCnumber;
	private String Exp;
	private String Pin;
	private String NameOnCard;
	
	public int getPaymentTypeId() {
		return Id;
	}
	public void setPaymentTypeId(int id) {
		Id = id;
	}
	public String getCardType() {
		return CardType;
	}
	public void setCardType(String cardType) {
		CardType = cardType;
	}
	public String getCC() {
		return CCnumber;
	}
	public void setCC(String cC) {
		CCnumber = cC;
	}
	public String getExp() {
		return Exp;
	}
	public void setExp(String exp) {
		Exp = exp;
	}
	public String getPin() {
		return Pin;
	}
	public void setPin(String pin) {
		Pin = pin;
	}
	public String getNameOnCard() {
		return NameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		NameOnCard = nameOnCard;
	}
	
}

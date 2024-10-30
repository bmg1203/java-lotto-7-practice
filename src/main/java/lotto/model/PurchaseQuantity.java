package lotto.model;

import lotto.constant.ErrorMessage;

public class PurchaseQuantity {
    private final Integer purchaseQuantity; //판매 수량

    private static final Integer DIVISOR = 1000;

    public PurchaseQuantity(String price){
        validate(price);
        this.purchaseQuantity = Integer.parseInt(price)/DIVISOR;
    }

    private void validate(String price){
        if(price.isEmpty()) throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        if(!price.matches("^-?\\d+$")) throw new IllegalArgumentException(ErrorMessage.NOT_NATURAL_NUMBER.getMessage());
        if(Integer.parseInt(price)<=0) throw new IllegalArgumentException(ErrorMessage.NOT_NATURAL_NUMBER.getMessage());
        if(Integer.parseInt(price)%1000!=0) throw new IllegalArgumentException(ErrorMessage.NOT_THOUSAND_PRICE.getMessage());
    }

    @Override
    public String toString() {
        return "PurchaseQuantity{" +
                "purchaseQuantity=" + purchaseQuantity +
                '}';
    }
}

package main.java.ru.clevertec.check.dto.request;

import java.math.BigDecimal;

public class DiscountCardDto {

    private String number;
    private String balance;

    public DiscountCardDto() {
    }

    public DiscountCardDto(String number, String balance) {
        this.number = number;
        this.balance = balance;
    }

    public Integer getNumber() {
        return number == null ? null : Integer.parseInt(number);
    }

    public BigDecimal getBalance() {
        return new BigDecimal(balance);
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String number;
        private String balance;

        public Builder number(String number) {
            this.number = number;
            return this;
        }

        public Builder balance(String balance) {
            this.balance = balance;
            return this;
        }

        public DiscountCardDto build() {
            return new DiscountCardDto(number, balance);
        }
    }
}

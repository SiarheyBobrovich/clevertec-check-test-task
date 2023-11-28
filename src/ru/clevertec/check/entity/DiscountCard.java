package ru.clevertec.check.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class DiscountCard {

    private Long id;
    private Integer number;
    private Byte amount;
    private BigDecimal balance;

    public DiscountCard() {
    }

    public DiscountCard(Long id, Integer number, Byte amount, BigDecimal balance) {
        this.id = id;
        this.number = number;
        this.amount = amount;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Byte getAmount() {
        return amount;
    }

    public void setAmount(Byte amount) {
        this.amount = amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountCard that = (DiscountCard) o;
        return Objects.equals(id, that.id) && Objects.equals(number, that.number) && Objects.equals(amount, that.amount) && Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, amount, balance);
    }

    @Override
    public String toString() {
        return "DiscountCard{" +
                "id=" + id +
                ", number=" + number +
                ", amount=" + amount +
                ", balance=" + balance +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Long id;
        private Integer number;
        private Byte amount;
        private BigDecimal balance;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder number(Integer number) {
            this.number = number;
            return this;
        }

        public Builder amount(Byte amount) {
            this.amount = amount;
            return this;
        }

        public Builder balance(BigDecimal balance) {
            this.balance = balance;
            return this;
        }

        public DiscountCard build() {
            return new DiscountCard(id, number, amount, balance);
        }
    }
}

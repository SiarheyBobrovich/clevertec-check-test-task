package main.java.ru.clevertec.check.dto;

import java.math.BigDecimal;

public record ProductInfo(String description,
                          BigDecimal price,
                          Integer count,
                          Boolean isTradePrice) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String description;
        private BigDecimal price;
        private Integer count;
        private Boolean isTradePrice;

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder count(Integer count) {
            this.count = count;
            return this;
        }

        public Builder tradePrice(Boolean tradePrice) {
            isTradePrice = tradePrice;
            return this;
        }

        public ProductInfo build() {
            return new ProductInfo(description, price, count, isTradePrice);
        }
    }
}

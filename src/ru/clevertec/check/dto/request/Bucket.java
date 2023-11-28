package ru.clevertec.check.dto.request;


import java.util.List;

public class Bucket {

    private final List<ProductDto> products;

    private final DiscountCardDto discountCard;

    public Bucket(List<ProductDto> products,
                  DiscountCardDto discountCard) {
        this.products = products;
        this.discountCard = discountCard;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public DiscountCardDto getDiscountCard() {
        return discountCard;
    }

    public void setDiscountCard(String discountCard) {
        this.discountCard.setNumber(discountCard);
    }

    public void setBalanceDebitCard(String balanceDebitCard) {
        this.discountCard.setBalance(balanceDebitCard);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private List<ProductDto> products;

        private DiscountCardDto discountCard;

        public Builder products(List<ProductDto> products) {
            this.products = products;
            return this;
        }

        public Builder discountCard(DiscountCardDto discountCard) {
            this.discountCard = discountCard;
            return this;
        }

        public Bucket build() {
            return new Bucket(products, discountCard);
        }
    }
}

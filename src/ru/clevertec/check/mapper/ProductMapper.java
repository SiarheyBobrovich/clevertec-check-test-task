package ru.clevertec.check.mapper;

import ru.clevertec.check.dto.ProductInfo;
import ru.clevertec.check.entity.Product;

public interface ProductMapper {

    ProductInfo toGoodInfo(Product product, Integer count);
}

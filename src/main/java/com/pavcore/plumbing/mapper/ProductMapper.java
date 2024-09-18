package com.pavcore.plumbing.mapper;

import com.pavcore.plumbing.dto.requestTo.ProductRequestTO;
import com.pavcore.plumbing.dto.responseTo.ProductResponseTO;
import com.pavcore.plumbing.entiy.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {

    Product mapReq(ProductRequestTO productRequestTO);

    ProductRequestTO mapReq(Product product);

    Product mapResp(ProductResponseTO productResponseTO);

    ProductResponseTO mapResp(Product product);

}

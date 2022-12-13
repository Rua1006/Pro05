package com.shop.myapp.service;


import com.shop.myapp.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    public List<ProductDTO> productList() throws Exception;
    public ProductDTO getProduct(int prono) throws Exception;
    public List<ProductDTO> productCateList(int cateno) throws Exception;
    public void productUpdate(ProductDTO dto) throws Exception;
    public void productDelete(int prono) throws Exception;
}

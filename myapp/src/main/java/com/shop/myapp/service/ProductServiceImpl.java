package com.shop.myapp.service;

import com.shop.myapp.dao.ProductDAO;
import com.shop.myapp.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductDAO productDAO;

    @Override
    public List<ProductDTO> productList() throws Exception {
        return productDAO.productList();
    }

    @Override
    public ProductDTO getProduct(int prono) throws Exception {
        return productDAO.getProduct(prono);
    }

    @Override
    public List<ProductDTO> productCateList(int cateno) throws Exception {
        return productDAO.productCateList(cateno);
    }

    @Override
    public void productUpdate(ProductDTO dto) throws Exception {
        productDAO.productUpdate(dto);
    }

    @Override
    public void productDelete(int prono) throws Exception {
        productDAO.productDelete(prono);
    }
}

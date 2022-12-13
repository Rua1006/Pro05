package com.shop.myapp.dao;

import com.shop.myapp.dto.ProductDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    SqlSession sqlSession;

    @Override
    public List<ProductDTO> productList() throws Exception {
        return sqlSession.selectList("product.productList");
    }

    @Override
    public ProductDTO getProduct(int prono) throws Exception {
        return sqlSession.selectOne("product.getProduct", prono);
    }

    @Override
    public List<ProductDTO> productCateList(int cateno) throws Exception {
        return sqlSession.selectList("product.productCateList", cateno);
    }

    @Override
    public void productUpdate(ProductDTO dto) throws Exception {
        sqlSession.update("product.productUpdate", dto);
    }

    @Override
    public void productDelete(int prono) throws Exception {
        sqlSession.delete("product.productDelete", prono);
    }
}

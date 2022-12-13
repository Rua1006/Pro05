package com.shop.myapp.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private int proNo;		//상품번호
    private int cateNo;		//카테 분류
    private String proName;	//상품명
    private int oriPrice;	//상품가격
    private double discountRate;	//할인율
    private String proSpec;	//상품규격
    private int proPrice;	//상품금액
    private String proPic;	//상품이미지
    private String proPic2;	//상품이미지2
    private int amount;  //수량
}

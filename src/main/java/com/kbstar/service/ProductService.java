package com.kbstar.service;

import com.kbstar.dto.Product;
import com.kbstar.frame.AespaService;
import com.kbstar.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService implements AespaService<Integer, Product> {
    /** 담당 : 정인보
     * 등록 & 가입 진행
     * argument : object
     *
     * @param product
     **/
    @Autowired
    ProductMapper productMapper;
    @Override
    public void register(Product product) throws Exception {
        productMapper.insert(product);
    }

    @Override
    public void remove(Integer product_id) throws Exception {
        productMapper.delete(product_id);
    }

    @Override
    public void modify(Product product) throws Exception {
        productMapper.update(product);
        // 참고. 수정 가능항목 : 상품명(product_name), 상품가격(product_price), 상품이미지파일(product_imgname)
    }

    @Override
    public Product get(Integer product_id) throws Exception {
        return productMapper.select(product_id);
    }

    @Override
    public List<Product> get() throws Exception {
        return productMapper.selectall();
    }

    // 이어링 조회하기
    public List<Product> selecterg() throws Exception {
        return productMapper.selecterg();
    }
    // 링 조회하기
    public List<Product> selectring() throws Exception {
        return productMapper.selectring();
    }
    // 팔찌 조회하기
    public List<Product> selectbracelet() throws Exception {
        return productMapper.selectbracelet();
    }
    // 목걸이 조회하기
    public List<Product> selectnecklace() throws Exception {
        return productMapper.selectnecklace();
    }
    // 워치 조회하기
    public List<Product> selectwch() throws Exception {
        return productMapper.selectwch();
    }
    // 그외 모던제품 조회하기
    public List<Product> selectmodern() throws Exception {
        return productMapper.selectmodern();
    }
    // 카테고리별 조회하기 1. 캐쥬얼
    public List<Product> selectcasual() throws Exception {
        return productMapper.selectcasual();
    }
    // 카테고리별 조회하기 1. 캐쥬얼
    public List<Product> selectgift() throws Exception {
        return productMapper.selectgift();
    }
    // 카테고리별 조회하기 1. 캐쥬얼
    public List<Product> selectwedding() throws Exception {
        return productMapper.selectwedding();
    }
}

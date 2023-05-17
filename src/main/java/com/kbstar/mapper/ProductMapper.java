package com.kbstar.mapper;

import com.kbstar.dto.Product;
import com.kbstar.frame.AespaMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductMapper extends AespaMapper<Integer, Product> {
    // 이어링 조회하기
    public List<Product> selecterg();
    // 링 조회하기
    public List<Product> selectring();
    // 팔찌 조회하기
    public List<Product> selectbracelet();
    // 목걸이 necklace 조회하기
    public List<Product> selectnecklace();
    // 시계 조회하기
    public List<Product> selectwch();
    // 그외 모던아이템 조회하기
    public List<Product> selectmodern();
    // 카테고리별 조회하기 1. 캐쥬얼
    public List<Product> selectcasual();
    // 카테고리별 조회하기 2. 기프트
    public List<Product> selectgift();
    // 카테고리별 조회하기 3.웨딩
    public List<Product> selectwedding();
}
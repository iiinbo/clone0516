package com.kbstar.dto;

import lombok.*;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Product { // 6개의 칼럼
        private int product_id; // 상품의 번호(시퀀스)
        private String product_name; // 상품명
        private int product_price; // 상품 가격
        private Date product_regdate; // 상품의 등록일자
        private String product_imgname; // 상품 이미지
        private int  category_id; // 상품의 카테고리 코드(수기등록 ex. 100 : 악세서리(최상위) - 101 : 귀걸리(하위))
        private int  category_sub_id; // 캐쥬얼(1) - 기프트(2) - 웨딩(3) 구분 기준

        // 5가지 기본 컨스트럭터 생성
        public Product(int product_id, String product_name, int product_price, Date product_regdate, String product_imgname, int category_id) {
                this.product_id = product_id;
                this.product_name = product_name;
                this.product_price = product_price;
                this.product_regdate = product_regdate;
                this.product_imgname = product_imgname;
                this.category_id = category_id;
        }
}

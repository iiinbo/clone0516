package com.kbstar.dto;

import lombok.*;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Cart { // 6개의 칼럼
        private String user_id; // PK, FK : 상품을 담은 장바구니의 주인(고객 아이디)
        private int product_id; // PK, FK : 상품의 번호
        private int cart_quantity; // 상품 수량
        private Date cart_date; // 상품을 장바구니에 담은 등록일자
        private String cart_status; // 상태 코드 ? 정리필요

        // 카트에 상품 추가 시 update 항목들 (4개)
        public Cart(String user_id, int product_id, int cart_quantity, Date cart_date) {
                this.user_id = user_id;
                this.product_id = product_id;
                this.cart_quantity = cart_quantity;
                this.cart_date = cart_date;
        }

        // 나의 장바구니 조회할 때 보여줄 상품들을 위해,
        // Product 테이블과 join을 통해
        // product_name / product_imgname / product_price 를 가져와서 보여줄 예정~
        private String product_name;
        private String product_imgname;
        private int product_price;

}

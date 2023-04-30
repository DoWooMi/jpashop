package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice; //주문 가격
    private int count; //주문 수량

    // == 생성 메서드 (주문아이템 생성) == //
    public static OrderItem createOrderItem(Item item, int orderPrice, int count){//쿠폰받거나 할인받을 수 있기 때문에 orderprice 따로 작성
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setOrderPrice(orderPrice);
        orderItem.setCount(count);
        
        item.removeStock(count);
        return orderItem;
    }
    
    // == 비즈니스 로직 == //
    //주문취소시 재고수량 원복
    public void cancel(){
        getItem().addStock(count);
    }

    // == 조회 로직 == //
    //주문상품 전체가격 조회
    public int getTotalPrice() {
        return getOrderPrice() * getCount();
    }
}

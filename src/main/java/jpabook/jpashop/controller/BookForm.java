package jpabook.jpashop.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class BookForm {

    //item 속성
    private Long id;
    private String name;
    private int price;
    private int stockQuantity;

    //book 속성
    private String author;
    private String isbn;
}

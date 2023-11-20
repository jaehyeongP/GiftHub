package com.gifthub.gifticon.entity;

import com.gifthub.gifticon.dto.ProductDto;
import com.gifthub.global.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity @Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Product extends BaseTimeEntity {

    @Id
    @SequenceGenerator(name = "seq_product", sequenceName = "seq_product", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product")
    @Column(name = "product_id")
    private Long id;

    @OneToMany(mappedBy = "product")
    private List<Gifticon> gifticons = new ArrayList<>();

    private String name;
    private Long price;
    private String brandName;

    public ProductDto toProductDto() {
        return ProductDto.builder()
                .id(this.id)
                .name(this.name)
                .price(this.price)
                .brandName(this.brandName)
                .build();
    }

}

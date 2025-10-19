    package com.example.shoppingcart.entity;

    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;

    import java.util.List;

    @Entity
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String name;
        private String description;
        private double price;
        private int amount;
        private String imageUrl;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "type_id")
        private ProductType productType;

        @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<OrderDetail> orderDetails;
    }

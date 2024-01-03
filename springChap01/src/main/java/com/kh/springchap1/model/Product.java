package com.kh.springchap1.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="product_seqs")
	@SequenceGenerator(name="product_seqs", sequenceName="product_seqs", allocationSize=1)
	private Long id;
	private String name;
	private double price;
}
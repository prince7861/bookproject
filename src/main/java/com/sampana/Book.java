package com.sampana;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id
    private int bid;
    private String btitle;
    private String category;
    private String isbn;
    private int noOfPages;
    private int year;
    private String auther;
    private String publisher;
    private Date relaseDate;
    private double price;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.infsci2560.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 *
 * @author kolobj
 */
@Entity
public class Book {

    private static final long serialVersionUID = 1L;

    public enum BookType {
        Unknown,
        Novel,
        Science,
        Comic
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected String title;
    protected BookType bookType;
    protected int bookPrice;

    public Book() {
        this.id = Long.MAX_VALUE;
        this.title = null;
        this.bookType = BookType.Unknown;
        this.bookPrice = 0;
    }

    public Book(Long id, String name, BookType bookType, int bookPrice) {
        this.id = id;
        this.title = name;
        this.bookType = bookType;
        this.bookPrice = bookPrice;
    }

    @Override
    public String toString() {
        return "[ id=" + this.id + ", title=" + this.title + ", bookType=" + this.bookType + ", bookPrice=" + this.bookPrice + " ]";
    }

    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    /**
     * @return the name
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the name to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the workoutType
     */
    public BookType getBookType() {
        return bookType;
    }

    /**
     * @param workoutType the workoutType to set
     */
    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the bookPrice
     */
    public int getBookPrice() {
        return bookPrice;
    }

    /**
     * @param set bookPrice
     */
    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

}
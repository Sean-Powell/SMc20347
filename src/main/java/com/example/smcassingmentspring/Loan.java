package com.example.smcassingmentspring;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loanid")
    public long loanID;
    @Column(name = "bookid")
    public int bookID;
    @Column(name = "studentid")
    public int studentID;
    @Column(name = "loanexpiration")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date expirationDate;

    public int getBookID() {
        return bookID;
    }

    public int getStudentID() {
        return studentID;
    }

    public long getLoanID() {
        return loanID;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setLoanID(int loanID) {
        this.loanID = loanID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Loan(){

    }

    public Loan(int bookID, int studentID, Date expirationDate){
        super();
        this.bookID = bookID;
        this.studentID = studentID;
        this.expirationDate = expirationDate;

    }

    public Loan(int bookID, int studentID, String dateString){
        super();
        this.bookID = bookID;
        this.studentID = studentID;
        try {
            this.expirationDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        }catch (ParseException e){
            e.printStackTrace();
        }
    }
}

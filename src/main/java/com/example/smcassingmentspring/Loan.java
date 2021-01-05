package com.example.smcassingmentspring;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loanid")
    private int loanID;
    @Column(name = "bookid")
    private int bookID;
    @Column(name = "studentid")
    private int studentID;
    @Column(name = "loanexpiration")
    private Date expirationDate;

    public int getBookID() {
        return bookID;
    }

    public int getStudentID() {
        return studentID;
    }

    public int getLoanID() {
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
}

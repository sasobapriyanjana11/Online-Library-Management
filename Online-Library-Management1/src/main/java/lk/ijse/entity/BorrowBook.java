package lk.ijse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;



@Entity
    @Table(name = "Borrow_Book")
@Data
@AllArgsConstructor
@NoArgsConstructor
    public class BorrowBook{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "Borrow_id")
        private int id;

        @Column(name = "book_qty")
        private int qty;

        @Column(name = "due_date")
        private Date dueDate;

        @Column(name = "transaction_status")
        private String status;

        @CreationTimestamp
        @Column(name = "transaction_added")
        private Timestamp addedDate;

        @ManyToOne
        @JoinColumn(name = "userId")
        private User member;

        @Column(name = "Payment")
        private double payment;
}

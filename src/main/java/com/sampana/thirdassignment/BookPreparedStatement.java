package com.sampana.thirdassignment;

import com.sampana.Book;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookPreparedStatement implements ItemPreparedStatementSetter<Book> {

        @Override
        public void setValues(Book book, PreparedStatement ps) throws SQLException {
            ps.setInt(1, book.getBid());
            ps.setString(2, book.getAuther());
            ps.setString(3, book.getBtitle());
            ps.setString(4, book.getCategory());
            ps.setString(5, book.getIsbn());
            ps.setInt(6, book.getNoOfPages());
            ps.setDouble(7, book.getPrice());
            ps.setString(8, book.getPublisher());
            ps.setDate(9, (Date) book.getRelaseDate());
            ps.setInt(10, book.getYear());
        }
}

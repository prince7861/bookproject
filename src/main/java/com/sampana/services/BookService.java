package com.sampana.services;

import com.sampana.Book;
import com.sampana.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Service
public class BookService {
    @Autowired
    private BookRepository brepo;

    public Book addBook(Book book)
    {
        return  brepo.save(book);
    }

    public List<Book> addBooklist(List<Book> bookList)
    {
        return  brepo.saveAll(bookList);
    }
    public List<Book> getAllBooks()
    {
        return brepo.findAll();
    }
    public Book getBooksById(int bid)
    {
        return brepo.findById(bid).orElse(null);
    }
    public  String deleteBookById(int bid)
    {
        brepo.deleteById(bid);
        return "Books deleted";
    }

    public Book updateBook(Book book)
    {
        Book existingBook=brepo.findById(book.getBid()).orElse(null);
        existingBook.setBid(book.getBid());
        existingBook.setBtitle(book.getBtitle());
        existingBook.setCategory(book.getCategory());
        existingBook.setIsbn(book.getIsbn());
        existingBook.setNoOfPages(book.getNoOfPages());
        existingBook.setPrice(book.getPrice());
        existingBook.setPublisher(book.getPublisher());
        existingBook.setYear(book.getYear());
        existingBook.setRelaseDate(book.getRelaseDate());
        existingBook.setAuther(book.getAuther());
        return brepo.save(existingBook);
    }

}


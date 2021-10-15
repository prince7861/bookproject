package com.sampana.controller;

import com.sampana.Book;
import com.sampana.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@RestController
    public class BookController {
        @Autowired
        private BookService service;
        @PostMapping("/book")
        public Book addBook(@RequestBody Book book)
        {
            return service.addBook(book);
        }
        @PostMapping("/books")
        public List<Book> addBookList(@RequestBody List<Book> booklist)
        {
            return service.addBooklist(booklist);
        }
        @GetMapping("/books")
        public List<Book> findAllBooks()
        {
            return service.getAllBooks();
        }
        @GetMapping("/books/{id}")
        public Book findBookById(@PathVariable int id)
        {
            return service.getBooksById(id);
        }
        @PutMapping("/books/{id}")
        public Book updateBook(@RequestBody Book book)
        {
            return service.updateBook(book);
        }
        @PatchMapping("/books/{id}")

        public void patchBook(@PathVariable int id, @RequestBody Map<Object,Object>fields)
        {
        Book book =service.getBooksById(id);
        fields.forEach((k,v) ->{
            Field field = ReflectionUtils.findField(Book.class, (String) k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, book, v);
        });
            service.updateBook(book);
        }
        @DeleteMapping("/books/{id}")
        public String deleteProduct(@PathVariable int id)
        {
            return service.deleteBookById(id);
        }
    }


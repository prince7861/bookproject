package com.sampana.thirdassignment;

import com.sampana.Book;
import org.springframework.batch.item.ItemProcessor;

public class BookProcessor implements ItemProcessor<Book,Book> {
    @Override
    public Book process(Book book) throws Exception
    {
        return book;
    }
}

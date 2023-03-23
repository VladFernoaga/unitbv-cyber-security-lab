package com.unitbv.bookshop.service;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.unitbv.bookshop.dto.Book;

@Service
public class BookService {

    private static Set<Book> inMemoryBooks = new HashSet<>();

    public boolean addBook(Book book){
        return inMemoryBooks.add(book);

    }

    public List<Book> getBooks(){
        return List.copyOf(inMemoryBooks);
    }

    public Optional<Book> findByName(String name){
        return inMemoryBooks
          .stream()
          .filter(book -> book.getName().equals(name))
          .findFirst();
    }

    public  boolean removeBook(int id){
        return inMemoryBooks.removeIf(book -> book.getId() == id);
    }
}

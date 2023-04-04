package com.unitbv.bookshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unitbv.bookshop.dto.Book;
import com.unitbv.bookshop.service.BookService;

@RestController
@RequestMapping(path = "public/book")
public class BooksPublicController {

    @Autowired
    private BookService bookService;

    // For all users (Public)
    @GetMapping()
    public List<Book> getBooks() {
        return bookService.getBooks();
    }
}

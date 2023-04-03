package com.unitbv.bookshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unitbv.bookshop.dto.Book;
import com.unitbv.bookshop.service.BookService;

@RestController
@RequestMapping(path = "book")
public class BooksController {

    @Autowired
    private BookService bookService;

    // Only for ADMIN - ROLE ADMIN
//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public ResponseEntity<String> addBook(@RequestBody Book book) {


        if(bookService.addBook(book)){
            return ResponseEntity.ok("Succefuly add book with id " + book.getId() + " and name "+ book.getName());
        } else {
            return ResponseEntity.badRequest()
              .body("Id " + book.getId() + " already exists");
        }
    }

    // For all users (Public)
    @GetMapping()
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    // For registerd users - ROLE CUSTOMER
    @GetMapping("/{name}")
    public ResponseEntity<Book> getBookByName(@PathVariable("name") String name) {
        Optional<Book> book = bookService.findByName(name);

        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        } else {
            return ResponseEntity.notFound()
              .build();
        }
    }

    // Only for ADMIN - ROLE ADMIN
    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeBook(@PathVariable("id") int id) {
        if (bookService.removeBook(id)) {
            return ResponseEntity.ok("Succefuly removed book with id " + id);
        } else {
            return ResponseEntity.badRequest()
              .body("Id " + id + " not found");
        }
    }

}

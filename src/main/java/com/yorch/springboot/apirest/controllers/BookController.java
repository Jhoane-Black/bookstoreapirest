package com.yorch.springboot.apirest.controllers;

import com.yorch.springboot.apirest.models.VO.BookVO;
import com.yorch.springboot.apirest.models.entity.Author;
import com.yorch.springboot.apirest.models.entity.Book;
import com.yorch.springboot.apirest.models.entity.Respuesta;
import com.yorch.springboot.apirest.models.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.callback.TextOutputCallback;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.yorch.springboot.apirest.models.entity.Respuesta.ERROR;
import static com.yorch.springboot.apirest.models.entity.Respuesta.SUCCESS;

@CrossOrigin(origins = { "*" },allowedHeaders="*")
@RestController
@RequestMapping("/book")

public class BookController {

    @Autowired
    private IBookService iBookService;

    @PostMapping("/create")
    public Respuesta createBook (@RequestBody Book book) {
        iBookService.save(book);
        if (book.getBook_id() == 0) return ERROR;
        SUCCESS.setData(book);
     return SUCCESS;
    }

    @GetMapping("/{id}")
    public Respuesta getBookById(@PathVariable int id) {
        Book book = iBookService.findById(id);
        SUCCESS.setData(map(book));
        SUCCESS.setCodigo(200);
        return SUCCESS;
    }

    @PutMapping("/update/{id}")
    public @ResponseBody Respuesta updateBook (@RequestBody Book book, @PathVariable int id) {
        Book toEdit = iBookService.findById(id);
        if (toEdit == null) {
            ERROR.setCodigo(400);
            return ERROR;
        }

        toEdit.setBook_editorial(book.getBook_editorial());
        toEdit.setBook_title(book.getBook_title());
        toEdit.setBook_saga(book.getBook_saga());
        toEdit.setBook_price(book.getBook_price());
        toEdit.setBook_price_dis(book.getBook_price_dis());
        if (book.getAuthors().size() > 0) {
            for (Author a: book.getAuthors()) {
                toEdit.getAuthors().add(a);
            }
        }

        SUCCESS.setCodigo(200);
        SUCCESS.setData(iBookService.save(toEdit));
        return SUCCESS;
    }

    @GetMapping("/list")
    public Respuesta getBooks() {
        return iBookService.findAll();
    }

    private BookVO map (Book b){
        BookVO bvo = new BookVO(b.getBook_id(), b.getBook_title(), b.getBook_editorial(), b.getBook_saga(), b.getBook_price(), b.getBook_price_dis());
        if (b.getAuthors().size() > 0) bvo.setAuthors(new ArrayList<>(b.getAuthors()));
        return bvo;
    }
}

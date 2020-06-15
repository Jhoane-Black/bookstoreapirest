package com.yorch.springboot.apirest.controllers;

import com.yorch.springboot.apirest.models.entity.Book;
import com.yorch.springboot.apirest.models.entity.Respuesta;
import com.yorch.springboot.apirest.models.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.callback.TextOutputCallback;

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

        SUCCESS.setCodigo(200);
        SUCCESS.setData(iBookService.save(toEdit));
        return SUCCESS;
    }
}

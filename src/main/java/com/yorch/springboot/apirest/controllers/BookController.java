package com.yorch.springboot.apirest.controllers;

import com.yorch.springboot.apirest.models.entity.Book;
import com.yorch.springboot.apirest.models.entity.Respuesta;
import com.yorch.springboot.apirest.models.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}

package org.example.controller;

import org.example.model.Document;
import org.example.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class DocumentController {

    @Autowired
    private DocumentService service;

    @GetMapping("/")
    public String viewHome(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<Document> docPage = service.getDocuments(page, 5);
        List<Document> docs = docPage.getContent();
        model.addAttribute("docs", docs);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", docPage.getTotalPages());
        return "index";
    }

    @PostMapping("/upload")
    public String uploadDocument(@RequestParam("file") MultipartFile file) throws IOException {
        service.upload(file);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteDocument(@PathVariable Long id) {
        service.deleteDocument(id);
        return "redirect:/";
    }
}

package org.example.service;

import org.example.model.Document;
import org.example.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public Page<Document> getDocuments(int page, int size) {
        return documentRepository.findAll(PageRequest.of(page, size));
    }

    public void upload(MultipartFile file) throws IOException {
        Document doc = new Document();
        doc.setFileName(file.getOriginalFilename());
        doc.setData(file.getBytes());
        documentRepository.save(doc);
    }

    public void deleteDocument(Long id) {
        documentRepository.deleteById(id);
    }
}

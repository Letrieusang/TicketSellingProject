package org.example.controller;

import org.example.entity.InvoiceEntity;
import org.example.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/invoices")
@CrossOrigin(origins = "http://localhost:3000")
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;

    @GetMapping
    public List<InvoiceEntity> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceEntity> getInvoiceById(@PathVariable Integer id) {
        Optional<InvoiceEntity> invoice = invoiceService.getInvoiceById(id);
        return invoice.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public InvoiceEntity createInvoice(@RequestBody InvoiceEntity invoice) {
        return invoiceService.createInvoice(invoice);
    }

//    @PutMapping("/")
//    public ResponseEntity<InvoiceEntity> updateInvoice(@RequestBody InvoiceEntity invoiceDetails) {
//        InvoiceEntity updatedInvoice = invoiceService.updateInvoice(invoiceDetails);
//        return ResponseEntity.ok(updatedInvoice);
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Integer id) {
        invoiceService.deleteInvoice(id);
        return ResponseEntity.noContent().build();
    }
}
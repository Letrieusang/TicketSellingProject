package org.example.service;

import org.example.entity.InvoiceEntity;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {
    List<InvoiceEntity> getAllInvoices();

    Optional<InvoiceEntity> getInvoiceById(Integer invoiceId);

    InvoiceEntity createInvoice(InvoiceEntity invoice);

//    InvoiceEntity updateInvoice(InvoiceEntity invoiceDetails);

    void deleteInvoice(Integer invoiceId);
}
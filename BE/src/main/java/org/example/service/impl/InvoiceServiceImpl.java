package org.example.service.impl;

import org.example.entity.InvoiceEntity;
import org.example.repository.InvoiceRepository;
import org.example.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;

    @Override
    public List<InvoiceEntity> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public Optional<InvoiceEntity> getInvoiceById(Integer invoiceId) {
        return invoiceRepository.findById(invoiceId);
    }

    @Override
    public InvoiceEntity createInvoice(InvoiceEntity invoice) {
        return invoiceRepository.save(invoice);
    }

//    @Override
//    public InvoiceEntity updateInvoice(InvoiceEntity invoiceDetails) {
//        InvoiceEntity invoice = invoiceRepository.findById(invoiceDetails.getInvoiceId())
//                .orElseThrow(() -> new RuntimeException("Invoice not found"));
//        invoice.setTotalAmount(invoiceDetails.getTotalAmount());
//        invoice.setCartId(invoiceDetails.getCartId());
//        invoice.setDeliveryId(invoiceDetails.getDeliveryId());
//        invoice.setShippingFee(invoiceDetails.getShippingFee());
//        return invoiceRepository.save(invoice);
//    }

    @Override
    public void deleteInvoice(Integer invoiceId) {
        InvoiceEntity invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));
        invoiceRepository.delete(invoice);
    }
}
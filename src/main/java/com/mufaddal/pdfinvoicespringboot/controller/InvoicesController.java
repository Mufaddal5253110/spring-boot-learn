package com.mufaddal.pdfinvoicespringboot.controller;

import com.mufaddal.pdfinvoicespringboot.dto.InvoiceDto;
import com.mufaddal.pdfinvoicespringboot.model.Invoice;
import com.mufaddal.pdfinvoicespringboot.service.InvoiceService;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
public class InvoicesController {

    private final InvoiceService invoiceService;

    public InvoicesController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoices")
    // @RequestMapping(value = "/invoices", method = RequestMethod.GET)
    public Iterable<Invoice> invoices() {
        return invoiceService.findAll();
    }

    @PostMapping("/invoices")
    public Invoice createInvoice(@Valid @RequestBody InvoiceDto invoiceDto) {
        return invoiceService.create(invoiceDto.getUserId(), invoiceDto.getAmount());
    }

    @GetMapping("/invoices/user/{userId}")
    public Iterable<Invoice> invoices(@PathVariable String userId) {
        return invoiceService.findByUserId(userId);
    }
}

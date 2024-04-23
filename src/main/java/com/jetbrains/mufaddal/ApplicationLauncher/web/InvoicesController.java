package com.jetbrains.mufaddal.ApplicationLauncher.web;

import com.jetbrains.mufaddal.ApplicationLauncher.model.Invoice;
import com.jetbrains.mufaddal.ApplicationLauncher.service.InvoiceService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class InvoicesController {

    private final InvoiceService invoiceService;

    public InvoicesController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoices")
    // @RequestMapping(value = "/invoices", method = RequestMethod.GET)
    public List<Invoice> invoices() {
        return invoiceService.findAll();
    }

//    @PostMapping("/invoices")
//    public Invoice createInvoice(@RequestBody @Valid InvoiceDto invoiceDto) {
//        return invoiceService.create(invoiceDto.getUserId(), invoiceDto.getAmount());
//    }

    @PostMapping("/invoices")
    public Invoice createInvoice(@RequestParam("user_id") @NotEmpty String userId, @RequestParam @Min(0) @Max(100) Integer amount) {
        return invoiceService.create(userId, amount);
    }
}

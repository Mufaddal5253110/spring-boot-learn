package com.jetbrains.mufaddal.ApplicationLauncher.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
@Profile("dev")
public class DummyInvoiceServiceLoader {


    private final InvoiceService invoiceService;

    public DummyInvoiceServiceLoader(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostConstruct
    public void setup() {
        System.out.println("Creating dev invoices...");
//        invoiceService.create("someUserId", 50);
//        invoiceService.create("someOtherUserId", 100);
    }
}

/*
* Edit > Modify Options > Add VM Options
* VM Option: -Dspring.profiles.active=dev
* */

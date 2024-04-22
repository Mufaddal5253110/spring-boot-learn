package com.jetbrains.mufaddal.ApplicationLauncher.service;

import com.jetbrains.mufaddal.ApplicationLauncher.model.Invoice;
import com.jetbrains.mufaddal.ApplicationLauncher.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class InvoiceService {

    List<Invoice> invoices = new CopyOnWriteArrayList<>();
    private final UserService userService;

    @Autowired  //optional here
    public InvoiceService(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        System.out.println("Fetching PDF Template from S3...");
        // TODO download from s3 and save locally
    }

    public List<Invoice> findAll() {
        return invoices;
    }

    public Invoice create(String userId, Integer amount) {
        User user = userService.findById(userId);
        if (user == null) {
            throw new IllegalStateException();
        }
        // TODO real pdf creation and storing it on network server
        Invoice invoice = new Invoice(userId, amount, "http://www.africau.edu/images/default/sample.pdf");
        invoices.add(invoice);
        return new Invoice(userId, amount, "http://www.africau.edu/images/default/sample.pdf");
    }


}

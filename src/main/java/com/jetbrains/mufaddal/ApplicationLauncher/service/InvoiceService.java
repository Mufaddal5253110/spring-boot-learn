package com.jetbrains.mufaddal.ApplicationLauncher.service;

import com.jetbrains.mufaddal.ApplicationLauncher.model.Invoice;
import com.jetbrains.mufaddal.ApplicationLauncher.model.User;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class InvoiceService {

    List<Invoice> invoices = new CopyOnWriteArrayList<>();
    private final UserService userService;
    private final String cdnUrl;

    @Autowired  //optional here
    public InvoiceService(UserService userService, @Value("${cdn.url}") String cdnUrl) {
        this.userService = userService;
        this.cdnUrl = cdnUrl;
    }

    @PostConstruct
    public void init() {
        System.out.println("Calling Post Constructor Function...");
        // TODO download from s3 and save locally
    }

    @PreDestroy
    public void shutdown() {
        System.out.println("Calling Pre Destroy Function...");
        // TODO actual deletion of PDFs
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
        Invoice invoice = new Invoice(userId, amount, cdnUrl + "/images/default/sample.pdf");
        invoices.add(invoice);
        return invoice;
    }


}

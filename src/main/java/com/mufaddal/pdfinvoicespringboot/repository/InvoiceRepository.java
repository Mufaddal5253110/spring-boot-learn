package com.mufaddal.pdfinvoicespringboot.repository;

import com.mufaddal.pdfinvoicespringboot.model.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<Invoice, String> {
}

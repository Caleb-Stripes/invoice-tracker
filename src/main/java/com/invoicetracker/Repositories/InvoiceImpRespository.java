package com.invoicetracker.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.invoicetracker.models.InvoiceImp;

public interface InvoiceImpRespository extends CrudRepository<InvoiceImp, Long> {

}

package com.invoicetracker.models;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "contractorId")
public class Contractor extends User {

	/************************ Field Values ****************/

	private String firstName;
	private String lastName;
	private String payPalId;

	/*
	 * CODE REVIEW NEEDED. I need to understand why this mapped 
	 * is breaking the JPAMappingsTest shouldEstablishContractorToInvoiceImpRelationship 
	 */
	@OneToMany // (mappedBy = "contractor")
	private Collection<InvoiceImp> invoices;

	@ManyToMany
	private Collection<Agency> agencies;

	@ManyToMany(mappedBy = "contractors")
	private Collection<CustomerImp> customers;

	/************************ Getters and Setters ****************/

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPayPalId() {
		return payPalId;
	}

	public void setPayPalId(String payPalId) {
		this.payPalId = payPalId;
	}

	public Collection<InvoiceImp> getInvoices() {
		return invoices;
	}

	public Collection<Agency> getAgencies() {
		return agencies;
	}

	public Collection<CustomerImp> getCustomers() {
		return customers;
	}

	/************************ Constructors ****************/

	public Contractor() {
	}

	public Contractor(String firstName) {
		this.firstName = firstName;
	}

	public Contractor(String firstName, Agency... agencies) {
		this.firstName = firstName;
		this.agencies = new HashSet<>(Arrays.asList(agencies));
	}

	public Contractor(InvoiceImp... invoices) {
		this.invoices = new HashSet<>(Arrays.asList(invoices));
	}

	public Contractor(String firstName, InvoiceImp...invoices) {
		this.firstName = firstName;
		this.invoices = new HashSet<>(Arrays.asList(invoices));
	}

}

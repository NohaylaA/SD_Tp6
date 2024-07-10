package org.example.bankaccountservice.repository;

import org.example.bankaccountservice.entities.BankAccount;
import org.example.bankaccountservice.entities.Customer;
import org.example.bankaccountservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer,Long>
{

}


package org.example.bankaccountservice.service;

import org.example.bankaccountservice.dto.BankAccountRequestDTO;
import org.example.bankaccountservice.dto.BankAccountResponseDTO;

import java.util.List;

public interface AccountService
{
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO);
    BankAccountResponseDTO updateAccount(String id ,BankAccountRequestDTO bankAccountRequestDTO);
}

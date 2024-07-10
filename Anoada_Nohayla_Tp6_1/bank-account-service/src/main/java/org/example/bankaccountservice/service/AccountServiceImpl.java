package org.example.bankaccountservice.service;

import org.example.bankaccountservice.dto.BankAccountRequestDTO;
import org.example.bankaccountservice.dto.BankAccountResponseDTO;
import org.example.bankaccountservice.entities.BankAccount;
import org.example.bankaccountservice.enums.AccountType;
import org.example.bankaccountservice.mappers.AccountMapper;
import org.example.bankaccountservice.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService
{
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO)
    {
        BankAccount bankAccount= BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();
        BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(saveBankAccount);
        return bankAccountResponseDTO;
    }

    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO) {
        Optional<BankAccount> existingBankAccountOptional = bankAccountRepository.findById(id);
        if (!existingBankAccountOptional.isPresent()) {
            throw new ResourceNotFoundException("BankAccount not found with ID: " + id);
        }
        BankAccount existingBankAccount = existingBankAccountOptional.get();
        existingBankAccount.setBalance(bankAccountDTO.getBalance());
        existingBankAccount.setType(bankAccountDTO.getType());
        existingBankAccount.setCurrency(bankAccountDTO.getCurrency());
        BankAccount updatedBankAccount = bankAccountRepository.save(existingBankAccount);
        return accountMapper.fromBankAccount(updatedBankAccount);
    }

}

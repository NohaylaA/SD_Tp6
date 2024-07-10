package org.example.bankaccountservice.mappers;

import org.example.bankaccountservice.dto.BankAccountResponseDTO;
import org.example.bankaccountservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;

@Controller
public class AccountMapper
{
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount)
    {
        BankAccountResponseDTO bankAccountResponseDTO=new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount, bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }
}

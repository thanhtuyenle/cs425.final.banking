package edu.mum.cs.cs425.banking.bankingmanagement.controller;

import edu.mum.cs.cs425.banking.bankingmanagement.model.AccountType;
import edu.mum.cs.cs425.banking.bankingmanagement.model.Customer;
import edu.mum.cs.cs425.banking.bankingmanagement.service.AccountTypeService;
import edu.mum.cs.cs425.banking.bankingmanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AccountTypeController {
    //    @Autowired
    private AccountTypeService accountTypeService;

    @Autowired
    public AccountTypeController(AccountTypeService accountTypeService) {
        this.accountTypeService = accountTypeService;
    }

    @GetMapping(value = {"/banking/accounttype/list"})
    public ModelAndView listAccountTypes() {
        ModelAndView modelAndView = new ModelAndView();
        List<AccountType> accountTypes = accountTypeService.getAllAccountTypes();
        modelAndView.addObject("accountTypes", accountTypes);
        modelAndView.setViewName("accounttype/list");
        return modelAndView;
    }

    @GetMapping(value = {"/banking/accounttype/new"})
    public String displayNewAccountTypeForm(Model model) {
        model.addAttribute("accountType", new AccountType());
        return "accounttype/new";
    }

    @PostMapping(value = {"/banking/accounttype/new"})
    public String addNewAccountType(@Valid @ModelAttribute("accountType") AccountType accountType,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "accounttype/new";
        }
        accountType = accountTypeService.saveAccountType(accountType);
        return "redirect:/banking/accounttype/list";
    }

    @GetMapping(value = {"/banking/accounttype/edit/{accountTypeId}"})
    public String editAccountType(@PathVariable Integer accountTypeId, Model model) {
        AccountType accountType = accountTypeService.getAccountTypeById(accountTypeId);
        if (accountType != null) {
            model.addAttribute("accountType", accountType);
            return "accounttype/edit";
        }
        return "accounttype/list";
    }

    @PostMapping(value = {"/banking/accounttype/edit"})
    public String updateAccountType(@Valid @ModelAttribute("accountType") AccountType accountType,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "accounttype/edit";
        }
        accountType = accountTypeService.saveAccountType(accountType);
        return "redirect:/banking/accounttype/list";
    }

    @GetMapping(value = {"/banking/accounttype/delete/{accountTypeId}"})
    public String deleteAccountType(@PathVariable Integer accountTypeId, Model model) {
        accountTypeService.deleteAccountTypeById(accountTypeId);
        return "redirect:/banking/accounttype/list";
    }
}

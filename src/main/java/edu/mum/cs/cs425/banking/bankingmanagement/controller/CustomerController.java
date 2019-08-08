package edu.mum.cs.cs425.banking.bankingmanagement.controller;

import edu.mum.cs.cs425.banking.bankingmanagement.model.Customer;
import edu.mum.cs.cs425.banking.bankingmanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class CustomerController {

    //    @Autowired
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = {"/banking/customer/list"})
    public ModelAndView listCustomers(@RequestParam(defaultValue = "0") int pageno) {
        ModelAndView modelAndView = new ModelAndView();
        Page<Customer> customers = customerService.getAllCustomersPaged(pageno);
        modelAndView.addObject("customers", customers);
        modelAndView.addObject("customersCount", customers.getContent().size());
        modelAndView.addObject("currentPageNo", pageno);
        modelAndView.setViewName("customer/list");
        return modelAndView;
    }

    @GetMapping(value = {"/banking/customer/new"})
    public String displayNewStudentForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/new";
    }

    @PostMapping(value = {"/banking/customer/new"})
    public String addNewStudent(@Valid @ModelAttribute("customer") Customer customer,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "customer/new";
        }
        customer = customerService.saveCustomer(customer);
        return "redirect:/banking/customer/list";
    }

    @GetMapping(value = {"/banking/customer/edit/{customerId}"})
    public String editCustomer(@PathVariable Long customerId, Model model) {
        Customer customer = customerService.getCustomerById(customerId);
        if (customer != null) {
            model.addAttribute("customer", customer);
            return "customer/edit";
        }
        return "customer/list";
    }

    @PostMapping(value = {"/banking/customer/edit"})
    public String updateCustomer(@Valid @ModelAttribute("customer") Customer customer,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "customer/edit";
        }
        customer = customerService.saveCustomer(customer);
        return "redirect:/banking/customer/list";
    }

    @GetMapping(value = {"/banking/customer/delete/{customerId}"})
    public String deleteStudent(@PathVariable Long customerId, Model model) {
        customerService.deleteCustomerById(customerId);
        return "redirect:/banking/customer/list";
    }

    @RequestMapping(value = "/banking/customer/search", method = RequestMethod.GET)
    public ModelAndView searchCustomers(@RequestParam(value = "searchString", required = false) String searchString, @RequestParam(defaultValue = "0") int pageno, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        Page<Customer> customers = customerService.searchCustomers(searchString, pageno);
        modelAndView.addObject("customers", customers);
        modelAndView.addObject("searchString", searchString);
        modelAndView.addObject("customersCount", customers.getContent().size());
        modelAndView.addObject("currentPageNo", pageno);
        modelAndView.setViewName("customer/list");
        return modelAndView;
    }


}

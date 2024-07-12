package org.example.endmodule4.controller;



import org.example.endmodule4.model.SaleOff;
import org.example.endmodule4.service.SaleOffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/sale_off")
public class SaleOffController {
    @Autowired
    private SaleOffService saleOffService;

    @GetMapping("")
    public String showList(Model model) {
        Iterable<SaleOff> list = saleOffService.findAll();
        model.addAttribute("list",list);
        return "/sale_off/list";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("sale_off", new SaleOff());
        return "/sale_off/create";
    }
    @PostMapping("/create")
    public String save(@Validated @ModelAttribute SaleOff saleOff
            , BindingResult bindingResult
            , RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("message", saleOff);
            return "/sale_off/create";
        }
        saleOffService.save(saleOff);
        redirectAttributes.addFlashAttribute("messenger", "Lưu thành công");
        return "redirect:/sale_off";
    }

//    @GetMapping("/detail/{id}")
//    public String detail(@PathVariable("id") Long id, Model model) {
//        Optional<SaleOff> transactionDTO = saleOffService.findById(id);
//        if (transactionDTO.isEmpty()) {
//            model.addAttribute("messenger", "ko có đối tượng nào");
//            return "redirect:/sale_off";
//        }
//        model.addAttribute("transactionDTO", transactionDTO.get());
//        return "/transaction/detail";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
//        saleOffService.remove(id);
//        redirectAttributes.addFlashAttribute("messenger", " Xóa thành công");
//        return "redirect:/transaction";
//    }

//    @GetMapping("/search")
//    public String search(@RequestParam(defaultValue = "") String serviceType
//            , @RequestParam(defaultValue = "") String name, Model model) {
//        if (name == null && serviceType == null) {
//            return "redirect:/transaction";
//        }
//        Iterable<TransactionDTO> transactionDTOS = transactionService.showAll(name, serviceType);
//        model.addAttribute("name", name);
//        model.addAttribute("serviceType", serviceType);
//        model.addAttribute("transactionDTOS", transactionDTOS);
//        return "/transaction/search";
//    }
}

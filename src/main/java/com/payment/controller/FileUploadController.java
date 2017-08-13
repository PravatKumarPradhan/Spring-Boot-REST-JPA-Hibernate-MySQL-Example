package com.payment.controller;

import com.payment.entity.Customer;
import com.payment.entity.CustomerBillingInformation;
import com.payment.entity.CustomerPayment;
import com.payment.service.CustomerPaymentService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Gulam Mustafa
 */
@Controller
public class FileUploadController {

    @Autowired
    private CustomerPaymentService customerPaymentService;

    @PostMapping("/upload") // //new annotation since 4.3
    public ResponseEntity<List<CustomerPayment>>    singleFileUpload(@RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes) {
        List<CustomerPayment> list = null;
        if (file.isEmpty()) {
              return new ResponseEntity<List<CustomerPayment>>(list, HttpStatus.OK);
        }

        try {

            list = customerPaymentService.parse(file);
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }

         return new ResponseEntity<List<CustomerPayment>>(list, HttpStatus.OK);
    }

}

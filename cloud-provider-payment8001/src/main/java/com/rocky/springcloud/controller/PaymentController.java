package com.rocky.springcloud.controller;

import com.rocky.springcloud.entities.CommonResult;
import com.rocky.springcloud.entities.Payment;
import com.rocky.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult createPayment(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        if (result > 0) {
            return new CommonResult(200, "success", result);
        } else {
            return new CommonResult(444, "failed", result);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);

        if (payment != null) {
            return new CommonResult(200, "success", payment);
        } else {
            return new CommonResult(444, "failed", payment);
        }
    }
}

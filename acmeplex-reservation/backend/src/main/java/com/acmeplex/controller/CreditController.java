package com.acmeplex.controller;

import com.acmeplex.model.Credit;
import com.acmeplex.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credits")
public class CreditController {

    @Autowired
    private CreditService creditService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Credit>> getCreditsByUser(@PathVariable int userId) {
        return ResponseEntity.ok(creditService.getCreditsByUser(userId));
    }

    @PostMapping("/redeem")
    public ResponseEntity<String> redeemCredit(@RequestBody Credit credit) {
        creditService.redeemCredit(credit);
        return ResponseEntity.ok("Credit redeemed successfully.");
    }
}

package com.cm.app.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "credit-score-client", url = "https://l972noe55h.api.quickmocker.com/https://dummy.apincom")
public interface CreditScoreClient {

    @GetMapping("/creditscore/getcreditscore/{customerId}")
    CreditScoreResponse getCreditScore(@PathVariable("customerId") int customerId);
}

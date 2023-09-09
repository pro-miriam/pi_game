package org.sr4s.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.sr4s.domain.common.Response;
import org.sr4s.domain.dto.PurchaseDto;
import org.sr4s.domain.dto.PurchaseHistoryDto;
import org.sr4s.domain.entity.PurchaseHistory;
import org.sr4s.service.PurchaseHistoryService;
import org.sr4s.service.PurchaseService;

@RestController
@RequestMapping(value = "/api/v1/purchase")
@RequiredArgsConstructor
@Slf4j
public class PurchaseHistoryController {

    private final PurchaseHistoryService purchaseService;

    @PostMapping("/trx")
    public Response<Object> createUser(@RequestBody PurchaseHistoryDto dto) {
        return purchaseService.purchase(dto);
    }

}

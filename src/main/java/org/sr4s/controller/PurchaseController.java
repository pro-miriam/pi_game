package org.sr4s.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.sr4s.domain.common.Response;
import org.sr4s.domain.dto.PurchaseDto;
import org.sr4s.domain.dto.UserMasterDto;
import org.sr4s.domain.entity.Purchase;
import org.sr4s.service.PurchaseService;
import org.sr4s.service.UserService;

@RestController
@RequestMapping(value = "/api/v1/purchase")
@RequiredArgsConstructor
@Slf4j
public class PurchaseController {

    private final PurchaseService purchaseService;

    @PostMapping("/product")
    public Response<Object> createUser(@RequestBody PurchaseDto purchaseDto) {
        return purchaseService.purchase(purchaseDto);
    }

    @GetMapping("/list")
    public Response<Object> findByUserAndGoodsType(@RequestParam("userSeq") Long userSeq, @RequestParam("type") String goodsType) {
        return purchaseService.getPurchaseList(userSeq, goodsType);
    }

}

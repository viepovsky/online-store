package com.viepovsky.order;

import com.viepovsky.order.dto.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
class OrderController {

    private final OrderService orderService;

    @GetMapping
    ResponseEntity<List<OrderResponse>> getAllOrders(@RequestParam(name = "user-id") String userID) {
        return ResponseEntity.ok(orderService.getAllOrders(userID));
    }
}

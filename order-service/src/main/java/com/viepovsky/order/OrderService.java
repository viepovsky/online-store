package com.viepovsky.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class OrderService {

    private final OrderRepository orderRepository;

    List<Order> getAllOrders(String userID) {
        return orderRepository.findAllByUserId(userID);
    }
}

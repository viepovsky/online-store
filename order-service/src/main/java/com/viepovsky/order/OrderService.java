package com.viepovsky.order;

import com.viepovsky.order.dto.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class OrderService {

    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    List<OrderResponse> getAllOrders(String userID) {
        return orderRepository.findAllByUserId(userID)
                              .stream()
                              .map(orderMapper::mapToOrderResponse)
                              .toList();
    }
}

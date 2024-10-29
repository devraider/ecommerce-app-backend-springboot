package com.paul.ecommerce.dto;

import com.paul.ecommerce.entity.Address;
import com.paul.ecommerce.entity.Customer;
import com.paul.ecommerce.entity.Order;
import com.paul.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;

    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}

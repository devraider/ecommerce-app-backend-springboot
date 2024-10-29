package com.paul.ecommerce.service;

import com.paul.ecommerce.dto.PaymentInfo;
import com.paul.ecommerce.dto.Purchase;
import com.paul.ecommerce.dto.PurchaseResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);

    PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException;
}

package com.lab4.service;

import com.lab4.entity.CartItem;

import java.util.Collection;

public interface ShoppingCartService {
    public void add(CartItem item);

    void remove(Integer id);

    CartItem update(Integer id, int quantity);

    void clear();

    Collection<CartItem> getItems();

    Integer getCount();

    double getAmount();
}

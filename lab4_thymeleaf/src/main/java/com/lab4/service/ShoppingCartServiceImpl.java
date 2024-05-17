package com.lab4.service;

import com.lab4.entity.CartItem;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    Map<Integer, CartItem> map = new HashMap<>();

    @Override
    public void add(CartItem item) {
        CartItem cart_item = map.get(item.getId());
        if (cart_item == null) {
            map.put(item.getId(), item);
        } else {
            cart_item.setQuantity(cart_item.getQuantity() + 1); // Tăng số lượng nếu đã tồn tại
        }

    }

    @Override
    public void remove(Integer id) {
        map.remove(id);
    }

    @Override
    public CartItem update(Integer id, int quantity) {
        CartItem cart_item = map.get(id);
        cart_item.setQuantity(quantity);
        return cart_item;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Collection<CartItem> getItems() {
        return map.values();
    }

    @Override
    public Integer getCount() {
        return map.values().size();
    }

    @Override
    public double getAmount() {
        return map.values().stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
    }
}

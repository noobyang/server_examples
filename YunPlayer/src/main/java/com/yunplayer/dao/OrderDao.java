package com.yunplayer.dao;

import com.yunplayer.model.OrderModel;

import java.util.List;

public interface OrderDao {
	List<OrderModel> getAllOrders();
	OrderModel getOrder(String id);
	boolean addOrder(OrderModel orderModel);
	boolean updateOrder(String id, String name);
	boolean deleteOrder(String id);
}

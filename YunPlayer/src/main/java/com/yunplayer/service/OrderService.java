package com.yunplayer.service;

import com.yunplayer.dao.OrderDao;
import com.yunplayer.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderService {
	@Autowired
	private OrderDao orderDao;

	public List<OrderModel> getAllOrders(){
		return orderDao.getAllOrders();
	}

	public OrderModel getOrder(String id) {
		return orderDao.getOrder(id);
	}

	boolean addOrder(OrderModel userModel) {
		return orderDao.addOrder(userModel);
	}

	boolean updateOrder(String id, String name) {
		return orderDao.updateOrder(id, name);
	}

	boolean deleteOrder(String id) {
		return orderDao.deleteOrder(id);
	}
}

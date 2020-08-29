package com.yunplayer.controller;

import com.yunplayer.model.OrderModel;
import com.yunplayer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
	private OrderService orderService;
	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@RequestMapping(value="getAllOrders",method = RequestMethod.GET)
	@ResponseBody
	public List<OrderModel> getAllOrders() {
		List<OrderModel> orderModels = orderService.getAllOrders();
		return orderModels;
	}

	@RequestMapping(value="getOrder",method = RequestMethod.GET)
	@ResponseBody
	public OrderModel getOrder(String id) {
		OrderModel orderModel = orderService.getOrder(id);
		return orderModel;
	}
}

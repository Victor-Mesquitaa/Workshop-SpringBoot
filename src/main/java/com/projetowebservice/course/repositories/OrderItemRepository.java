package com.projetowebservice.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetowebservice.course.entities.OrderItem;
import com.projetowebservice.course.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
	

}

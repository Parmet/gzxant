package com.gzxant.service.car.booking.order;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.car.booking.order.CarBookingOrder;
import com.gzxant.dao.car.booking.order.CarBookingOrderDao;
import com.gzxant.service.car.booking.order.ICarBookingOrderService;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * 车辆预定订单 服务实现类
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-10
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CarBookingOrderService extends BaseService<CarBookingOrderDao, CarBookingOrder> implements ICarBookingOrderService {
	
}

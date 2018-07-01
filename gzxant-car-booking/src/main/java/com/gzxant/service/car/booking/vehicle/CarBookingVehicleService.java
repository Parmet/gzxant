package com.gzxant.service.car.booking.vehicle;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.car.booking.vehicle.CarBookingVehicle;
import com.gzxant.dao.car.booking.vehicle.CarBookingVehicleDao;
import com.gzxant.service.car.booking.vehicle.ICarBookingVehicleService;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * 车辆信息 服务实现类
 * </p>
 *
 * @author mojin
 * @since 2018-05-14
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CarBookingVehicleService extends BaseService<CarBookingVehicleDao, CarBookingVehicle> implements ICarBookingVehicleService {
	
}

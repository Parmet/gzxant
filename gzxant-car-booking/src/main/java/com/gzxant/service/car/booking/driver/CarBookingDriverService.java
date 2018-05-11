package com.gzxant.service.car.booking.driver;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.entity.car.booking.driver.CarBookingDriver;
import com.gzxant.dao.car.booking.driver.CarBookingDriverDao;
import com.gzxant.service.car.booking.driver.ICarBookingDriverService;
import com.gzxant.base.service.impl.BaseService;

/**
 * <p>
 * 司机信息 服务实现类
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-10
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class CarBookingDriverService extends BaseService<CarBookingDriverDao, CarBookingDriver> implements ICarBookingDriverService {
	
}

package com.gzxant.service.qualification;

import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.gzxant.base.service.impl.BaseService;
import com.gzxant.dao.qualification.QualificationDao;
import com.gzxant.entity.qualification.Qualification;

/**
 * <p>
 * 资格认证 服务实现类
 * </p>
 *
 * @author zt
 * @since 2018-05-18
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class QualificationService extends BaseService<QualificationDao, Qualification> implements IQualificationService {


    @Override
    @Transactional(readOnly = false)
    public void qualification(Qualification param) {
        // 1. 前缀
        String sb="N";
        
        // 2. 从609545开始自增，数据库第一条数据为N609545
        Long start = 123L;
        
        // 3. 去数据库中已通过数据的数量
        EntityWrapper<Qualification> ew = new EntityWrapper<>();
        ew.setEntity(new Qualification());
        ew.where("state='Y'");
        Integer count = this.baseMapper.selectCount(ew);
        if (count == null) {
        	count = 0;
        }
        
        sb = sb + String.valueOf(start.longValue() + count.longValue());
        param.setCode(sb);
        //保存认证人信息
        baseMapper.updateById(param);
    }

    @Override
    public Qualification selectByCode(String param) {
        Qualification qualification = baseMapper.selectByCode(param);

        return qualification;
    }

    @Override
    public Qualification selectByPhone(String phone) {
        return baseMapper.selectByPhone(phone);
    }


    //根据指定长度生成字母和数字的随机数
    //0~9的ASCII为48~57
    //A~Z的ASCII为65~90
    //a~z的ASCII为97~122
    public  static String randomNumber(int leng) {
        StringBuilder sb=new StringBuilder();
        sb.append("N");
        Random rand=new Random();//随机用以下三个随机生成器
        Random randdata=new Random();
        int data=0;
        for(int i=0;i<leng;i++)
        {
            int index=rand.nextInt(3);
            //目的是随机选择生成数字，大小写字母
            switch(index)
            {
                case 0:
                    data=randdata.nextInt(10);//仅仅会生成0~9
                    sb.append(data);
                    break;
//                case 1:
//                    data=randdata.nextInt(26)+65;//保证只会产生65~90之间的整数
//                    sb.append((char)data);
//                    break;
//                case 2:
//                    data=randdata.nextInt(26)+97;//保证只会产生97~122之间的整数
//                    sb.append((char)data);
//                    break;
            }
        }
        String result=sb.toString();
        return result;
    }


    public static void main(String[] args) {
        String sb="N";
        int intFlag = (int)(Math.random() * 1000000);
        sb +=intFlag;
        System.out.println(sb);
    }
}

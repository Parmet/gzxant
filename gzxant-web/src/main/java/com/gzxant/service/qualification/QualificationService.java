package com.gzxant.service.qualification;

import com.gzxant.base.service.impl.BaseService;
import com.gzxant.dao.qualification.QualificationDao;
import com.gzxant.entity.qualification.Qualification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

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
        //随机生成指定位数,字母加数字,加大小写   开头为大写N:然后随机生成6位
        String sb="N";
        //随机生成6位
        int intFlag = (int)(Math.random() * 1000000);
        sb +=intFlag;

        param.setCode(sb);
        //保存认证人信息
        baseMapper.updateById(param);
    }

    @Override
    public Qualification selectByCode(String param) {
        Qualification qualification = baseMapper.selectByCode(param);

        return qualification;
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

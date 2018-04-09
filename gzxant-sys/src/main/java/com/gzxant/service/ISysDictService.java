package com.gzxant.service;

import com.baomidou.mybatisplus.service.IService;
import com.gzxant.base.service.IBaseService;
import com.gzxant.base.vo.JsTree;
import com.gzxant.base.vo.PCAjaxVO;
import com.gzxant.entity.SysDict;

import java.util.List;

/**
 *
 * @author chen
 * @date 2017/9/21
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe: 系統数据字典
 */
public interface ISysDictService extends IBaseService<SysDict> {

    void insert(String dicKey, String dicValue, Long dicPid, String type, String desc, String sort, String invalid, String path);

    boolean update(Long id, String dicKey, String dicValue, String type, String desc, String sort, String invalid);

    List<JsTree> getDictTree();


     PCAjaxVO delete(Long id);


}

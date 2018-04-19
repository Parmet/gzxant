<#assign package><#list names as name><#if (name_index < names?size)>${name}.</#if></#list></#assign>
<#assign className><#list names as name>${name?cap_first}</#list></#assign>
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.base.service.impl.BaseService;
import com.gzxant.${package}${className}Dao;
import com.gzxant.${package}${className};
import com.gzxant.service.${package}I${className}Service;

/**
 * ${chinese} Service
 * 
 * @author ${author?if_exists}
 * @date ${.now?string("yyyy-MM-dd")}
 * @describe: ${chinese} Service
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ${className}Service extends BaseService<${className}Dao, ${className}> 
	implements I${className}Service {

	
}

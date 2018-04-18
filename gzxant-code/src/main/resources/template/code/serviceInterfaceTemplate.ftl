<#assign package><#list names as name><#if (name_index < names?size)>${name}.</#if></#list></#assign>
<#assign className><#list names as name>${name?cap_first}</#list></#assign>
import com.gzxant.base.service.IBaseService;
import com.gzxant.entity.${package}${className};

/**
 * ${chinese} Service Interface
 * 
 * @author ${author?if_exists}
 * @date ${.now?string("yyyy-MM-dd")}
 * @describe: ${chinese} Service Interface
 */
public interface I${className}Service extends IBaseService<${className}> {

}

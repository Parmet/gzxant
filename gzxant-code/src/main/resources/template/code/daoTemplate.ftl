<#assign package><#list names as name><#if (name_index < names?size)>${name}.</#if></#list></#assign>
<#assign className><#list names as name>${name?cap_first}</#list></#assign>
<#assign tableName><#list names as name>${name}_</#list></#assign>
import com.gzxant.base.dao.CrudDao;
import com.gzxant.entity.${package}${className};

/**
 * ${chinese} Dao
 * 
 * @author ${author?if_exists}
 * @date ${.now?string("yyyy-MM-dd")}
 * @describe: ${chinese} Dao
 */
public interface ${className}Dao extends <#if type?? && (type=='crud')>CrudDao<#else>BaseDao</#if><${className}> {

}

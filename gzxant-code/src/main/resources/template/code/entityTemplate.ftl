<#assign package><#list names as name><#if (name_index < names?size)>${name}.</#if></#list></#assign>
<#assign className><#list names as name>${name?cap_first}</#list></#assign>
<#assign tableName><#list names as name><#if (name_index < names?size)>${name}_<#else>${name}</#if></#list></#assign>
import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.gzxant.base.entity.DataEntity;
import com.gzxant.entity.${package}${className};

@TableName("${tableName}")
public interface ${className}Dao extends CrudDao<${className}> {

	<#list columnMap?keys as key>
	private String ${key};
	</#list>
	<#list columnMap?keys as key>

	public String get${key?cap_first}() {
			return ${key};
    }
    
	public void set${key?cap_first}(String ${key}) {
			this.${key} = ${key};
    }
	</#list>

	@Override
    protected Serializable pkVal() {
        return this.id;
    }
}

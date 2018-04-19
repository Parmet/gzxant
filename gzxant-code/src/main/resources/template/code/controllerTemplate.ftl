package ${package.Controller};

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gzxant.annotation.SLog;
import com.gzxant.base.controller.BaseController;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import ${package.entity}.${table.entityName};
import ${package.service}.${table.serviceName};
import com.gzxant.util.ReturnDTOUtil;

import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * ${table.comment}  前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Controller
@RequestMapping("#if(${package.ModuleName})/${package.ModuleName}#end/${table.entityName.toLowerCase()}")
public class ${table.controllerName} extends BaseController  {
	@Autowired
    private ${table.serviceName} ${table.serviceName};

	@ApiOperation(value = "进入${table.comment}列表界面", notes = "进入${table.comment}列表界面")
    @GetMapping(value = "")
    public String list(Model model) {
        return "#if(${package.ModuleName})/${package.ModuleName}#end/${table.entityName.toLowerCase()}/list";
    }

	/**
	 * 进入${table.comment}详情增改界面
	 * 
	 * @param model 
	 * @param request 
	 * @param action ['insert', 'edit', 'view']操作
	 */
    @ApiOperation(value = "进入${table.comment}详情增改界面", notes = "进入${table.comment}详情增改界面")
    @GetMapping(value = "/detail/{action}")
    public String createOrUpdate(@PathVariable("action") String action, Model model) {
        model.addAttribute("action", action);
        return "#if(${package.ModuleName})/${package.ModuleName}#end/${table.entityName.toLowerCase()}/detail";
    }
    
	/**
	 * 获取${table.comment}列表数据
	 * 
	 * @param dt 分页信息
	 */
    @ApiOperation(value = "获取${table.comment}列表数据", notes = "获取${table.comment}列表数据:使用约定的DataTable")
    @PostMapping(value = "/list")
    @ResponseBody
    public DataTable<${table.name}> list(@RequestBody DataTable<${table.name}> dt) {
        return ${table.serviceName}.pageSearch(dt);
    }
    
    @ApiOperation(value = "添加${table.comment}", notes = "添加${table.comment}")
    @PostMapping(value = "/insert")
    @ResponseBody
    public ReturnDTO create(${table.name} ${table.name?uncap_first}) {
    	${table.serviceName}.insert(${table.name?uncap_first});
        return ReturnDTOUtil.success();
    }
    
    @ApiOperation(value = "修改${table.comment}", notes = "修改${table.comment}")
    @PostMapping(value = "/update")
    @ResponseBody
    public ReturnDTO update(${table.name} ${table.name?uncap_first) {
    	${table.serviceName}.update(${table.name?uncap_first});
        return ReturnDTOUtil.success();
    }

    @SLog("批量删除${table.comment}")
    @ApiOperation(value = "批量删除${table.comment}", notes = "批量删除${table.comment}")
    @PostMapping(value = "/delete")
    @ResponseBody
    public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
        boolean success = ${table.serviceName}.deleteBatchIds(ids);
        if (success) {
            return ReturnDTOUtil.success();
        }
        return ReturnDTOUtil.fail();

    }
}

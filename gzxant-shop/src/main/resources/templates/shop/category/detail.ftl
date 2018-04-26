<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <form class="form-horizontal form-bordered" id="gzxantForm">
            	<input type="hidden" name="id" value="${category.id}" />
            	<div class="form-group">
                    <label class="col-sm-3 control-label">图标</label>
                    <div class="col-sm-3">
                    	<div id="localImag" style="margin-left:15px;">
                            <div class="img_box" id="imgBox">
                            	<!-- 图片上传插件识别 <div class="img_box" id="imgBox">
                            		下的input标签，将上传图片在服务器保存的路径存放到input的value属性中 -->
				            	<input type="hidden" name="icon" value="${category.icon}" />
                                <img id="imgshowdiv" style="width: 60px" src="${rc.contextPath}${category.icon}"
                                     onerror="javascript:errimg()" class="img_file img-rounded"/>
                            </div>
                        </div>
                    </div>
                    <#if action !='detail'>
                    <!-- 文件上传插件 -->
                    <#include "plus/file-upload.ftl">
               		</#if>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">父分类<span class="required">*</span></label>
                    <div class="col-sm-6">
                        <select class="select2" name="parentId" required aria-required="true">
					    <#if categoryTree??>
					    <#list categoryTree as r>
					    <option value="${r.id}" <#if (r.id == category.parentId)>selected</#if>>${r.name}</option>
					    </#list>
					    <#else>
					    <option value="0" selected>顶级分类</option>
					    </#if>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">分类名称<span class="required">*</span></label>
                    <div class="col-sm-3">
                    	<input type="text" class="form-control" name="name" placeholder="请输入分类名称"
                               value="${category.name}" required aria-required="true"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">排序</label>
                    <div class="col-sm-3">
                    	<input type="number" class="form-control" name="sort" placeholder="0"
                               value="${category.sort}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">备注</label>
                    <div class="col-sm-6">
                    	<input type="text" class="form-control" name="remark" placeholder="请输入备注"
                               value="${category.remark}"/>
                    </div>
                </div>
                
            </form>

		</div>
	</div>
</div>


<script type="text/javascript">
	action = "${action}";
    function  cusFunction() {
        //console.info("提交之前，最后执行自定义的函数");
    }
    
    <#if action !='detail'>
    // 初始化文件上传插件(file-upload.ftl ==> initFileUpload())
    initFileUpload("shop_category_icon", "${category.icon}");
	</#if>

    // --------------------------form表单验证-------------------------------------------------- //
    var form = $('#gzxantForm');
    var error = $('.alert-danger', form);
    form.validate({
        errorElement: 'span',
        errorClass: 'error',
        focusInvalid: true,
        rules: {
        	parentId: {
                required: true,
            },
            name: {
                required: true
            }
        }
    });

</script>
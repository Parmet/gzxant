<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <form class="form-horizontal form-bordered" id="gzxantForm">
            	<input type="hidden" name="id" value="${shopProducts.id}" />

                <div class="form-group">
                    <label class="col-sm-3 control-label">产品的名称<span class="required">*</span></label>
                    <div class="col-sm-3">
                    	<input type="text" class="form-control" name="name" placeholder="请输入产品的名称"
                               value="${shopProducts.name}" required aria-required="true"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">合计总数</label>
                    <div class="col-sm-6">
                    	<input type="text" class="form-control" name="totalStock" placeholder="请输入产品的分类"
                               value="${shopProducts.totalStock}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">剩余的总数</label>
                    <div class="col-sm-6">
                    	<input type="text" class="form-control" name="ableStock" placeholder="请输入产品的品牌"
                               value="${shopProducts.ableStock}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">冻结的总数</label>
                    <div class="col-sm-6">
                    	<input type="text" class="form-control" name="freezeStock" placeholder="请输入产品的品牌"
                               value="${shopProducts.freezeStock}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">存储过期</label>
                    <div class="col-sm-6">
                    	<input type="text" class="form-control" name="overStock" placeholder="请输入产品的品牌"
                               value="${shopProducts.overStock}"/>
                    </div>
                </div>

            	<#if action != 'detail'>
                <div class="form-actions fluid">
                    <div class="col-sm-12">
                        <button type="button" onclick="saveForm()" class="btn btn-success btn-block m-t-25">保存</button>
                    </div>
                </div>
            	</#if>
            </form>

		</div>
        <table class="table" id="exampleTable" data-mobile-responsive="true">
        </table>
	</div>
</div>


<script type="text/javascript">
	action = "${action}";
    function  cusFunction() {
        //console.info("提交之前，最后执行自定义的函数");
    }

  	// --------------------------错误图片的默认处理-------------------------------------------------- //
    function errimg() {
        $("#photo").val("${rc.contextPath}/img/log9.png");
        $("#imgshowdiv").attr('src', "${rc.contextPath}/img/log9.png");
    }

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
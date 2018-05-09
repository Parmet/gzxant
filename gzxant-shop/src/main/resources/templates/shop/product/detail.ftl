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
                    <label class="col-sm-3 control-label">产品的分类</label>
                    <div class="col-sm-6">
                    	<input type="text" class="form-control" name="categoryId" placeholder="请输入产品的分类"
                               value="${shopProducts.categoryId}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">产品的品牌</label>
                    <div class="col-sm-6">
                    	<input type="text" class="form-control" name="brandId" placeholder="请输入产品的品牌"
                               value="${shopProducts.brandId}"/>
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

    function getcolumns() {
        var c = [
            {
                checkbox: true
            },
            {
                field: 'productId', // 列字段名
                title: '产品spu属性' // 列标题
            },
            {
                field: 'spuId',
                title: '产品的spu'
            },
            {
                field: 'sort',
                title: 'spu的种类'
            },
            {
                title: '操作',
                field: 'spuId',
                align: 'center',
                formatter: function (value, row, index) {
                    return dt_edit_button(row)+dt_detail_button(row)+dt_delete_button(row);
                }
            }];

        return c;
    }

    load_data( getcolumns(), {});

</script>
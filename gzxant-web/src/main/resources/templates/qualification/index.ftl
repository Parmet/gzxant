<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <form class="form-horizontal form-bordered" id="gzxantForm">


                <div class="form-group">
                    <label class="col-sm-3 control-label">姓名<span class="required">*</span></label>
                    <div class="col-sm-3">
                    	<input type="text" class="form-control" name="name" placeholder="请输入姓名"
                                required aria-required="true"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">电话<span class="required">*</span></label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="phone" placeholder="请输入电话"
                                required aria-required="true"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">企业<span class="required">*</span></label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="enterprise" placeholder="请输入企业"
                               required aria-required="true"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">身份证号码<span class="required">*</span></label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="card" placeholder="请输入身份证号码"
                                required aria-required="true"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">邮箱<span class="required">*</span></label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="email" placeholder="请输入邮箱"
                                required aria-required="true"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">目前经营的品牌或代理<span class="required">*</span></label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" name="brandAgent" placeholder="请输入目前经营的品牌或代理"
                                required aria-required="true"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">省份<span class="required">*</span></label>

                    <#--<div class="col-sm-3">-->
                        <#--<input type="text" class="form-control" name="provinces" placeholder="请输入省份"-->
                                <#--required aria-required="true"/>-->
                    <#--</div>-->


                    <div style="position: relative;" class="col-sm-3"><!-- container -->
                        <input readonly type="text" data-toggle="city-picker" class="form-control" name="provinces"  required aria-required="true"/>
                    </div>
                </div>


                <div class="form-actions fluid">
                    <div class="col-sm-12">
                        <button type="button" onclick="saveForm2()" class="btn btn-success btn-block m-t-25">提交</button>
                    </div>
                </div>
            </form>

		</div>
	</div>
</div>

<link rel="stylesheet" type="text/css" href="${rc.contextPath}/dist/css/city-picker.css"/>
<script src="${rc.contextPath}/dist/js/city-picker.data.js"></script>
<script src="${rc.contextPath}/dist/js/city-picker.js"></script>


<script type="text/javascript">
	action = "${action}";
    function  cusFunction() {
        //console.info("提交之前，最后执行自定义的函数");
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
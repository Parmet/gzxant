<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <form class="form-horizontal form-bordered" id="gzxantForm">


                <div class="form-group">
                    <label class="col-sm-3 control-label">授权编号<span class="required">*</span></label>
                    <div class="col-sm-3">
                    	<input type="text" class="form-control" name="code" placeholder="请输入授权编号"
                                required aria-required="true"/>
                    </div>
                </div>

                <div class="form-actions fluid">
                    <div class="col-sm-12">
                        <button type="button" onclick="saveForm3()" class="btn btn-success btn-block m-t-25">提交</button>
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
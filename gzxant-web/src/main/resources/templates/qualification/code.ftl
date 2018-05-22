
<#assign base=rc.contextPath />
<#assign url=rc.requestUri />
<!DOCTYPE html>
<html>
<head>
    <link rel="shortcut icon" href="${rc.contextPath}/favicon.ico">
    <link href="${rc.contextPath}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${rc.contextPath}/css/font-awesome.min.css?v=4.4.0" rel="stylesheet"/>
    <link href="${rc.contextPath}/css/animate.css" rel="stylesheet"/>
    <link href="${rc.contextPath}/css/style.css?v=4.1.0" rel="stylesheet"/>
    <link href="${rc.contextPath}/css/gzxant.css" rel="stylesheet"/>
    <link href="${rc.contextPath}/css/plugins/select2/select2.css" rel="stylesheet">
    <link href="${rc.contextPath}/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">

    <script>
        var base_url ="${rc.contextPath}";
        var url = "${rc.requestUri}" + "/",  action = "${action}";
    </script>

    <script src="${rc.contextPath}/js/jquery.min.js?v=2.1.4"></script>
    <script src="${rc.contextPath}/js/bootstrap.min.js?v=3.3.6"></script>

    <script src="${rc.contextPath}/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="${rc.contextPath}/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="${rc.contextPath}/js/plugins/layer/layer.min.js"></script>

    <script src="${rc.contextPath}/js/hplus.js?v=4.1.0"></script>
    <script type="text/javascript" src="${rc.contextPath}/js/contabs.js"></script>

    <script src="${rc.contextPath}/js/websocket/sockjs.min.js" type="text/javascript"></script>
    <script src="${rc.contextPath}/js/websocket/stomp.min.js" type="text/javascript"></script>
    <script src="${rc.contextPath}/js/websocket/sliescoket.js" type="text/javascript"></script>
    <script src="${rc.contextPath}/js/plugins/select2/select2.min.js"></script>
    <script src="${rc.contextPath}/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="${rc.contextPath}/js/plugins/validate/messages_zh.min.js"></script>
    <script src="${rc.contextPath}/js/gzxant/datatable.js"></script>
    <script src="${rc.contextPath}/js/gzxant/gzxantform.js"></script>
    <script src="${rc.contextPath}/js/jquery.form.js"></script>
    <script src="${rc.contextPath}/js/util/validate-util.js"></script>
    <!-- Bootstrap table -->
    <script src="${rc.contextPath}/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
    <script src="${rc.contextPath}/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
    <script src="${rc.contextPath}/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>


    <script src="${rc.contextPath}/js/plugins/pace/pace.min.js"></script>
    <script src="${rc.contextPath}/js/gzxant/gzxant.js"></script>



    <link rel="stylesheet" type="text/css" href="${rc.contextPath}/dist/css/city-picker.css"/>
    <script src="${rc.contextPath}/dist/js/city-picker.data.js"></script>
    <script src="${rc.contextPath}/dist/js/city-picker.js"></script>

</head>

<body>
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
                        <button type="submit"  class="btn btn-success btn-block m-t-25">提交</button>
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
            code: {
                required: true
            }
        }
    });

</script>
</body>
<html>
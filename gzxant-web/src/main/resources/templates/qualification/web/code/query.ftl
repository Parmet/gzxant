<!DOCTYPE html>
<html>
<head>
<title>资质认领</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="${rc.contextPath}/favicon.ico">
<link href="${rc.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${rc.contextPath}/css/font-awesome.min.css?v=4.4.0"
	rel="stylesheet" />
<link href="${rc.contextPath}/css/animate.css" rel="stylesheet" />
<link href="${rc.contextPath}/css/gzxant.css" rel="stylesheet" />
<link href="${rc.contextPath}/css/plugins/select2/select2.css"
	rel="stylesheet">
<script>
        var base_url ="${rc.contextPath}";
        var url = "${rc.requestUri}" + "/",  action = "${action}";
    </script>

<script src="${rc.contextPath}/js/jquery.min.js"></script>
<script src="${rc.contextPath}/js/bootstrap.min.js"></script>

<script src="${rc.contextPath}/js/plugins/layer/layer.min.js"></script>

<script
	src="${rc.contextPath}/js/plugins/validate/jquery.validate.min.js"></script>
<script src="${rc.contextPath}/js/plugins/validate/messages_zh.min.js"></script>
<script src="${rc.contextPath}/js/gzxant/gzxantform.js"></script>
<script src="${rc.contextPath}/js/jquery.form.js"></script>
<script src="${rc.contextPath}/js/util/validate-util.js"></script>
<script src="${rc.contextPath}/js/gzxant/gzxant.js"></script>

<link rel="stylesheet" type="text/css"
	href="${rc.contextPath}/plugins/dist/css/city-picker.css" />
<script src="${rc.contextPath}/plugins/dist/js/city-picker.data.js"></script>
<script src="${rc.contextPath}/plugins/dist/js/city-picker.js"></script>

<style type="text/css">
.code-content {
	background-color: #ac5537;
	padding: 20px;
	border-radius: 10px;
}

.control-label {
	color: white;
}
</style>
</head>

<body>
	<div class="container-fluid"
		style="background-color: aliceblue; padding: 10px;">
		<div class="code-content">
			<div class="row">
				<div class="col-sm-12">
					<div class="form-group">
						<label class="control-label">授权编号（区分大小写）</label>
						<input type="text" class="form-control" name="code" id="name"
							placeholder="请输入授权编号" required aria-required="true" />
					</div>
				</div>
				
				<div class="col-sm-12">
					<button onclick="queryCode()" class="btn btn-info btn-block">查询</button>
				</div>
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

    function queryCode() {
    	window.location.href = "${rc.contextPath}" + "/code/detail/" + $("#name").val();
    }
</script>
</body>
</html>
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


.align-center{
    margin:0 auto; /* 居中 这个是必须的，，其它的属性非必须 */
    width:500px; /* 给个宽度 顶到浏览器的两边就看不出居中效果了 */
    text-align:center; /* 文字等内容居中 */
}
</style>
</head>

<body>
	<div class="container-fluid"
		style="background-color: #ac5537; ">
		<div class="code-content" >
            <div class="align-center" style="margin-bottom:20px;">
                <img src="${rc.contextPath}/img/logo.jpg" height="90" width="90">
            </div >
            <div class="align-center" style="margin-top:20px;">
                <strong> <p style="font-size: 20px;" ><font color="#f0f8ff">藏神学院官方授权查询平台</font></p></strong>
            </div>
		</div>
    </div>


    <div class="container-fluid"
         style="background-color: #C1C1C1;">
        <div class="row">
             <div class="form-group align-center" style="margin-top:30px;">
                   <label class="control-label"><font color="#545454">授权编号（区分大小写）</font></label>
                     <input type="text" class="form-control" name="code" id="name"
                            placeholder="请输入授权编号" required aria-required="true" />
            </div>
            <div class="align-center" style="margin-top:60px;">
                <button onclick="queryCode()" class="btn btn-info btn-block align-center" style="width:140px;height:40px;">查询</button>
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
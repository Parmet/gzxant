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
	background-color: #b40202;
	padding: 20px;
}

.control-label {
	color: white;
}

.align-center{
    margin:0 auto; /* 居中 这个是必须的，，其它的属性非必须 */
    text-align:center; /* 文字等内容居中 */
}
</style>
</head>

<body style="background-color: #f0f0f0">
	<div class="code-content" >
       <div class="align-center" style="margin-bottom:20px;">
           <img src="${rc.contextPath}/img/logo.png" height="170" width="170">
       </div >
       <div class="align-center" style="margin-top:20px;font-size: 40px;">
           <strong><font color="#f0f8ff">藏灸学院官方授权查询平台</font></strong>
       </div>
	</div>

	<form id="gzxantForm">
		<div class="container-fluid">
		    <div class="form-group align-center" style="margin-top:30px;">
		           <label class="control-label"><font color="#545454">授权编号（区分大小写）</font></label>
		             <input type="text" class="form-control align-center" name="code" id="name"
		                    placeholder="请输入授权编号" required aria-required="true" value="${code}" style="width:700px; height: 70px;font-size: 38px;"/>
		    </div>
		    <div class="align-center" style="margin-top:60px;">
		        <button type="submit" class="btn btn-info btn-block align-center" style="background-color: #b40202;width:300px;">查询</button>
		    </div>

            <div class="align-center" style="margin-top:40px;font-size: 20px;">
                <font>说明：“藏灸” 技术治疗服务中心官方授权查询页面 </font><br>
                广州藏灸文化研究有限公司
            </div>
	    </div>
    </form>

	<script type="text/javascript">
	action = "${action}";
    function  cusFunction() {
        //console.info("提交之前，最后执行自定义的函数");
    }
	
    var msg = "${msg}";
    if (msg != "") {
    	layer.msg(msg);
    }

    // --------------------------form表单验证-------------------------------------------------- //
    var form = $('#gzxantForm');
    var error = $('.alert-danger', form);
    form.validate({
        errorElement: 'span',
        errorClass: 'error',
        focusInvalid: true,
        rules: {
            code: {
                required: true
            }
        },
        submitHandler: function () {
        	queryCode();
        }
    });

    function queryCode() {
    	window.location.href = "${rc.contextPath}" + "/code/detail/" + $("#name").val();
    }
</script>
</body>
</html>
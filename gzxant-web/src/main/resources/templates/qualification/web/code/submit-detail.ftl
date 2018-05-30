<!DOCTYPE html>
<html>
<head>
<title>藏灸技术资质认领</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="${rc.contextPath}/favicon.ico">
<link href="${rc.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
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
html, body {
	width: 100%;
}

body {
	background: url(${rc.contextPath}/img/medicine/bg1.jpg);
	background-size: cover;
	background-repeat: no-repeat;
}

.code-head {
	background-color: #a40001;
	padding: 20px;
}

.code-content {
	background-color: #ffffff;
	border-radius: 20px;
	width: 80%;
	margin: 40px auto;
	padding: 20px;
}

.form-content label {
	color: black;
}

.align-center{
    margin:0 auto; /* 居中 这个是必须的，，其它的属性非必须 */
    text-align:center; /* 文字等内容居中 */
}

.modal-box {
	background-color: #EAEAEA;
	background-size: cover;
	position: absolute;
	opacity: 0.7;
	width: 100%;
	height: 100vh;
	z-index: -2;
}
</style>
</head>

<body>
	<div class="modal-box"></div>
	<div class="code-head" >
       <div class="align-center" style="margin-bottom:20px;">
           <img src="${rc.contextPath}/img/medicine/logo.png" height="90" width="90">
       </div >
       <div class="align-center" style="margin-top:20px;font-size: 20px;">
           <strong><font color="#f0f8ff">藏灸学院官方授权查询平台</font></strong>
       </div>
	</div>

	<div class="container-fluid code-content">
		<div class="content-modal"></div>
		<label>姓名：</label> 
		<label style="margin-left: 30px;">${qualification.name}</label>
		<br />
		<br />
		<label>企业：</label>
		<label style="margin-left: 30px;">${qualification.enterprise}</label>
	</div>

	<p class="align-center" style="font-size: 12px; margin-top: 30px;">说明：该企业已获得“藏灸”技术治疗服务中心官方授权！</p>
	<p class="align-center" style="font-size: 12px;">广州藏灸文化研究有限公司</p>

	<div class="align-center" style="margin-top: 60px;">
		<button type="button" onclick="back();" class="btn btn-info align-center"
			style="background-color: #a40001; border-color: #a40001; width: 50%">返回</button>
	</div>

	<script type="text/javascript">
	action = "${action}";
    function  cusFunction() {
        //console.info("提交之前，最后执行自定义的函数");
    }

    function back() {
    	window.history.back();
    }
    
</script>
</body>
</html>
<!DOCTYPE html>
<html>
<head>
<title>资质认领</title>
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
	background: url(${rc.contextPath}/img/medicine/bg0.jpg);
	background-size: auto;
	background-repeat: no-repeat;
}

.code-content {
	background-color: #ac5537;
	padding: 20px;
	border-radius: 10px;
	opacity: 0.9;
	box-shadow: 5px 5px 5px #888888;
}

.form-content label {
	color: white;
}
</style>
</head>

<body>
	<div class="container-fluid"
		style="padding: 10px;">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 " style="text-align: center;">
				<img src="${rc.contextPath}/img/medicine/yp_logo.png" style="width: 200px; height: 188px; margin: 0 auto;"/>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 ">
				<p style="font-size: 12px;">
					<b>说明：</b><span style="color:darkgray;">广州藏灸文化研究有限公司“藏灸”技术治疗服务中心官方认证页面</span>
				</p>
			</div>
		</div>
		<form class="code-content form-horizontal" id="gzxantForm">
			<div class="form-group">
				<label for="nameLabel" class="col-sm-2 control-label" style="color: white;">姓名</label>
				<div class="col-sm-10">
					<label id="nameLabel" style="font-weight:200">${qualification.name}</label>
				</div>
			</div>
			
			<div class="form-group">
				<label for="enterpriseLabel" class="col-sm-2 control-label" style="color: white;">企业</label>
				<div class="col-sm-10">
					<label id="enterpriseLabel" style="font-weight:200">${qualification.enterprise}</label>
				</div>
			</div>
			
			<div style="width: 100%; position: fixed; bottom: 5px; left:0;">
				<button type="button" onclick="back();" style="margin: 0 auto; width: 80%" class="btn btn-info btn-block">返回</button>
			</div>
		</form>
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
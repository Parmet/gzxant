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

/*body {*/
    /*background-size: cover;*/
    /*background-repeat: no-repeat;*/
    /*content: "";*/
    /*position: absolute;*/
    /*top: 0;*/
    /*left: 0;*/
    /*z-index: -1;!*-1 可以当背景*!*/
    /*-webkit-filter: blur(3px);*/
    /*filter: blur(3px);
    <#--style="background: url('${rc.contextPath}/img/medicine/bg0.jpg') no-repeat; background-size:100% 100%;"-->

    */
/*}*/
#box{
    width:200px;
    height:200px;
    background:url(${rc.contextPath}/img/medicine/bg0.jpg);
    opacity:0.5;
    filter:"alpha(opacity=50)";
    -ms-filter:"alpha(opacity=50)"; /* 旧版IE */
}







.code-content {
	background-color: #ffffff;

	padding: 20px;
	border-radius: 10px;
	opacity: 0.9;
	box-shadow: 5px 5px 5px #888888;
	width: 600px;
	height: 300px;

}

.form-content label {
	color: white;
}

.align-center{
    margin:0 auto; /* 居中 这个是必须的，，其它的属性非必须 */
    text-align:center; /* 文字等内容居中 */
}
</style>
</head>

<body  style="background: url('${rc.contextPath}/img/medicine/bg0.jpg') no-repeat;
		background-size:100% 150%; background-repeat:repeat;">


<div class="container-fluid"
		style="padding: 10px;">

        <div class="row" style="background-color: #b40202">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 " style="text-align: center;">
                <img src="${rc.contextPath}/img/logo.png" style="width: 200px; height: 188px; margin: 0 auto;"/>
            </div>
            <div class="align-center" style="margin-top:50px;font-size: 40px;">
                <strong><font color="#f0f8ff">藏灸学院官方授权查询平台</font></strong>
            </div>
        </div>
		<br>
		<br>
		<br>

		<form class="code-content form-horizontal align-center"  id="gzxantForm">
            <br>
            <br>
			<div class="form-group align-center">
				<label for="nameLabel" class="col-sm-2 control-label" style="color: black;">姓名:</label>
				<div class="col-sm-10">
					<label id="nameLabel" style="font-weight:200" class="align-center">${qualification.name}</label>
				</div>
			</div>
            <br>
            <br>
			<div class="form-group align-center">
				<label for="enterpriseLabel" class="col-sm-2 control-label" style="color: black;">企业:</label>
				<div class="col-sm-10">
					<label id="enterpriseLabel" style="font-weight:200" class="align-center">${qualification.enterprise}</label>
				</div>
			</div>


            <div class="align-center" style="margin-top:140px;font-size: 20px; color: black">
                <font>说明：该企业已获得 “藏灸” 技术治疗服务中心官方授权!</font><br>
                广州藏灸文化研究有限公司
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
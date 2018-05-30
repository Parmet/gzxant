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

.code-content {
	background-color: #a40001;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 5px 5px 5px #888888;
}

.form-content label {
	color: white;
}

.logo-box {
	/* background-color: #b40202; */
	background-color: #a40001;
}

.modal-box {
	background-color: #EAEAEA;
	background-size: cover;
	position: absolute;
	opacity: 0.7;
	width: 100%;
	height: 125vh;
	z-index: -1;
}
</style>
</head>

<body>
	<div class="modal-box"></div>
	<div class="container-fluid text-center">
		<div class="row logo-box">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 " style="text-align: center;">
				<img src="${rc.contextPath}/img/medicine/yp_logo.png" style="width: 200px; height: 188px; margin: 0 auto;"/>
			</div>
		</div>
		<p style="font-size: 12px; margin-top: 10px;">说明：“藏灸”技术治疗服务中心官方资质认领页面</p>
		<p style="font-size: 12px;">广州藏灸文化研究有限公司</p>
		<div class="row">
			<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
			<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
				
				<form id="gzxantForm">
					<div class="code-content">
						<div class="form-group">
							<input type="text" class="form-control" name="name"
								placeholder="请输入姓名（必填）" required aria-required="true" />
						</div>
		
						<div class="form-group">
							<input type="number" class="form-control" name="phone"
								placeholder="请输入电话（必填）" required aria-required="true" />
						</div>
		
						<div class="form-group">
							<input type="text" class="form-control" name="enterprise"
								placeholder="请输入企业（必填）" required aria-required="true" />
						</div>
						
						<div class="form-group">
							<input type="text" class="form-control" name="code"
								placeholder="请输入已认领的授权编号" />
						</div>
		
						<div class="form-group">
							<input type="text" class="form-control" name="card"
								placeholder="请输入身份证号码" />
						</div>
					
						<div class="form-group">
							<input type="email" class="form-control" name="email"
								placeholder="请输入邮箱" />
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="brandAgent"
								placeholder="请输入目前经营的品牌或代理" />
						</div>
						
						<div class="form-group">
							<div style="position: relative;">
								<!-- container -->
								<input readonly type="text" data-toggle="city-picker"
									class="form-control" name="provinces" />
							</div>
						</div>
					</div>
					<div style="width: 100%;">
						<button type="submit" style="margin: 20px auto; width: 70%; background-color: #a40001;border-color:#a40001; " class="btn btn-info btn-block">提交</button>
					</div>
				</form>
			</div>
			<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
		</div>
	</div>

	<script type="text/javascript">
	action = "${action}";
    function  cusFunction() {
        //console.info("提交之前，最后执行自定义的函数");
    }
    
    function submitCode(form_id) {
        var form = $('#gzxantForm');
        form.validate();
        $.ajax({
            cache: true,
            type: "POST",
            url: url+action,
            data: form.serialize(),// 你的formid
            async: false,
            dataType : "json",
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                layer.alert(XMLHttpRequest.responseJSON.error);
            },
            success: function (data) {
                if (data.code == 200) {
                    layer.msg("提交成功！");
                } else {
                    layer.alert(data.error);
                }

            }
        });
    }

    jQuery.validator.addMethod("phone", function(value, element) {
        var length = value.length;
        var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\d{8})$/;
        return this.optional(element) || (length == 11 && mobile.test(value));
    }, "请填写正确的手机号码");//可以自定义默认提示信息


    // 身份证号码验证
    jQuery.validator.addMethod("isIdCardNo", function(value, element) {
        return this.optional(element) || idCardNoUtil.checkIdCardNo(value);
    }, "请正确输入您的身份证号码");

    // 邮政编码验证
    jQuery.validator.addMethod("isZipCode", function(value, element) {
        var tel = /^[0-9]{6}$/;
        return this.optional(element) || (tel.test(value));
    }, "请正确填写您的邮政编码");
    
    // 编号验证
    jQuery.validator.addMethod("checkNumber", function(value, element, param) {
    	if (value == '') {
    		return true;
    	}
    	
    	var _this = this;
    	var flag = false;
    	$.ajax({
            cache: true,
            type: "get",
            url: url+"check",
            data: {code : $("input[name=code]").val()},// 你的formid
            async: false,
            dataType : "json",
            error: function (XMLHttpRequest, textStatus, errorThrown) {
            	layer.msg("操作失败，请重试");
            	flag = false;
            },
            success: function (data) {
                if (data.code == 200) {
                	flag = true;
                } else {
                	layer.msg(data.error);
	                flag = false;
                }
            }
        });
    	
    	return flag;
    }, $.validator.format("如有疑问请联系认证机构，电话：020-87221933"));
    
    // -----form表单验证-------------------------------------------------- //
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
                required: true,
                rangelength:[2,5],//名字长度
            },
            phone:{
                required: true,
                phone: true
        	},
        	code : {
        		checkNumber : true
        	},
            card: {
                isIdCardNo: true
            },
            email:{
                email:true
            }
        },
        messages: {
            name:{
                rangelength: "用户名在2-5之间"
            },
            card:{
                card: "请输入正确的身份证号码"
            },
            email:{
                email: "请输入一个有效的Email地址"
            }
        },
        submitHandler: function () {
        	submitCode();
        }
    });
    var idCardNoUtil = {
        provinceAndCitys: {11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江",
            31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",43:"湖南",44:"广东",
            45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",
            65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"},

        powers: ["7","9","10","5","8","4","2","1","6","3","7","9","10","5","8","4","2"],

        parityBit: ["1","0","X","9","8","7","6","5","4","3","2"],

        genders: {male:"男",female:"女"},

        checkAddressCode: function(addressCode){
            var check = /^[1-9]\d{5}$/.test(addressCode);
            if(!check) return false;
            if(idCardNoUtil.provinceAndCitys[parseInt(addressCode.substring(0,2))]){
                return true;
            }else{
                return false;
            }
        },

        checkBirthDayCode: function(birDayCode){
            var check = /^[1-9]\d{3}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))$/.test(birDayCode);
            if(!check) return false;
            var yyyy = parseInt(birDayCode.substring(0,4),10);
            var mm = parseInt(birDayCode.substring(4,6),10);
            var dd = parseInt(birDayCode.substring(6),10);
            var xdata = new Date(yyyy,mm-1,dd);
            if(xdata > new Date()){
                return false;//生日不能大于当前日期
            }else if ( ( xdata.getFullYear() == yyyy ) && ( xdata.getMonth () == mm - 1 ) && ( xdata.getDate() == dd ) ){
                return true;
            }else{
                return false;
            }
        },

        getParityBit: function(idCardNo){
            var id17 = idCardNo.substring(0,17);
            var power = 0;
            for(var i=0;i<17;i++){
                power += parseInt(id17.charAt(i),10) * parseInt(idCardNoUtil.powers[i]);
            }
            var mod = power % 11;
            return idCardNoUtil.parityBit[mod];
        },

        checkParityBit: function(idCardNo){
            var parityBit = idCardNo.charAt(17).toUpperCase();
            if(idCardNoUtil.getParityBit(idCardNo) == parityBit){
                return true;
            }else{
                return false;
            }
        },

        checkIdCardNo: function(idCardNo){
            //15位和18位身份证号码的基本校验
            var check = /^\d{15}|(\d{17}(\d|x|X))$/.test(idCardNo);
            if(!check) return false;

            //判断长度为15位或18位
            if(idCardNo.length==15){
                return idCardNoUtil.check15IdCardNo(idCardNo);
            }else if(idCardNo.length==18){
                return idCardNoUtil.check18IdCardNo(idCardNo);
            }else{
                return false;
            }
        },

        //校验15位的身份证号码
        check15IdCardNo: function(idCardNo){
            //15位身份证号码的基本校验
            var check = /^[1-9]\d{7}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))\d{3}$/.test(idCardNo);
            if(!check) return false;
            //校验地址码
            var addressCode = idCardNo.substring(0,6);
            check = idCardNoUtil.checkAddressCode(addressCode);
            if(!check) return false;
            var birDayCode = '19' + idCardNo.substring(6,12);
            //校验日期码
            return idCardNoUtil.checkBirthDayCode(birDayCode);
        },

        //校验18位的身份证号码
        check18IdCardNo: function(idCardNo){
            //18位身份证号码的基本格式校验
            var check = /^[1-9]\d{5}[1-9]\d{3}((0[1-9])|(1[0-2]))((0[1-9])|([1-2][0-9])|(3[0-1]))\d{3}(\d|x|X)$/.test(idCardNo);
            if(!check) return false;

            //校验地址码
            var addressCode = idCardNo.substring(0,6);
            check = idCardNoUtil.checkAddressCode(addressCode);
            if(!check) return false;

            //校验日期码
            var birDayCode = idCardNo.substring(6,14);
            check = idCardNoUtil.checkBirthDayCode(birDayCode);
            if(!check) return false;

            //验证校检码
            return idCardNoUtil.checkParityBit(idCardNo);
        },
        formateDateCN: function(day){
            var yyyy =day.substring(0,4);
            var mm = day.substring(4,6);
            var dd = day.substring(6);
            return yyyy + '-' + mm +'-' + dd;
        },
        //获取信息
        getIdCardInfo: function(idCardNo){
            var idCardInfo = {
                gender:"", //性别
                birthday:"" // 出生日期(yyyy-mm-dd)
            };
            if(idCardNo.length==15){
                var aday = '19' + idCardNo.substring(6,12);

                idCardInfo.birthday=idCardNoUtil.formateDateCN(aday);

                if(parseInt(idCardNo.charAt(14))%2==0){
                    idCardInfo.gender=idCardNoUtil.genders.female;
                }else{
                    idCardInfo.gender=idCardNoUtil.genders.male;
                }
            }else if(idCardNo.length==18){
                var aday = idCardNo.substring(6,14);

                idCardInfo.birthday = idCardNoUtil.formateDateCN(aday);

                if(parseInt(idCardNo.charAt(16))%2==0){
                    idCardInfo.gender = idCardNoUtil.genders.female;
                }else{
                    idCardInfo.gender = idCardNoUtil.genders.male;
                }
            }
            return idCardInfo;
        },

        getId15:function(idCardNo){
            if(idCardNo.length==15){
                return idCardNo;
            }else if(idCardNo.length==18){
                return idCardNo.substring(0,6) + idCardNo.substring(8,17);
            }else{
                return null;
            }
        },

        getId18: function(idCardNo){
            if(idCardNo.length==15){
                var id17 = idCardNo.substring(0,6) + '19' + idCardNo.substring(6);
                var parityBit = idCardNoUtil.getParityBit(id17);
                return id17 + parityBit;
            }else if(idCardNo.length==18){
                return idCardNo;
            }else{
                return null;
            }
        }
    };
</script>
</body>
</html>
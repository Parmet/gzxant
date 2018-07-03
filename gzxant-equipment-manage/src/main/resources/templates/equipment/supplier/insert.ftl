<style>
    .error{
        color:red;
    }
</style>
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins" >
                <div class="">
                    <form class="form-horizontal form-bordered" id="gzxantForm">
                        <input type="hidden" name="id" value="${equipmentSupplier.id}"/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">注册邮箱：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="emial"
                                       value="" placeholder="请输入注册邮箱"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">企业总部所在地：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <select name="enterpriseWhere" class="form-control">
                                        <option value="">请选择</option>
                                         <#list businessLocation as location>
		  									  <option value="${location.jvalue}">${location.jvalue}</option>
                                         </#list>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">国内总部所在地：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <select name="domesticAddress" class="form-control">
                                    <option value="">请选择</option>
                                             <#list supplierAddress as address>
		  									  <option value="${address.jvalue}">${address.jvalue}</option>
                                             </#list>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">企业性质：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <select name="enterpriseNature" class="form-control">
                                    <option value="">请选择</option>
                                             <#list natureOfBusiness as nature>
		  									  <option value="${nature.jvalue}">${nature.jvalue}</option>
                                             </#list>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">企业规模：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <select name="enterpriseScale" class="form-control">
                                    <option value="">请选择</option>
                                             <#list enterpriseScale as enterprisescale>
		  									  <option value="${enterprisescale.jvalue}">${enterprisescale.jvalue}</option>
                                             </#list>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">企业中文名称：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="enterpriseChineseName"
                                       value="" placeholder="请输入企业中文名称"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">英文名称：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="enterpriseEnglishName"
                                       value="" placeholder="请输入英文名称"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">企业网站：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="enterpriseWebsite"
                                       value="" placeholder="请输入企业网站"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">年产值：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <select name="outputValue" class="form-control">
                                    <option value="">请选择</option>
                                             <#list yearValues as yearvalue>
		  									  <option value="${yearvalue.jvalue}">${yearvalue.jvalue}</option>
                                             </#list>
                                    </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">经营范围：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <select name="businessScope" class="form-control">
                                    <option value="">请选择</option>
                                             <#list businessScope as business>
		  									  <option value="${business.jvalue}">${business.jvalue}</option>
                                             </#list>
                                </select>
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-sm-3 control-label">主攻行业：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <select name="announcementNumber" class="form-control">
                                    <option value="">请选择</option>
                                             <#list mainIndustry as mainin>
		  									  <option value="${mainin.jvalue}">${mainin.jvalue}</option>
                                             </#list>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">企业简介：</label>
                            <div class="col-sm-8">
                                <textarea class="form-control" name="enterpriseIntroduction"
                                          value=""></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">联系人姓名：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="contactName"
                                       value="" placeholder="请输入联系人姓名"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">职位：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <select name="position" class="form-control">
                                    <option value="">请选择</option>
                                             <#list companyPosition as postition>
		  									  <option value="${postition.jvalue}">${postition.jvalue}</option>
                                             </#list>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">办公电话：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="phone"
                                       value="" placeholder="请输入办公电话"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">手机号码：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="cellphoneNumber"
                                       value="" placeholder="请输入手机号码"/>
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-sm-3 control-label">传真：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="fax"
                                       value="" placeholder="请输入传真"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">通信地址：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="contactAddress"
                                       value="" placeholder="请输入通信地址"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">邮政编码：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="postalCode"
                                       value="" placeholder="请输入邮政编码"/>
                            </div>
                        </div>


                            <div class="form-actions fluid">
                            <div class="col-md-offset-3 col-md-9">
                                <button type="submit" onclick="infoNextStep()" class="btn btn-success">保存</button>
                            </div>
                        </div>

                    </form>

                </div>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript">

    action = "${action}";
    function  cusFunction() {
        console.info("提交之前，最后执行自定义的函数");
    }
    function infoNextStep() {
        info_validate.form();
    }

        // 手机号码验证
        $.validator.addMethod("isMobile", function(value, element) {
                var length = value.length;
            var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
                 return this.optional(element) || (length == 11 && mobile.test(value));
            }, "请正确填写您的手机号码");
    $.validator.addMethod("isTel", function(value, element) {
        var length = value.length;
        var phone = /(^(\d{3,4}-)?\d{6,8}$)|(^(\d{3,4}-)?\d{6,8}(-\d{1,5})?$)|(\d{11})/;
        return this.optional(element) || (phone.test(value));
    }, "请填写正确的固定电话");//可以自定义默认提示信息

    var info_validate = $('#gzxantForm');
    var error = $('.alert-danger', info_validate);
    info_validate.validate({
        errorElement: 'span',
        errorClass: 'error',
        focusInvalid: true,
        rules: {
            emial: {
                required: true,
                email: true
            },
            enterpriseWhere:{
                required: true
            },
            domesticAddress:{
                required: true
            },
            enterpriseNature:{
                required: true
            },
            enterpriseScale:{
                required: true
            },
            outputValue:{
                required: true
            },
            businessScope:{
                required: true
            },
            enterpriseChineseName: {
                required: true
            },
            announcementNumber:{
                required: true
            },
            position:{
                required: true
            },
            contactName: {
                required: true
            },
            phone: {
                required:true,
                isTel:true
            },
            cellphoneNumber: {
                required : true,
                maxlength:11,
                maxlength:11,
                isMobile:true

            },
            contactAddress: {
                 required: true
            }
        },
        messages: {
            emial:"请输入一个正确的邮箱",
            enterpriseWhere:"请选择企业所在地",
            domesticAddress:"请选择国内总部所在地",
            enterpriseNature:"请选择企业性质",
            enterpriseScale:"请选择企业规模",
            outputValue:"请选择年产值",
            businessScope:"请选择经营范围",
            announcementNumber:"请选择主攻方向",
            position:"请选择职位",
            enterpriseChineseName: "请输入企业中文名称",
            contactName: "请输入联系人姓名",
            phone: {
                required:"请填写正确的固定电话",
                isTel:"请填写正确的固定电话"
            },
            cellphoneNumber: {
                required : "请输入手机号",
                maxlength:"*请填写11位的手机号",
                minlength:"*请填写11位的手机号",
                isMobile:"请填写正确的手机号码"

            },
            contactAddress:"请选择通信地址"

        }
    });




</script>

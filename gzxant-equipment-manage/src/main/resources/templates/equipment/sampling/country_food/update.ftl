<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">

                    <form class="form-horizontal form-bordered" id="gzxantForm">
                        <input type="hidden" name="id" value="${equipmentCountryFoodSafety.id}"/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">文章标题：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="title"
                                       value="${equipmentCountryFoodSafety.title}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">标称生产企业名称：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="enterpriseName"
                                       value="${equipmentCountryFoodSafety.enterpriseName}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">标称生产企业地址：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="enterpriseAddress"
                                       value="${equipmentCountryFoodSafety.enterpriseAddress}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">被抽样单位名称：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="samplingName"
                                       value="${equipmentCountryFoodSafety.samplingName}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">被抽样单位地址：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="province"
                                       value="${equipmentCountryFoodSafety.province}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">食品名称：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="foodName"
                                       value="${equipmentCountryFoodSafety.foodName}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">规格型号：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="specificationsModel"
                                       value="${equipmentCountryFoodSafety.specificationsModel}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">商标：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="trademark"
                                       value="${equipmentCountryFoodSafety.trademark}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">生产日期/批号：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="produceDate"
                                       value="${equipmentCountryFoodSafety.produceDate}"/>
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-sm-3 control-label">不合格项目║检验结果║标准值：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="samplingResult"
                                       value="${equipmentCountryFoodSafety.samplingResult}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">分类&nbsp;</label>
                            <div class="col-sm-8">
                                <select id="type_input" name="classification" class="form-control " style="width:100%;">
                                <#list foodType as type>
                                <option value="${type.jvalue}">${type.jvalue}</option>
                                </#list>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">抽检类型&nbsp;</label>
                            <div class="col-sm-8">
                                <select id="type_input" name="samplingType" class="form-control " style="width:100%;">
                                    <option value="">${equipmentCountryFoodSafety.samplingType}</option>
                                    <option value="国家食品安全监督抽检(合格)">国家食品安全监督抽检(合格)</option>
                                    <option value="国家食品安全监督抽检(不合格)">国家食品安全监督抽检(不合格)</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">公告号：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="announcementNumber"
                                       value="${equipmentCountryFoodSafety.announcementNumber}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">抽检项目：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="samplingProduce"
                                       value="${equipmentCountryFoodSafety.samplingProduce}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">公告日期：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="announcementDate"
                                       value="${equipmentCountryFoodSafety.announcementDate}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">备注：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="remark"
                                       value="${equipmentCountryFoodSafety.remark}"/>
                            </div>
                        </div>

                        <div class="form-actions fluid">
                            <div class="col-md-offset-3 col-md-9">
                                <button type="submit" class="btn btn-green">保存</button>
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

    var form = $('#gzxantForm');
    var error = $('.alert-danger', form);
    form.validate({
        errorElement: 'span',
        errorClass: 'error',
        focusInvalid: true,
        messages: {
            loginName: {remote: "登陆名已经存在"}
        },
        rules: {
            loginName: {
                minlength: 2,
                maxlength: 30,
                required: true,
                remote: '${rc.contextPath}/sys/user/check/${equipmentCountryFoodSafety.id}'
            },
            name: {
                required: true
            },
            email: {
                required: true,
                email: true
            },
            active: {
                required: true
            },
            password: {
                maxlength: 16,
                required: true
            },
            no: {
                maxlength: 100,
                required: true
            }
        }
    });




</script>

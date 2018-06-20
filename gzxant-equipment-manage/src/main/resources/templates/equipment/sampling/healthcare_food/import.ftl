<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
                    <form class="form-horizontal form-bordered" id="gzxantForm">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">文章标题：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="title"
                                       value="" placeholder="请输入文章标题"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">标称产品名称：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="prodeuctName"
                                       value="" placeholder="请输入标称产品名称"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">标称批准文号：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="announcement"
                                       value="" placeholder="请输入标称批准文号"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">规格(包装规格)：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="specificationsModel"
                                       value="" placeholder="规格(包装规格)"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">标称批准文号：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="number"
                                       value="" placeholder="请输入标称批号"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">标称生产企业名称：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="enterpriseName"
                                       value="" placeholder="请输入标称生产企业名称"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">标称生产企业地址：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="enterpriseAddress"
                                       value=""  placeholder="请输入标称生产企业地址"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">被抽样单位名称：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="samplingName"
                                       value="" placeholder="请输入被抽样单位名称"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">被抽样单位地址：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="province"
                                       value="" placeholder="请输入被抽样单位地址"/>
                            </div>
                        </div>
                        <#--<div class = "row">-->
                            <#--<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">-->
                                <#--<label for="type_input" class="control-label">抽检类型&nbsp;</label>-->
                                <#--<select id="type_input" name="samplingType" class="form-control _search" style="width:100%;">-->
                                    <#--<option value="">请选择</option>-->
                                    <#--<option value="国家保健食品安全监督抽检(合格产品)">国家保健食品安全监督抽检(合格产品)</option>-->
                                    <#--<option value="国家保健食品安全监督抽检(不合格产品)">国家保健食品安全监督抽检(不合格产品)</option>-->
                                <#--</select>-->
                            <#--</div>-->
                        <#--</div>-->
                        <div class="form-group">
                            <label class="col-sm-3 control-label">抽检类型&nbsp;</label>
                            <div class="col-sm-8">
                                <select id="type_input" name="samplingType" class="form-control _search" style="width:100%;">
                                    <option value="">请选择</option>
                                    <option value="国家保健食品安全监督抽检(合格产品)">国家保健食品安全监督抽检(合格产品)</option>
                                    <option value="国家保健食品安全监督抽检(不合格产品)">国家保健食品安全监督抽检(不合格产品)</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">产品类别：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="prodeuceType"
                                       value="" placeholder="请输入产品类别"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">不合格项目║检验结果║标准值：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="samplingResult"
                                       value="" placeholder="请输入结果"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">公告号：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="announcementNumber"
                                       value="" placeholder="请输入公告号"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">公告号：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="announcementDate"
                                       value="" placeholder="请输入公告日期(格式 2018-01-01)"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">分类：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="classification"
                                       value="" placeholder="请输入分类"/>
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-sm-3 control-label">抽检项目：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="samplingProduce"
                                       value="" placeholder="请输入抽检项目"/>
                            </div>
                        </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">抽检项目：<span class="required">*</span></label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" name="testingProduce"
                                           value="" placeholder="请输入抽检项目"/>
                                </div>
                            </div>


                        <div class="form-group">
                            <label class="col-sm-3 control-label">检验机构	：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="mechanism"
                                       value="" placeholder="请输入检验机构	"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">备注：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="remark"
                                       value="" placeholder="请输入备注"/>
                            </div>
                        </div>

                        <div class="form-actions fluid">
                            <div class="col-md-offset-3 col-md-9">
                                <button type="submit" class="btn btn-success">保存</button>
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

<style>
    .error{
        color:red;
    }
</style>
<#macro optionList list selected="" >
    <#-- macro function to show the option list -->
    <#-- list is the list of all items, the selected is the value of selected item -->
    <#--<option value="${equipmentSupplier.enterpriseWhere}">${equipmentSupplier.enterpriseWhere}</option>-->
    <#if action=="detail">
        <#-- Only need to show the detail attacth to the obj -->
        <option label="${selected}">${selected}</option>
    <#else >
        <#-- ELSE: action == "update" -->
        <#list list as option>
        <option value="${option.jvalue}"
            <#if option.jvalue == selected>
                <#-- Reduce the duplicate show -->
                selected="true"
            </#if>
        >${option.jvalue}</option>
        </#list>
    </#if>
</#macro>

<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins" >
                <div class="">
                    <form class="form-horizontal form-bordered" id="gzxantForm">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">注册邮箱：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="emial"
                                       value="${equipmentSupplier.emial}" placeholder="请输入注册邮箱"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">企业总部所在地：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <select name="enterpriseWhere" class="form-control">
                                    <@optionList businessLocation equipmentSupplier.enterpriseWhere />
                                </select>

                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">国内总部所在地：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <select name="domesticAddress" class="form-control">
                                    <@optionList supplierAddress equipmentSupplier.domesticAddress />
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">企业性质：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <select name="enterpriseNature" class="form-control">
 x                                   <@optionList natureOfBusiness equipmentSupplier.enterpriseNature />
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">企业规模：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <select name="enterpriseScale" class="form-control">
                                    <@optionList enterpriseScale equipmentSupplier.enterpriseScale />
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">企业中文名称：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="enterpriseChineseName"
                                       value="${equipmentSupplier.enterpriseChineseName}" placeholder="请输入企业中文名称"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">英文名称：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="enterpriseEnglishName"
                                       value="${equipmentSupplier.enterpriseEnglishName}" placeholder="请输入英文名称"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">企业网站：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="enterpriseWebsite"
                                       value="${equipmentSupplier.enterpriseWebsite}" placeholder="请输入企业网站"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">年产值：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <select name="outputValue" class="form-control">
x                                    <@optionList yearValues equipmentSupplier.outputValue />
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">经营范围：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <select name="businessScope" class="form-control">
                                    <@optionList businessScope equipmentSupplier.businessScope />
                                </select>
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-sm-3 control-label">主攻行业：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <select name="announcementNumber" class="form-control">
                                    <@optionList mainIndustry equipmentSupplier.announcementNumber />
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">企业简介：</label>
                            <div class="col-sm-8">
                                <textarea class="form-control" name="enterpriseIntroduction"
                                          value="${equipmentSupplier.enterpriseIntroduction}">${equipmentSupplier.enterpriseIntroduction}</textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">联系人姓名：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="contactName"
                                       value="${equipmentSupplier.contactName}" placeholder="请输入联系人姓名"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">职位：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <select name="position" class="form-control">
                                    <@optionList companyPosition companyPosition.position />
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">办公电话：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="phone"
                                       value="${equipmentSupplier.phone}" placeholder="请输入办公电话"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">手机号码：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="cellphoneNumber"
                                       value="${equipmentSupplier.cellphoneNumber}" placeholder="请输入手机号码"/>
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-sm-3 control-label">传真：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="fax"
                                       value="${equipmentSupplier.fax}" placeholder="请输入传真"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">通信地址：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="contactAddress"
                                       value="${equipmentSupplier.contactAddress}" placeholder="请输入通信地址"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">邮政编码：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="postalCode"
                                       value="${equipmentSupplier.postalCode}" placeholder="请输入邮政编码"/>
                            </div>
                        </div>

                        <#if action !='detail'>
                            <div class="form-actions fluid">
                                <div class="col-md-offset-3 col-md-9">
                                    <button type="submit" onclick="infoNextStep()" class="btn btn-success">保存</button>
                                </div>
                            </div>
                        </#if>
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
            enterpriseChineseName: {
                required: true
            },
            contactName: {
                required: true
            },
            phone: {
                required: true
            },

            cellphoneNumber: {
                required: true
            },
            contactAddress: {
                 required: true
            }
        },
        messages: {
            emial:"请输入一个正确的邮箱",
            enterpriseChineseName: "请输入企业中文名称",
            contactName: "请输入联系人姓名",
            phone: "请输入办公室电话",
            cellphoneNumber: "请输入手机号码",
            contactAddress:"请选择通信地址"

        }
    });




</script>

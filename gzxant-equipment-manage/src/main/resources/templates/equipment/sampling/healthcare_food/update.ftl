<style>
    .error{
        color:red;
    }
</style>
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="">

                    <form class="form-horizontal form-bordered" id="gzxantForm">
                        <input type="hidden" name="id" value="${equipmentHealthcareFood.id}"/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">文章标题：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="title"
                                       value="${equipmentHealthcareFood.title}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">批号：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="number"
                                       value="${equipmentHealthcareFood.number}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">标称批准文号：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="announcement"
                                       value="${equipmentHealthcareFood.announcement}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">规格(包装规格)：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="specificationsModel"
                                       value="${equipmentHealthcareFood.specificationsModel}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">产品名称：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="prodeuctName"
                                       value="${equipmentHealthcareFood.prodeuctName}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">标称生产企业名称：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="enterpriseName"
                                       value="${equipmentHealthcareFood.enterpriseName}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">标称生产企业地址：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="enterpriseAddress"
                                       value="${equipmentHealthcareFood.enterpriseAddress}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">被抽样单位名称：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="samplingName"
                                       value="${equipmentHealthcareFood.samplingName}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">被抽样单位地址：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="province"
                                       value="${equipmentHealthcareFood.province}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">产品类别：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="prodeuceType"
                                       value="${equipmentHealthcareFood.prodeuceType}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">不合格项目║检验结果║标准值：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="samplingResult"
                                       value="${equipmentHealthcareFood.samplingResult}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">公告号：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="announcementNumber"
                                       value="${equipmentHealthcareFood.announcementNumber}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">公告日期：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="announcementDate"
                                       value="${equipmentHealthcareFood.announcementDate}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">分类：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="classification"
                                       value="${equipmentHealthcareFood.classification}"/>
                            </div>
                        </div>




                        <div class="form-group">
                            <label class="col-sm-3 control-label">抽检类型&nbsp;</label>
                            <div class="col-sm-8">
                                <select id="type_input" name="samplingType" class="form-control " style="width:100%;color: black">
                                    <option value="${equipmentHealthcareFood.samplingType}">${equipmentHealthcareFood.samplingType}</option>
                                    <option value="国家保健食品安全监督抽检(合格产品)">国家保健食品安全监督抽检(合格产品)</option>
                                    <option value="国家保健食品安全监督抽检(不合格产品)">国家保健食品安全监督抽检(不合格产品)</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">检验项目：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="testingProduce"
                                       value="${equipmentHealthcareFood.testingProduce}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">抽检项目：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <textarea class="form-control" name="samplingProduce"
                                       value="${equipmentHealthcareFood.samplingProduce}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">检测机构：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="mechanism"
                                       value="${equipmentHealthcareFood.mechanism}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">备注：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="remark"
                                       value="${equipmentCountryFoodSafety.remark}"/>
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
        if (info_validate.form()) {
            nextStep();
        }
    }

    var info_validate = $('#gzxantForm');
    var error = $('.alert-danger', info_validate);
    info_validate.validate({
        errorElement: 'span',
        errorClass: 'error',
        focusInvalid: true,
        rules: {
            title: {
                required: true
            },
            prodeuctName: {
                required: true
            },
            specificationsModel:{
                required: true
            },
            number:{
                required: true
            },
            announcement: {
                required: true
            },
            enterpriseName: {
                required: true
            },
            samplingName: {
                required: true
            },
            enterpriseAddress: {
                required: true
            },
            province: {
                required: true
            },
            samplingType: {
                required: true
            },
            announcementNumber: {
                required: true
            },
            announcementDate: {
                required: true,
                date:true
            },
            classification: {
                required: true
            },
            samplingProduce: {
                required: true
            }
        },
        messages: {
            title:"请输入文章标题",
            prodeuctName:"请输入标称产品名称",
            enterpriseName: "请输入标称生产企业名称",
            announcement:"请输入标称批准文号",
            specificationsModel:"请输入规格(包装规格)",
            number:"请输入批号",
            enterpriseAddress: "请输入标称生产企业地址",
            samplingName: "请输入被抽样单位名称",
            province: "请输入被抽样单位地址",
            samplingType:"请选择抽检类型",
            announcementNumber:"请输入公告号",
            announcementDate:"请输入公告日期(YYYY-MM-DD)",
            classification:"请选择分类",
            samplingProduce:"请输入抽检项目"

        }
    });




</script>

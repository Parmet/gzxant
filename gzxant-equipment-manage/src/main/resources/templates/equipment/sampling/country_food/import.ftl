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
                        <div class="form-group">
                            <label class="col-sm-3 control-label">文章标题：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="title"
                                       value="" placeholder="请输入文章标题"/>
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

                        <div class="form-group">
                            <label class="col-sm-3 control-label">食品名称：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="foodName"
                                       value="" placeholder="请输入食品名称"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">规格型号：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="specificationsModel"
                                       value="" placeholder="请输入规格型号"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">商标：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="trademark"
                                       value="" placeholder="请输入商标"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">生产日期/批号：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="produceDate"
                                       value="" placeholder="请输入生产日期/批号(格式 2018-01-01)"/>
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-sm-3 control-label">不合格项目║检验结果║标准值：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="samplingResult"
                                       value="" placeholder="请输入不合格项目║检验结果║标准值"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">分类：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <select id="type_input" name="classification" class="form-control" style="width:100%;color: black">
                                    <option value="">请选择</option>
	  								<#list foodType as type>
	  									<option value="${type.jvalue}">${type.jvalue}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">抽检类型<span class="required">*</span></label>
                            <div class="col-sm-8">
                            <select id="type_input" name="samplingType" class="form-control " style="width:100%; color: black">
                                <option value="">请选择</option>
                                <option value="国家食品安全监督抽检(合格)">国家食品安全监督抽检(合格)</option>
                                <option value="国家食品安全监督抽检(不合格)">国家食品安全监督抽检(不合格)</option>
                            </select>
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
                            <label class="col-sm-3 control-label">抽检项目：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="samplingProduce"
                                       value="" placeholder="请输入抽检项目"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">公告日期：<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="announcementDate"
                                       value="" placeholder="请输入公告日期(格式 2018-01-01)"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">备注：</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="remark"
                                       value="" placeholder="请输入备注"/>
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
            foodName: {
                 required: true
               },
            classification: {
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
            }

        },
        messages: {
            title:"请输入文章标题",
            enterpriseName: "请输入标称生产企业名称",
            enterpriseAddress: "请输入标称生产企业地址",
            samplingName: "请输入被抽样单位名称",
            province: "请输入被抽样单位地址",
            foodName:"请输入食物名称",
            classification:"请选择分类",
            samplingType:"请选择抽检类型",
            announcementNumber:"请输入公告号",
            announcementDate:"请输入公告日期(YYYY-MM-DD)"
        }
    });




</script>

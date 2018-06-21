<style xmlns="http://www.w3.org/1999/html">

    .control-labels{
        text-align: right;
        width: 100%;
        color: black;
    }


</style>
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">

                    <form class="form-horizontal form-bordered" id="gzxantForm">
                        <input type="hidden" name="id" value="${equipmentHealthcareFood.id}"/>

                        <div class = "row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 form-group">
                                <p class="control-labels">标题：</p>
                            </div>
                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 form-group">
                                <p> ${equipmentHealthcareFood.title}</p>
                            </div>
                        </div>
                        <div class = "row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 form-group">
                                <p class="control-labels">标称批准文号：</p>
                            </div>
                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 form-group">
                                <p> ${equipmentHealthcareFood.prodeuctName}</p>
                            </div>
                        </div>
                        <div class = "row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 form-group">
                                <p class="control-labels">批号：</p>
                            </div>
                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 form-group">
                                <p> ${equipmentHealthcareFood.number}</p>
                            </div>
                        </div>
                        <div class = "row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 form-group">
                                <p class="control-labels">标称产品名称：</p>
                            </div>
                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 form-group">
                                <p> ${equipmentHealthcareFood.announcement}</p>
                            </div>
                        </div>
                        <div class = "row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 form-group">
                                <p class="control-labels">标称生产企业名称：</p>
                            </div>
                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 form-group">
                                <p> ${equipmentHealthcareFood.enterpriseName}</p>
                            </div>
                        </div>
                        <div class = "row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 form-group">
                                <p class="control-labels">标称生产企业地址：</p>
                            </div>
                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 form-group">
                                <p> ${equipmentHealthcareFood.enterpriseAddress}</p>
                            </div>
                        </div>

                        <div class = "row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 form-group">
                                <p class="control-labels">被抽样单位名称：</p>
                            </div>
                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 form-group">
                                <p> ${equipmentHealthcareFood.samplingName}</p>
                            </div>
                        </div>
                        <div class = "row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 form-group">
                                <p class="control-labels">被抽样单位地址：</p>
                            </div>
                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 form-group">
                                <p> ${equipmentHealthcareFood.province}</p>
                            </div>
                        </div>
                        <div class = "row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 form-group">
                                <p class="control-labels">不合格项目║检验结果║标准值：</p>
                            </div>
                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 form-group">
                                <p> ${equipmentHealthcareFood.samplingResult}</p>
                            </div>
                        </div>
                        <div class = "row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 form-group">
                                <p class="control-labels">公告号：</p>
                            </div>
                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 form-group">
                                <p> ${equipmentHealthcareFood.announcementNumber}</p>
                            </div>
                        </div>

                        <div class = "row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 form-group">
                                <p class="control-labels">公告日期：</p>
                            </div>
                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 form-group">
                                <p> ${equipmentHealthcareFood.announcementDate}</p>
                            </div>
                        </div>

                        <div class = "row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 form-group">
                                <p class="control-labels">分类：</p>
                            </div>
                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 form-group">
                                <p> ${equipmentHealthcareFood.classification}</p>
                            </div>
                        </div>


                        <div class = "row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 form-group">
                                <p class="control-labels">检测项目：</p>
                            </div>
                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 form-group">
                                <p> ${equipmentHealthcareFood.testingProduce}</p>
                            </div>
                        </div>

                        <div class = "row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 form-group">
                                <p class="control-labels">抽检项目：</p>
                            </div>
                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 form-group">
                                <p> ${equipmentHealthcareFood.samplingProduce}</p>
                            </div>
                        </div>


                        <div class = "row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 form-group">
                                <p class="control-labels">检验机构：</p>
                            </div>
                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 form-group">
                                <p> ${equipmentHealthcareFood.mechanism}</p>
                            </div>
                        </div>
                        <div class = "row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 form-group">
                                <p class="control-labels">备注：</p>
                            </div>
                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 form-group">
                                <p> ${equipmentHealthcareFood.remark}</p>
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







</script>

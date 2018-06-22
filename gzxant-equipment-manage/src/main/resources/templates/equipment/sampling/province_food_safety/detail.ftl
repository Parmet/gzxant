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
                                <p> ${equipmentProvinceFoodSafety.title}</p>
                            </div>
                        </div>
                        <div class = "row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 form-group">
                                <p class="control-labels">标称生产企业名称：</p>
                            </div>
                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 form-group">
                                <p> ${equipmentProvinceFoodSafety.enterpriseAddress}</p>
                            </div>
                        </div>
                        <div class = "row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 form-group">
                                <p class="control-labels">标称生产企业地址：</p>
                            </div>
                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 form-group">
                                <p> ${equipmentProvinceFoodSafety.enterpriseAddress}</p>
                            </div>
                        </div>

                        <div class = "row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 form-group">
                                <p class="control-labels">被抽样单位名称：</p>
                            </div>
                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 form-group">
                                <p> ${equipmentProvinceFoodSafety.samplingName}</p>
                            </div>
                        </div>
                        <div class = "row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 form-group">
                                <p class="control-labels">被抽样单位地址：</p>
                            </div>
                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 form-group">
                                <p> ${equipmentProvinceFoodSafety.province}</p>
                            </div>
                        </div>
                        <div class = "row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 form-group">
                                <p class="control-labels">食品名称：</p>
                            </div>
                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 form-group">
                                <p> ${equipmentProvinceFoodSafety.foodName}</p>
                            </div>
                        </div>
                        <div class = "row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 form-group">
                                <p class="control-labels">规格型号：</p>
                            </div>
                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 form-group">
                                <p> ${equipmentProvinceFoodSafety.specificationsModel}</p>
                            </div>
                        </div>
                        <div class = "row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 form-group">
                                <p class="control-labels">生产日期/批号：</p>
                            </div>
                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 form-group">
                                <p> ${equipmentProvinceFoodSafety.prodectDate}</p>
                            </div>
                        </div>
                        <div class = "row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 form-group">
                                <p class="control-labels">不合格项目║检验结果║标准值：</p>
                            </div>
                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 form-group">
                                <p> ${equipmentProvinceFoodSafety.samplingResult}</p>
                            </div>
                        </div>
                        <div class = "row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 form-group">
                                <p class="control-labels">公告号：</p>
                            </div>
                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 form-group">
                                <p> ${equipmentProvinceFoodSafety.announcementNumber}</p>
                            </div>
                        </div>

                        <div class = "row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 form-group">
                                <p class="control-labels">公告日期：</p>
                            </div>
                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 form-group">
                                <p> ${equipmentProvinceFoodSafety.announcementDate}</p>
                            </div>
                        </div>

                        <div class = "row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 form-group">
                                <p class="control-labels">分类：</p>
                            </div>
                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 form-group">
                                <p> ${equipmentProvinceFoodSafety.classification}</p>
                            </div>
                        </div>
                        <div class = "row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 form-group">
                                <p class="control-labels">任务来源/项目名称	：</p>
                            </div>
                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 form-group">
                                <p> ${equipmentProvinceFoodSafety.taskSource}</p>
                            </div>
                        </div>

                        <div class = "row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 form-group">
                                <p class="control-labels">商标：</p>
                            </div>
                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 form-group">
                                <p> ${equipmentCountryFoodSafety.trademark}</p>
                            </div>
                        </div>



                        <div class = "row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 form-group">
                                <p class="control-labels">备注：</p>
                            </div>
                            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 form-group">
                                <p> ${equipmentProvinceFoodSafety.remark}</p>
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

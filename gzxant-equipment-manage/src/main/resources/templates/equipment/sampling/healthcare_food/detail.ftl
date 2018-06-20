<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">

                    <form class="form-horizontal form-bordered" id="gzxantForm">
                        <input type="hidden" name="id" value="${equipmentHealthcareFood.id}"/>

                        <div class = "row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                <label for="first_category_input" class="control-label" style="width: 30%;">标题：
                                </label><span>${equipmentHealthcareFood.title}</span>
                            </div>
                        </div>
                        <div class = "row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                <label for="first_category_input" class="control-label" style="width: 30%;">标称批准文号：
                                </label><span>${equipmentHealthcareFood.prodeuctName}</span>
                            </div>
                        </div>
                        <div class = "row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                <label for="first_category_input" class="control-label" style="width: 30%;">批号：
                                </label><span>${equipmentHealthcareFood.number}</span>
                            </div>
                        </div>
                        <div class = "row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                <label for="first_category_input" class="control-label" style="width: 30%;">标称产品名称：
                                </label><span>${equipmentHealthcareFood.announcement}</span>
                            </div>
                        </div>
                        <div class = "row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                    <label for="first_category_input" class="control-label" style="width: 30%;">标称生产企业名称：
                                   </label><span>${equipmentHealthcareFood.enterpriseAddress}</span>
                            </div>
                        </div>

                        <div class = "row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                <label for="first_category_input" class="control-label" style="width: 30%;">标称生产企业地址：
                                </label><span>${equipmentHealthcareFood.enterpriseAddress}</span>
                            </div>
                        </div>
                        <div class = "row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                <label for="first_category_input" class="control-label" style="width: 30%;">被抽样单位名称：
                                </label><span> ${equipmentHealthcareFood.samplingName}</>
                            </div>
                        </div>
                        <div class = "row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                <label for="first_category_input" class="control-label" style="width: 30%;">被抽样单位地址：
                                </label><span> ${equipmentHealthcareFood.province}</>
                            </div>
                        </div>
                        <div class = "row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                <label for="first_category_input" class="control-label" style="width: 30%;">不合格项目║检验结果║标准值：
                                </label><span> ${equipmentHealthcareFood.samplingResult}</>
                            </div>
                        </div>

                        <div class = "row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                <label for="first_category_input" class="control-label" style="width: 30%;">公告号：
                                </label><span> ${equipmentHealthcareFood.announcementNumber}</>
                            </div>
                        </div>

                        <div class = "row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                <label for="first_category_input" class="control-label" style="width: 30%;">公告日期：
                                </label><span> ${equipmentHealthcareFood.announcementDate}</>
                            </div>
                        </div>

                        <div class = "row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                <label for="first_category_input" class="control-label" style="width: 30%;">分类：
                                </label><span> ${equipmentHealthcareFood.classification}</>
                            </div>
                        </div>

                        <div class = "row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                <label for="first_category_input" class="control-label" style="width: 30%;">检测项目：
                                </label><span> ${equipmentHealthcareFood.testingProduce}</>
                            </div>
                        </div>



                        <div class = "row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                <label for="first_category_input" class="control-label" style="width: 30%;"> 抽检项目：
                                </label><span> ${equipmentHealthcareFood.samplingProduce}</>
                            </div>
                        </div>
                        <div class = "row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                <label for="first_category_input" class="control-label" style="width: 30%;"> 检验机构：
                                </label><span> ${equipmentHealthcareFood.mechanism}</>
                            </div>
                        </div>

                        <div class = "row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                <label for="first_category_input" class="control-label" style="width: 30%;"> 备注：
                                </label><span> ${equipmentHealthcareFood.remark}</>
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

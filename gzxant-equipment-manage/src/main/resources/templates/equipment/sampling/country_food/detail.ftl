<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">

                    <form class="form-horizontal form-bordered" id="gzxantForm">
                        <input type="hidden" name="id" value="${equipmentCountryFoodSafety.id}"/>

                        <div class = "row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                <label for="first_category_input" class="control-label" style="width: 30%;">标题：
                                </label><span>${equipmentCountryFoodSafety.title}</span>
                            </div>
                        </div>

                        <div class = "row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                            <label for="first_category_input" class="control-label" style="width: 30%;">标称生产企业名称：
                            </label><span>${equipmentCountryFoodSafety.enterpriseAddress}</span>
                        </div>
                    </div>

                        <div class = "row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                <label for="first_category_input" class="control-label" style="width: 30%;">标称生产企业地址：
                                </label><span>${equipmentCountryFoodSafety.enterpriseAddress}</span>
                            </div>
                        </div>
                        <div class = "row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                <label for="first_category_input" class="control-label" style="width: 30%;">被抽样单位名称：
                                </label><span> ${equipmentCountryFoodSafety.samplingName}</>
                            </div>
                        </div>
                        <div class = "row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                <label for="first_category_input" class="control-label" style="width: 30%;">被抽样单位地址：
                                </label><span> ${equipmentCountryFoodSafety.province}</>
                            </div>
                        </div>
                        <div class = "row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                <label for="first_category_input" class="control-label" style="width: 30%;">食品名称：
                                </label><span> ${equipmentCountryFoodSafety.foodName}</>
                            </div>
                        </div>

                        <div class = "row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                <label for="first_category_input" class="control-label" style="width: 30%;">规格型号：
                                </label><span> ${equipmentCountryFoodSafety.specificationsModel}</>
                            </div>
                        </div>

                        <div class = "row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                <label for="first_category_input" class="control-label" style="width: 30%;">商标：
                                </label><span> ${equipmentCountryFoodSafety.trademark}</>
                            </div>
                        </div>


                        <div class = "row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                <label for="first_category_input" class="control-label" style="width: 30%;">生产日期/批号：
                                </label><span> ${equipmentCountryFoodSafety.produceDate}</>
                            </div>
                        </div>
                        <div class = "row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                <label for="first_category_input" class="control-label" style="width: 30%;"> 不合格项目║检验结果║标准值：
                                </label><span> ${equipmentCountryFoodSafety.samplingResult}</>
                            </div>

                        </div>

                        <div class = "row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                <label for="first_category_input" class="control-label" style="width: 30%;"> 分类：
                                </label><span> ${equipmentCountryFoodSafety.classification}</>
                            </div>
                        </div>
                        <div class = "row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                <label for="first_category_input" class="control-label" style="width: 30%;"> 公告号：
                                </label><span> ${equipmentCountryFoodSafety.announcementNumber}</>
                            </div>
                        </div>

                        <div class = "row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                <label for="first_category_input" class="control-label" style="width: 30%;"> 抽检项目：
                                </label><span> ${equipmentCountryFoodSafety.samplingProduce}</>
                            </div>
                        </div>
                        <div class = "row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                <label for="first_category_input" class="control-label" style="width: 30%;">公告日期：
                                </label><span> ${equipmentCountryFoodSafety.announcementDate}</>
                            </div>
                        </div>
                        <div class = "row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
                                <label for="first_category_input" class="control-label" style="width: 30%;"> 备注：
                                </label><span> ${equipmentCountryFoodSafety.remark}</>
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

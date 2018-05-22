
    <link href="http://twitter.github.com/bootstrap/assets/js/google-code-prettify/prettify.css" rel="stylesheet">
    <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
    <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-responsive.min.css" rel="stylesheet">
    <link href="http://netdna.bootstrapcdn.com/font-awesome/3.0.2/css/font-awesome.css" rel="stylesheet">
    <link href="${rc.contextPath}/wysiwyg/index.css" rel="stylesheet">
    
    <script src="${rc.contextPath}/wysiwyg/external/jquery.hotkeys.js"></script>
      <script src="${rc.contextPath}/js/bootstrap.min.js"></script>
      <script src="${rc.contextPath}/wysiwyg/bootstrap-wysiwyg.js"></script>
      <script src="${rc.contextPath}/wysiwyg/external/google-code-prettify/prettify.js"></script>
<div class="container">
<div class="row">
	<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 form-group">
		<input type="text" class="form-control" name="name" id="name"
			placeholder="请输入标题" required aria-required="true" value="${qualification.name}" />
	</div>
</div>
      	${article.articleContent}
</div>

<div class="container-fluid">
	<div class="col-sm-8">
	</div>
    <div class="col-sm-4">
    	<button type="button" onclick="back()" class="btn btn-info m-t-25">返回</button>
    </div>
</div>
<script src="http://cdn.bootcss.com/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>
<script src="${rc.contextPath}/wysiwyg/bootstrap-wysiwyg.js"></script>
<script>

function back() {
	window.history.back();
}
</script>
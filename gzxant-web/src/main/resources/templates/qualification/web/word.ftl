<!DOCTYPE html>
<html>
<head>
	<title>${article.name}</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="shortcut icon" href="${rc.contextPath}/favicon.ico">
	<link href="${rc.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${rc.contextPath}/css/font-awesome.min.css?v=4.4.0" rel="stylesheet" />
	<link href="${rc.contextPath}/css/animate.css" rel="stylesheet" />
	<link href="${rc.contextPath}/css/gzxant.css" rel="stylesheet" />
	<link href="${rc.contextPath}/css/plugins/select2/select2.css"
		rel="stylesheet">
	<script>
        var base_url ="${rc.contextPath}";
        var url = "${rc.requestUri}" + "/",  action = "${action}";
    </script>

	<script src="${rc.contextPath}/js/jquery.min.js"></script>
	<script src="${rc.contextPath}/js/bootstrap.min.js"></script>
	<link href="http://twitter.github.com/bootstrap/assets/js/google-code-prettify/prettify.css" rel="stylesheet">
    <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
    <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-responsive.min.css" rel="stylesheet">
    <link href="http://netdna.bootstrapcdn.com/font-awesome/3.0.2/css/font-awesome.css" rel="stylesheet">
    <link href="${rc.contextPath}/wysiwyg/index.css" rel="stylesheet">
    
    <script src="${rc.contextPath}/wysiwyg/external/jquery.hotkeys.js"></script>
    <script src="${rc.contextPath}/js/bootstrap.min.js"></script>
    <script src="${rc.contextPath}/wysiwyg/bootstrap-wysiwyg.js"></script>
    <script src="${rc.contextPath}/wysiwyg/external/google-code-prettify/prettify.js"></script>
</head>

<body style="background-color: #f0f0f0;margin: 5px;">
${article.articleContent}
</body>
</html>
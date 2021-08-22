<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/importTag.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Fundraising</title>
<%@ include file="../include/csstemplate.jsp"%>
</head>
<body class="layout layout-header-fixed">

	<tiles:insertAttribute name="header"></tiles:insertAttribute>

	<div class="layout-main">
		<div class="layout-sidebar">
			<div class="layout-sidebar-backdrop"></div>
			<tiles:insertAttribute name="left-menu"></tiles:insertAttribute>
		</div>
		<div class="layout-content">
			<tiles:insertAttribute name="body"></tiles:insertAttribute>
		</div>
		<div class="layout-footer">
			<tiles:insertAttribute name="footer"></tiles:insertAttribute>
		</div>
	</div>
	<%@ include file="../include/jstemplate.jsp"%>
	<script>
		(function(i, s, o, g, r, a, m) {
			i['GoogleAnalyticsObject'] = r;
			i[r] = i[r] || function() {
				(i[r].q = i[r].q || []).push(arguments)
			}, i[r].l = 1 * new Date();
			a = s.createElement(o), m = s.getElementsByTagName(o)[0];
			a.async = 1;
			a.src = g;
			m.parentNode.insertBefore(a, m)
		})(window, document, 'script',
				'https://www.google-analytics.com/analytics.js', 'ga');
		ga('create', 'UA-83990101-1', 'auto');
		ga('send', 'pageview');
	</script>
</body>
</html>
<%@ include file="../../include/importTag.jsp"%>
<style>
.md-custom-controls {
	padding-bottom: 0;
	padding-top: 0;
}

.login-heading {
	margin-top: 0px !important;
}

.md-form-group:first-child {
	margin-bottom: 0px !important;
}
</style>
<c:if test="${ not empty errorMsg }">
	<div class="alert alert-danger alert-dismissible mr-3" style="margin-top: 7px;">
		<button class="close" aria-hidden="true" data-dismiss="alert" type="button">x</button>${errorMsg}
	</div>
</c:if>
<a class="login-brand" href="#">
	<img class="img-responsive"
		src="<%=request.getContextPath()%>/resources/images/fundraising_logo.png"
		alt="Fundraising">
</a>
<h3 class="login-heading text-center">Sign in</h3>
<form:form modelAttribute="userDTO" method="POST" action="logIn.html">
	<div class="login-form">
		<form data-toggle="vmd-validator">
			<div class="md-form-group md-label-floating">
				<label class="md-control-label" for="phoneNo">Phone Number</label>
				<input id="phoneNo" class="md-form-control" type="text" name="phoneNo"
					spellcheck="false" autocomplete="off"
					data-msg-required="Please enter your phone number." aria-required="true"
					required>
			</div>
			<div class="md-form-group md-label-floating">
				<label class="md-control-label" for="password">Password</label>
				<input id="password" class="md-form-control" type="password" name="password"
					data-msg-required="Please enter your password." required>
			</div>
			<div class="errMsg" id="errMsg"></div>
			<div class="md-form-group md-custom-controls">
				<label class="custom-control custom-control-primary custom-checkbox">
					<input class="custom-control-input" type="checkbox" checked="checked">
					<span class="custom-control-indicator"></span>
					<span class="custom-control-label">Keep me signed in</span>
				</label>
				<span aria-hidden="true"> · </span>
				<a href="password-3.html">Forgot password?</a>
			</div>
			<button class="btn btn-primary btn-block" type="submit">Sign in</button>
		</form>
	</div>
</form:form>
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

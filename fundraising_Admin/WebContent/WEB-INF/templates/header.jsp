<%@ include file="../include/importTag.jsp"%>
<div class="layout-header">
	<div class="navbar navbar-default">
		<div class="navbar-header">
			<a class="navbar-brand navbar-brand-center" href="#">
				<span class="d-ib">Fundraising</span>
			</a>
			<button class="navbar-toggler visible-xs-block collapsed" type="button"
				data-toggle="collapse" data-target="#sidenav">
				<span class="sr-only">Toggle navigation</span>
				<span class="bars">
					<span class="bar-line bar-line-1 out"></span>
					<span class="bar-line bar-line-2 out"></span>
					<span class="bar-line bar-line-3 out"></span>
				</span>
				<span class="bars bars-x">
					<span class="bar-line bar-line-4"></span>
					<span class="bar-line bar-line-5"></span>
				</span>
			</button>
			<button class="navbar-toggler visible-xs-block collapsed" type="button"
				data-toggle="collapse" data-target="#navbar">
				<span class="sr-only">Toggle navigation</span>
				<span class="arrow-up"></span>
				<span class="ellipsis ellipsis-vertical">
					<img class="ellipsis-object" width="32" height="32"
						src="<%=request.getContextPath()%>/resources/images/3287670038.jpg"
						alt="Teddy Wilson">
				</span>
			</button>
		</div>
		<div class="navbar-toggleable">
			<nav id="navbar" class="navbar-collapse collapse">
				<button class="sidenav-toggler hidden-xs" title="Collapse sidenav ( [ )"
					aria-expanded="true" type="button">
					<span class="sr-only">Toggle navigation</span>
					<span class="bars">
						<span class="bar-line bar-line-1 out"></span>
						<span class="bar-line bar-line-2 out"></span>
						<span class="bar-line bar-line-3 out"></span>
						<span class="bar-line bar-line-4 in"></span>
						<span class="bar-line bar-line-5 in"></span>
						<span class="bar-line bar-line-6 in"></span>
					</span>
				</button>
				<ul class="nav navbar-nav navbar-right">
					<li class="visible-xs-block">
						<h4 class="navbar-text text-center">Hi, Teddy Wilson</h4>
					</li>
					<li class="dropdown hidden-xs">
						<button class="navbar-account-btn" data-toggle="dropdown"
							aria-haspopup="true">
							<img class="rounded" width="36" height="36"
								src="<%=request.getContextPath()%>/resources/images/fundraising_logo.png"
								alt="Admin">
							${sessionScope.loginUser.userName}
							<span class="caret"></span>
						</button>
						<ul class="dropdown-menu dropdown-menu-right">
							<!--  <li>
                    <a href="upgrade.html">
                      <h5 class="navbar-upgrade-heading">
                        Upgrade Now
                        <small class="navbar-upgrade-notification">You have 15 days left in your trial.</small>
                      </h5>
                    </a>
                  </li> -->
							<!--  <li class="divider"></li> -->
							<!-- <li class="navbar-upgrade-version">Version: 1.0.0</li>
                  <li class="divider"></li>
                  <li><a href="contacts.html">Contacts</a></li>
                  <li><a href="profile.html">Profile</a></li> -->
							<li>
								<a href="logOut.html">Sign out</a>
							</li>
						</ul>
					</li>
					<li class="visible-xs-block">
						<a href="contacts.html">
							<span class="icon icon-users icon-lg icon-fw"></span>
							Contacts
						</a>
					</li>
					<li class="visible-xs-block">
						<a href="profile.html">
							<span class="icon icon-user icon-lg icon-fw"></span>
							Profile
						</a>
					</li>
					<li class="visible-xs-block">
						<a href="logOut.html">
							<span class="icon icon-power-off icon-lg icon-fw"></span>
							Sign out
						</a>
					</li>
				</ul>
			</nav>
		</div>
	</div>
</div>
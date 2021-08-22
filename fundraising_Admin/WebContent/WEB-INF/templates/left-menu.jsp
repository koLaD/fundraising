<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="layout-sidebar-body">
	<div class="custom-scrollable-area"
		style="position: relative; overflow: hidden; width: 100%; height: 100%;">
		<div class="custom-scrollbar"
			style="overflow: hidden; width: 100%; height: 100%;">
			<nav id="sidenav" class="sidenav-collapse collapse">
				<ul class="sidenav">
					<li class="sidenav-search hidden-md hidden-lg">
						<form class="sidenav-form" action="/">
							<div class="form-group form-group-sm">
								<div class="input-with-icon">
									<input class="form-control" type="text" placeholder="Search">
									<span class="icon icon-search input-icon"></span>
								</div>
							</div>
						</form>
					</li>
					<c:forEach var="menu" items="${sessionScope.menuList}" varStatus="status">
						<li
							class="sidenav-item has-subnav ${activeMenu == menu.code ? 'has-subnav active' : 'has-subnav'} ">
							<a href="#" aria-haspopup="true">
								<span class="sidenav-icon ${menu.image}"></span>
								<span class="sidenav-label">${menu.description}</span>
							</a>
							<c:forEach var="subMenu" items="${menu.subMenuDTOList}"
								varStatus="status">
								<ul class="sidenav-subnav collapse" aria-expanded="false">
									<li class="${activeSubMenu == subMenu.code ? 'active' : ''}">
										<a href="${subMenu.url}">${subMenu.description}</a>
									</li>
								</ul>
							</c:forEach>
						</li>
					</c:forEach>
				</ul>
			</nav>
		</div>
		<div class="custom-scrollbar-gripper"
			style="background: rgb(0, 0, 0); width: 6px; position: absolute; top: 0px; opacity: 0.4; display: none; border-radius: 7px; z-index: 99; right: 5px; height: 787px;"></div>
		<div class="custom-scrollbar-track"
			style="width: 6px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; background: rgb(51, 51, 51); opacity: 0.2; z-index: 90; right: 5px;"></div>
	</div>
</div>

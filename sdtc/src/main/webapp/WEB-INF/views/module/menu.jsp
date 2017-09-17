<%@page pageEncoding="UTF-8"%>  
<div class="sidebar" id="sidebar">
	<script type="text/javascript">
		try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
	</script>

	<div class="sidebar-shortcuts" id="sidebar-shortcuts">

		<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
			<span class="btn btn-success"></span>

			<span class="btn btn-info"></span>

			<span class="btn btn-warning"></span>

			<span class="btn btn-danger"></span>
		</div>
	</div><!-- #sidebar-shortcuts -->

	<ul class="nav nav-list" id = "navList">
		<li class="active">
			<a href="../clientLogin/index.do">
				<i class="icon-dashboard"></i>
				<span class="menu-text"> 安居客控制台 </span>
			</a>
		</li>
		<li>
			<a href="#" class="dropdown-toggle">
				<i class="icon-list"></i>
				<span class="menu-text"> 系统管理 </span>

				<b class="arrow icon-angle-down"></b>
			</a>
			<ul class="submenu">
				<li>
					<a href="../user/pageInit.do?menuName='账户管理'&parentMenuName='系统管理' ">
						<i class="icon-double-angle-right"></i>
						账户管理
					</a>
				</li>

				<li>
					<a href="jqgrid.html">
						<i class="icon-double-angle-right"></i>
						充值记录
					</a>
				</li>
                            
                            <li>
					<a href="jqgrid.html">
						<i class="icon-double-angle-right"></i>
						密码设定
					</a>
				</li>
			</ul>
		</li>
		<li >
			<a href="#" class="dropdown-toggle">
				<i class="icon-desktop"></i>
				<span class="menu-text"> 房源管理 </span>
				<b class="arrow icon-angle-down"></b>
			</a>

			<ul class="submenu">
				<li>
					<a href="elements.html">
						<i class="icon-double-angle-right"></i>
						发布房源
					</a>
				</li>

				<li>
					<a href="buttons.html">
						<i class="icon-double-angle-right"></i>
						发布记录
					</a>
				</li>

				<li>
					<a href="treeview.html">
						<i class="icon-double-angle-right"></i>
						刷新记录
					</a>
				</li>

				<li>
					<a href="jquery-ui.html">
						<i class="icon-double-angle-right"></i>
						复制房源
					</a>
				</li>

				<li>
					<a href="nestable-list.html">
						<i class="icon-double-angle-right"></i>
						账号设置
					</a>
				</li>

			</ul>
		</li>
		<li>
			<a href="#" class="dropdown-toggle">
				<i class="icon-edit"></i>
				<span class="menu-text"> 论坛管理 </span>

				<b class="arrow icon-angle-down"></b>
			</a>

			<ul class="submenu">
				<li>
					<a href="form-elements.html">
						<i class="icon-double-angle-right"></i>
						发布公告
					</a>
				</li>

				<li>
					<a href="form-wizard.html">
						<i class="icon-double-angle-right"></i>
						进入论坛
					</a>
				</li>

			</ul>
		</li>

	</ul><!-- /.nav-list -->

	<div class="sidebar-collapse" id="sidebar-collapse">
		<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
	</div>

	<script type="text/javascript">
		try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
	</script>
</div>
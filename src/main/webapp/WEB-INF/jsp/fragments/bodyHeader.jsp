<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${pageContext.request.contextPath}/">Home</a>
		</div>
        <div id="navbar" class="collapse navbar-collapse">
        	<ul class="nav navbar-nav">
        		<li class="dropdown">
        			<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Schedule<span class="caret"></span></a>
        			<ul class="dropdown-menu">
        				<li><a href="${pageContext.request.contextPath}/getSchedule/getScheduleByClassroom.html">By Classroom</a></li>
        				<li><a href="${pageContext.request.contextPath}/getSchedule/getScheduleByGroup.html">By Group</a></li>
        				<li><a href="${pageContext.request.contextPath}/getSchedule/getScheduleByLecturer.html">By Lecturer</a></li>
        			</ul>
        		</li>
        		<li class="dropdown">
        			<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Administration<span class="caret"></span></a>
        			<ul class="dropdown-menu">
        				<li><a href="${pageContext.request.contextPath}/classrooms/list.html">Classrooms</a></li>
        				<li><a href="${pageContext.request.contextPath}/groups/list.html">Groups</a></li>
        				<li><a href="${pageContext.request.contextPath}/lecturers/list.html">Lecturers</a></li>
        				<li><a href="${pageContext.request.contextPath}/lessonintervals/list.html">Lesson Intervals</a></li>
        				<li><a href="${pageContext.request.contextPath}/students/list.html">Students</a></li>
        				<li><a href="${pageContext.request.contextPath}/subjects/list.html">Subjects</a></li>
        				<li><a href="${pageContext.request.contextPath}/schedules/list.html">Schedules</a></li>
        				<li><a href="${pageContext.request.contextPath}/scheduleitems/list.html">Schedule Items</a></li>
        			</ul>
        		</li>
        		<li><a href="${pageContext.request.contextPath}/about.html">About</a></li>
        	</ul>
        </div><!--/.nav-collapse -->
	</div>
</nav>
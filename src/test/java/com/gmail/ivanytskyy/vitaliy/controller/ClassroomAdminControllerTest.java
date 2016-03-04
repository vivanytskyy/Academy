package com.gmail.ivanytskyy.vitaliy.controller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.gmail.ivanytskyy.vitaliy.model.Classroom;
import com.gmail.ivanytskyy.vitaliy.service.ClassroomService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
/*
 * Test class for ClassroomAdminController testing 
 * @author Vitaliy Ivanytskyy
 */
public class ClassroomAdminControllerTest {
	@Mock
	private ClassroomService classroomService;
	@InjectMocks
	private ClassroomAdminController classroomAdminController;
	private MockMvc mockMvc;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(classroomAdminController).build();
	}
	@Test
	public void testShowAllClassrooms() throws Exception{
		List<Classroom> classrooms = new ArrayList<Classroom>();
		Classroom firstClassroom = new Classroom();
		firstClassroom.setName("first");
		Classroom secondClassroom = new Classroom();
		secondClassroom.setName("second");
		classrooms.add(firstClassroom);
		classrooms.add(secondClassroom);
		Collections.sort(classrooms);
		Mockito.when(classroomService.findAll()).thenReturn((List<Classroom>) classrooms);
		mockMvc.perform(get("/classrooms/list"))
			.andExpect(status().isOk())
			.andExpect(view().name("classrooms/classroomsList"))
			.andExpect(model().attribute("classrooms", hasSize(2)));
	}
	@Test
	public void testAddClassroomWithGet() throws Exception{
		Mockito.verifyZeroInteractions(classroomService);
		mockMvc.perform(get("/classrooms/create"))
			.andExpect(status().isOk())
			.andExpect(view().name("classrooms/createClassroom"))
			.andExpect(model().attribute("classroom", instanceOf(Classroom.class)));		
	}
	@Test
	public void testAddClassroomWithPostSuccess() throws Exception{
		long id = 1L;
		String name = "classroom 1";
		Classroom classroom = new Classroom();
		classroom.setName(name);
		classroom.setId(id);		
		Mockito.when(classroomService.create(classroom)).thenReturn(classroom);
		mockMvc.perform(post("/classrooms/create")
				.param("name", name))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:create.html"))
			.andExpect(model().attribute("classroom", instanceOf(Classroom.class)));		
	}
	@Test
	public void testAddClassroomWithPostHasError() throws Exception{
		long id = 1L;
		String name = "";
		Classroom classroom = new Classroom();
		classroom.setName(name);
		classroom.setId(id);
		Mockito.when(classroomService.create(classroom)).thenReturn(classroom);
		mockMvc.perform(post("/classrooms/create")
				.param("name", name))
			.andExpect(status().isOk())
			.andExpect(view().name("classrooms/createClassroom"))
			.andExpect(model().attribute("classroom", instanceOf(Classroom.class)));		
	}
	@Test
	public void testAddClassroomWithPostNotUniqueNameCase() throws Exception{
		boolean result = true;
		long id = 1L;
		String name = "classroom 1";
		Classroom classroom = new Classroom();		
		classroom.setName(name);
		classroom.setId(id);
		Mockito.when(classroomService.isExistsWithName(classroom.getName())).thenReturn(result);
		mockMvc.perform(post("/classrooms/create")
				.param("name", name))
			.andExpect(status().isOk())
			.andExpect(view().name("classrooms/createClassroom"))
			.andExpect(model().attribute("classroom", instanceOf(Classroom.class)));		
	}
	@Test
	public void testUpdateClassroomWithGetSuccess() throws Exception{
		long id = 1L;
		String name = "classroom 1";
		Classroom classroom = new Classroom();
		classroom.setId(id);
		classroom.setName(name);
		Mockito.when(classroomService.findById(id)).thenReturn(classroom);
		mockMvc.perform(get("/classrooms/{id}/edit", id))
			.andExpect(status().isOk())
			.andExpect(view().name("classrooms/updateClassroom"))
			.andExpect(model().attribute("classroom", instanceOf(Classroom.class)));		
	}
	@Test
	public void testUpdateClassroomWithGetNonexistentId() throws Exception{
		long id = 1L;
		Classroom classroom = null;
		Mockito.when(classroomService.findById(id)).thenReturn(classroom);
		mockMvc.perform(get("/classrooms/{id}/edit", id))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/classrooms/list.html"));		
	}
	@Test
	public void testUpdateClassroomWithPostSuccess() throws Exception{
		long id = 2L;
		String name = "classroom 1";
		Classroom classroom = new Classroom();
		classroom.setId(id);
		classroom.setName(name);
		Mockito.when(classroomService.create(classroom)).thenReturn(classroom);
		mockMvc.perform(post("/classrooms/{id}/edit", id)
				.param("name", name)
				.param("id", String.valueOf(id)))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/classrooms/{id}/edit"))
			.andExpect(model().attribute("classroom", instanceOf(Classroom.class)));
	}
	@Test
	public void testUpdateClassroomWithPostHasError() throws Exception{
		long id = 1L;
		String name = "";
		Classroom classroom = new Classroom();
		classroom.setName(name);
		classroom.setId(id);
		Mockito.when(classroomService.create(classroom)).thenReturn(classroom);
		mockMvc.perform(post("/classrooms/{id}/edit", id)
				.param("name", name))
			.andExpect(status().isOk())
			.andExpect(view().name("classrooms/updateClassroom"))
			.andExpect(model().attribute("classroom", instanceOf(Classroom.class)));		
	}
	@Test
	public void testUpdateClassroomWithPostNotUniqueNameCase() throws Exception{
		boolean result = true;
		long id = 1L;
		String name = "classroom 1";
		Classroom classroom = new Classroom();		
		classroom.setName(name);
		classroom.setId(id);
		Mockito.when(classroomService.isExistsWithName(classroom.getName())).thenReturn(result);
		mockMvc.perform(post("/classrooms/{id}/edit", id)
				.param("name", name))
			.andExpect(status().isOk())
			.andExpect(view().name("classrooms/updateClassroom"))
			.andExpect(model().attribute("classroom", instanceOf(Classroom.class)));		
	}
	@Test
	public void testDeleteClassroomWithPostSuccess() throws Exception{
		long id = 1L;
		mockMvc.perform(post("/classrooms/delete")
				.param("id", String.valueOf(id)))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:list.html"));
	}	
}
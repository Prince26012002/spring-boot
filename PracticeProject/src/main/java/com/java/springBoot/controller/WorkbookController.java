package com.java.springBoot.controller;

import javax.ws.rs.GET;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.springBoot.annotation.MyCustomAutowired;
import com.java.springBoot.entity.Workbook;
import com.java.springBoot.repository.WorkbookRepository;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RestController
//@MyCustomComponent
@RequestMapping("/workbook")
public class WorkbookController {

	@MyCustomAutowired
	private WorkbookRepository workbookRepository;

//	@Autowired
//	private ApplicationContext applicationContext;

	@GET
	@Path("/get")
	public Workbook getWorkbook() {
		System.out.println("hello");
		return new Workbook();
	}

	@PostMapping
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Workbook createWorkbook(@RequestBody Workbook workbook) {
		return workbookRepository.createEntity(workbook);
	}

	@PutMapping
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Workbook updateWorkbook(@RequestBody Workbook workbook) {
		return workbookRepository.updateEntity(workbook);
	}

}

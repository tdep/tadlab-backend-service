package com.tdep.tadlab.backendservice.controllers;



import com.tdep.tadlab.backendservice.data.dao.JobDAO;
import com.tdep.tadlab.backendservice.models.Job;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class JobsController {

  @Autowired
  private JobDAO jobDAO;

  @RequestMapping(value = "/editJob", method = RequestMethod.GET)
  public ModelAndView editJob(HttpServletRequest request) throws SQLException {
    int jobId = Integer.parseInt(request.getParameter("id"));
    Job job = jobDAO.get(jobId);
    ModelAndView model = new ModelAndView("JobForm");
    model.addObject("job", job);

    return model;
  }

  @RequestMapping(value="/jobs", method = RequestMethod.GET)
  public ModelAndView jobList (ModelAndView model) throws IOException, SQLException {
    List<Job> jobList = jobDAO.getAll();
    model.addObject("jobList", jobList);
    model.setViewName("jobs");

    return model;
  }

  @RequestMapping(value = "/newJob", method = RequestMethod.GET)
  public ModelAndView newJob(ModelAndView model) throws SQLException {
    Job newJob = new Job();
    model.addObject("job", newJob);
    model.setViewName("JobForm");
    return model;
  }

  @RequestMapping(value = "/saveJob", method = RequestMethod.POST)
  public ModelAndView saveJob(@ModelAttribute Job job) throws SQLException {
    jobDAO.insertOrUpdate(job);
    return new ModelAndView("redirect:/");
  }

  @RequestMapping(value = "/deleteJob", method = RequestMethod.GET)
  public ModelAndView deleteJob(HttpServletRequest request) throws SQLException {
    int jobId = Integer.parseInt(request.getParameter("id"));
    jobDAO.delete(jobId);
    return new ModelAndView("redirect:/");
  }
}

package io.openshift.booster.http;

import java.net.MalformedURLException;
import java.net.URL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonObject;

import org.eclipse.microprofile.rest.client.RestClientBuilder;

@ApplicationScoped
@Path("/")
public class ProjectEndpoint {

	String thisURL="http://projectservice-vertx-freelancer4j-projects.1d35.starter-us-east-1.openshiftapps.com";
	
    @GET
    @Path("/projects")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getAllProjects() throws MalformedURLException {
    	URL url = new URL(thisURL);
        ProjectService projectService = RestClientBuilder.newBuilder().baseUrl(url).build(ProjectService.class);
        return projectService.getAllProjects();
    }
    
    @GET
    @Path("/projects/{projectId}")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getOneProject(@PathParam("projectId") String projectId) throws MalformedURLException {
    	URL url = new URL(thisURL);
        ProjectService projectService = RestClientBuilder.newBuilder().baseUrl(url).build(ProjectService.class);
        return projectService.getOneProject(projectId);
    }
    
    @GET
    @Path("/projects/status/{thisStatus}")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getProjectsByStatus(@PathParam("thisStatus") String thisStatus) throws MalformedURLException {
    	URL url = new URL(thisURL);
        ProjectService projectService = RestClientBuilder.newBuilder().baseUrl(url).build(ProjectService.class);
        return projectService.getProjectsByStatus(thisStatus);
    }
}

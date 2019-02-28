package io.openshift.booster.http;

import java.net.MalformedURLException;
import java.net.URL;

import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.RestClientBuilder;

@ApplicationScoped
@Path("/")
public class FreelancerEndpoint {
	
	String thisURL="http://freelancerservice-springboot-smiling-door.b9ad.pro-us-east-1.openshiftapps.com";

    @GET
    @Path("/freelancers")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray getAllFreelancers() throws MalformedURLException {
        URL url = new URL(thisURL);
        FreelancerService freelancerService = RestClientBuilder.newBuilder().baseUrl(url).build(FreelancerService.class);
        return freelancerService.getAllFreelancers();
    }
    
    @GET
    @Path("/freelancers/{freelancerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getFreelancerById(@PathParam("freelancerId") String freelancerId) throws MalformedURLException {
        URL url = new URL(thisURL);
        FreelancerService freelancerService = RestClientBuilder.newBuilder().baseUrl(url).build(FreelancerService.class);
        return freelancerService.getFreelancerById(freelancerId);
    }
    
}

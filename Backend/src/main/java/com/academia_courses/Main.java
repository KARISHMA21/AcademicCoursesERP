package com.academia_courses;

import com.academia_courses.util.CORSFilter;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
// Note that the class extends ResourceConfig and not Application because we want to make use of register()
public class Main extends ResourceConfig {
    public Main() {
        // Registering the CORSFilter class with the Jersey ResourceConfig
        register(CORSFilter.class);

        // Telling Jersey the CLASSPATH where the specified classes (in our case, CORSFilter) can be found
        packages("com.academia_courses;");
    }
}
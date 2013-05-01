package org.jboss.as.tasksJsf;

import java.io.File;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;

public class DefaultDeployment {

    private static final String WEBAPP_SRC = "src/main/webapp";

    private WebArchive webArchive;

    public DefaultDeployment() {
        webArchive = ShrinkWrap.create(WebArchive.class, "test.war").addAsWebInfResource(
                new File(WEBAPP_SRC, "WEB-INF/beans.xml"));
    }

    public DefaultDeployment withPersistence() {
        webArchive = webArchive.addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml").addAsWebInfResource(
                "test-ds.xml", "test-ds.xml");
        return this;
    }

    public DefaultDeployment withImportedData() {
        webArchive = webArchive.addAsResource("import.sql");
        return this;
    }

    public DefaultDeployment withFaces() {
        webArchive = webArchive.addAsWebInfResource(new File(WEBAPP_SRC, "WEB-INF/faces-config.xml"));
        return this;
    }

    public WebArchive getArchive() {
        return webArchive;
    }
}

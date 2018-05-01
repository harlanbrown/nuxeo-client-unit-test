package org.nuxeo.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nuxeo.client.api.NuxeoClient;
import org.nuxeo.client.api.objects.Document;
import org.nuxeo.client.api.objects.Documents;
import org.nuxeo.client.api.objects.Repository;
import org.nuxeo.ecm.automation.test.AutomationFeature;
import org.nuxeo.ecm.automation.test.EmbeddedAutomationServerFeature;
import org.nuxeo.ecm.core.test.CoreFeature;
import org.nuxeo.ecm.core.test.annotations.Granularity;
import org.nuxeo.ecm.core.test.annotations.RepositoryConfig;
import org.nuxeo.ecm.platform.test.PlatformFeature;
import org.nuxeo.ecm.restapi.test.RestServerFeature;
import org.nuxeo.runtime.test.runner.Deploy;
import org.nuxeo.runtime.test.runner.Features;
import org.nuxeo.runtime.test.runner.FeaturesRunner;
import org.nuxeo.runtime.test.runner.Jetty;
import org.nuxeo.runtime.test.runner.RuntimeFeature;

@RunWith(FeaturesRunner.class)
//@Features({PlatformFeature.class,AutomationFeature.class})
//@Features(EmbeddedAutomationServerFeature.class)
@Features({PlatformFeature.class,RestServerFeature.class})
@Jetty(port = 18080)
@RepositoryConfig(cleanup = Granularity.METHOD)
@Deploy({
    "org.nuxeo.ecm.platform.content.template"
})

public class TestWithNuxeoClient {

    @Test
    public void TestClient() throws Exception {
        NuxeoClient nuxeoClient = new NuxeoClient("http://localhost:8080/nuxeo","Administrator","Administrator");
        Repository repository = nuxeoClient.repository();
        Document d = repository.fetchDocumentByPath("/default-domain");
//        Document d = repository.fetchDocumentByPath("/default-domain/workspaces");
//        Document d = nuxeoClient.automation("Repository.GetDocument").param("value","").execute();

    }
}

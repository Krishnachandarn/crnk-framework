package io.crnk.internal.boot.cdi;

import io.crnk.cdi.internal.CdiServiceDiscovery;
import io.crnk.core.module.discovery.DefaultServiceDiscoveryFactory;
import io.crnk.core.module.discovery.ServiceDiscovery;
import io.crnk.core.repository.Repository;
import io.crnk.internal.boot.cdi.model.ProjectRepository;
import io.crnk.internal.boot.cdi.model.TaskRepository;
import io.crnk.legacy.repository.annotations.JsonApiResourceRepository;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@RunWith(CdiTestRunner.class)
@ApplicationScoped
public class CdiServiceDiscoveryTest {

	@Test
	public void testFactory() {
		DefaultServiceDiscoveryFactory factory = new DefaultServiceDiscoveryFactory();
		ServiceDiscovery instance = factory.getInstance();
		Assert.assertNotNull(instance);
		Assert.assertEquals(CdiServiceDiscovery.class, instance.getClass());

		List<?> repositories = instance.getInstancesByType(Repository.class);
		Assert.assertEquals(1, repositories.size());
		Assert.assertTrue(repositories.get(0) instanceof ProjectRepository);

		repositories = instance.getInstancesByAnnotation(JsonApiResourceRepository.class);
		Assert.assertEquals(1, repositories.size());
		Assert.assertTrue(repositories.get(0) instanceof TaskRepository);
	}
}
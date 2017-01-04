package fr.inria.atlanmod.mogwai.query;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.lang.reflect.Field;

import org.eclipse.emf.ecore.resource.Resource;

import fr.inria.atlanmod.mogwai.resources.MogwaiResourceDecorator;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackend;
import fr.inria.atlanmod.neoemf.resource.DefaultPersistentResource;
import fr.inria.atlanmod.neoemf.resource.PersistentResource;

public class MogwaiATLQuery extends MogwaiQuery {
	
	private Resource atlResource;
	private PersistentResource inputResource;
	private PersistentResource outputResource;
	
	public MogwaiATLQuery(Resource atlResource, PersistentResource inputResource, PersistentResource outputResource) {
		super(atlResource);
		checkNotNull(inputResource, "Null input resource");
		checkNotNull(outputResource, "Null output resource");
		this.atlResource = atlResource;
		this.inputResource = inputResource;
		this.outputResource = outputResource;
	}

	@Override
	public String getInput() {
		return atlResource.toString();
	}
	
	public Resource getATLResource() {
		return atlResource;
	}
	
	public PersistentResource getInputResource() {
		return inputResource;
	}
	
	public PersistentResource getOutputResource() {
		return outputResource;
	}
	
	public BlueprintsPersistenceBackend getInputGraph() {
		return getInnerGraph(inputResource);
	}
	
	public BlueprintsPersistenceBackend getOutputGraph() {
		return getInnerGraph(outputResource);
	}
	
	private BlueprintsPersistenceBackend getInnerGraph(PersistentResource pResource) {
		checkArgument(pResource instanceof DefaultPersistentResource || pResource instanceof MogwaiResourceDecorator,
				"Given resource is not an instance of DefaultPersistentResource or MogwaiResourceDecorator");
		try {
			Field f = null;
			if(pResource instanceof DefaultPersistentResource) {
				System.out.println("default");
				f = DefaultPersistentResource.class.getDeclaredField("persistenceBackend");
			} else if (pResource instanceof MogwaiResourceDecorator) {
				System.out.println("mog");
				f = MogwaiResourceDecorator.class.getDeclaredField("persistenceBackend");
			} else {
				throw new MogwaiQueryException(
						"Given resource is not an instance of DefaultPersistentResource or MogwaiResourceDecorator");
			}
			f.setAccessible(true);
			Object r = f.get(pResource);
			checkArgument(r instanceof BlueprintsPersistenceBackend, "The field is not a BlueprintsPersistenceBackend");
			return (BlueprintsPersistenceBackend) r;
		} catch(NoSuchFieldException e) {
			throw new MogwaiQueryException(e.getMessage());
		} catch(SecurityException e) {
			throw new MogwaiQueryException(e.getMessage());
		} catch(IllegalAccessException e) {
			throw new MogwaiQueryException(e.getMessage());
		}
		
	}

}
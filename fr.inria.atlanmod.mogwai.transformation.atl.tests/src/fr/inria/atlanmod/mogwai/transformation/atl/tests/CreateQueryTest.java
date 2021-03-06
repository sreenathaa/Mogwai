package fr.inria.atlanmod.mogwai.transformation.atl.tests;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.atl.emftvm.compiler.AtlResourceFactoryImpl;

import fr.inria.atlanmod.mogwai.datastore.blueprints.NeoEMFGraphDatastore;
import fr.inria.atlanmod.mogwai.neoemf.resource.MogwaiResource;
import fr.inria.atlanmod.mogwai.processor.ATLQueryProcessor;
import fr.inria.atlanmod.mogwai.query.ATLQuery;
import fr.inria.atlanmod.mogwai.query.QueryResult;
import fr.inria.atlanmod.mogwai.query.builder.ATLQueryBuilder;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackend;

public class CreateQueryTest {

	public static void main(String[] args) throws IOException {
		
		MogwaiResource mogResource = ModelUtil.getInstance().createSampleModel();
		
		URI transformationURI = URI.createURI("materials/ClassDiagram2Relational/ATLFiles/Class2Relational.atl");
//		URI inputURI = BlueprintsURI.createFileURI(new File("materials/ClassDiagram2Relational/ClassDiagram/sample.graphdb"));
		
		ATLQuery query = (ATLQuery) ATLQueryBuilder.newBuilder().fromURI(transformationURI).build();
		
		Resource atlResource = query.getATLResource();
		
		ResourceSet rSet = new ResourceSetImpl();
		rSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		rSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		rSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("atl", new AtlResourceFactoryImpl());
		Resource newResource = rSet.createResource(URI.createURI("materials/ClassDiagram2Relational/ATLFiles/atlModel.xmi"));
		
		newResource.getContents().addAll(EcoreUtil.copyAll(atlResource.getContents()));
		
		newResource.save(Collections.emptyMap());
		
		ATLQueryProcessor processor = new ATLQueryProcessor();
		QueryResult result = query.process(processor, new NeoEMFGraphDatastore(mogResource.getBackend().getGraph()), null);
		
		System.out.println("Created Script");
		System.out.println(result.getExecutedQuery());
//		
		mogResource.close();
	}
	
}

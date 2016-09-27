/**
 *
 * $Id$
 */
package fr.inria.atlanmod.mogwai.gremlin.validation;

import fr.inria.atlanmod.mogwai.gremlin.Instruction;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link fr.inria.atlanmod.mogwai.gremlin.Closure}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ClosureValidator {
	boolean validate();

	boolean validateInstructions(EList<Instruction> value);
}
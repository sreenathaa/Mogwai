/**
 */
package fr.inria.atlanmod.mogwai.gremlin.impl;

import fr.inria.atlanmod.mogwai.gremlin.GremlinPackage;
import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.mogwai.gremlin.Instruction;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Script</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.inria.atlanmod.mogwai.gremlin.impl.GremlinScriptImpl#getInstructions <em>Instructions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GremlinScriptImpl extends MinimalEObjectImpl.Container implements GremlinScript {
	/**
     * The cached value of the '{@link #getInstructions() <em>Instructions</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getInstructions()
     * @generated
     * @ordered
     */
	protected EList<Instruction> instructions;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected GremlinScriptImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return GremlinPackage.Literals.GREMLIN_SCRIPT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Instruction> getInstructions() {
        if (instructions == null) {
            instructions = new EObjectContainmentEList<Instruction>(Instruction.class, this, GremlinPackage.GREMLIN_SCRIPT__INSTRUCTIONS);
        }
        return instructions;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String toString() {
        StringBuffer sb = new StringBuffer();
        for(Instruction i : getInstructions()) {
            sb.append(i.toString()+";\n");
        }
        return sb.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case GremlinPackage.GREMLIN_SCRIPT__INSTRUCTIONS:
                return ((InternalEList<?>)getInstructions()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case GremlinPackage.GREMLIN_SCRIPT__INSTRUCTIONS:
                return getInstructions();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case GremlinPackage.GREMLIN_SCRIPT__INSTRUCTIONS:
                getInstructions().clear();
                getInstructions().addAll((Collection<? extends Instruction>)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public void eUnset(int featureID) {
        switch (featureID) {
            case GremlinPackage.GREMLIN_SCRIPT__INSTRUCTIONS:
                getInstructions().clear();
                return;
        }
        super.eUnset(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public boolean eIsSet(int featureID) {
        switch (featureID) {
            case GremlinPackage.GREMLIN_SCRIPT__INSTRUCTIONS:
                return instructions != null && !instructions.isEmpty();
        }
        return super.eIsSet(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
        switch (operationID) {
            case GremlinPackage.GREMLIN_SCRIPT___TO_STRING:
                return toString();
        }
        return super.eInvoke(operationID, arguments);
    }

} //GremlinScriptImpl
package plantumlgenerator.visitor;

import padl.kernel.IAbstractModel;
import padl.kernel.IAggregation;
import padl.kernel.IAssociation;
import padl.kernel.IClass;
import padl.kernel.IComposition;
import padl.kernel.IConstituent;
import padl.kernel.IConstructor;
import padl.kernel.IContainerAggregation;
import padl.kernel.IContainerComposition;
import padl.kernel.ICreation;
import padl.kernel.IDelegatingMethod;
import padl.kernel.IField;
import padl.kernel.IGetter;
import padl.kernel.IGhost;
import padl.kernel.IInterface;
import padl.kernel.IMemberClass;
import padl.kernel.IMemberGhost;
import padl.kernel.IMemberInterface;
import padl.kernel.IMethod;
import padl.kernel.IMethodInvocation;
import padl.kernel.IPackage;
import padl.kernel.IPackageDefault;
import padl.kernel.IParameter;
import padl.kernel.IPrimitiveEntity;
import padl.kernel.ISetter;
import padl.kernel.IUseRelationship;
import padl.visitor.IWalker;

public class PlantUmlWalker implements IWalker {

	@Override
	public void close(IAbstractModel arg0) {
		System.out.println(arg0);
	}

	@Override
	public void close(IClass arg0) {
		System.out.println(arg0);
		
	}

	@Override
	public void close(IConstructor arg0) {
		System.out.println(arg0);
		
	}

	@Override
	public void close(IDelegatingMethod arg0) {
		System.out.println(arg0);
		
	}

	@Override
	public void close(IGetter arg0) {
		System.out.println(arg0);
		
	}

	@Override
	public void close(IGhost arg0) {
		System.out.println(arg0);
		
	}

	@Override
	public void close(IInterface arg0) {
		System.out.println(arg0);
		
	}

	@Override
	public void close(IMemberClass arg0) {
		System.out.println(arg0);		
	}

	@Override
	public void close(IMemberGhost arg0) {
		System.out.println(arg0);		
	}

	@Override
	public void close(IMemberInterface arg0) {
		System.out.println(arg0);		
	}

	@Override
	public void close(IMethod arg0) {
		System.out.println(arg0);		
	}

	@Override
	public void close(IPackage arg0) {
		System.out.println(arg0);		
	}

	@Override
	public void close(IPackageDefault arg0) {
		System.out.println(arg0);		
	}

	@Override
	public void close(ISetter arg0) {
		System.out.println(arg0);		
	}

	@Override
	public String getName() {
		return "PlantUmlVisitor";
	}

	@Override
	public void open(IAbstractModel arg0) {
		System.out.println(arg0);
		
	}

	@Override
	public void open(IClass arg0) {
		System.out.println(arg0);
		
	}

	@Override
	public void open(IConstructor arg0) {
		System.out.println(arg0);
		
	}

	@Override
	public void open(IDelegatingMethod arg0) {
		System.out.println(arg0);
		
	}

	@Override
	public void open(IGetter arg0) {
		System.out.println(arg0);
		
	}

	@Override
	public void open(IGhost arg0) {
		System.out.println(arg0);
		
	}

	@Override
	public void open(IInterface arg0) {
		System.out.println(arg0);
		
	}

	@Override
	public void open(IMemberClass arg0) {
		System.out.println(arg0);
		
	}

	@Override
	public void open(IMemberGhost arg0) {
		System.out.println(arg0);
		
	}

	@Override
	public void open(IMemberInterface arg0) {
		System.out.println(arg0);
		
	}

	@Override
	public void open(IMethod arg0) {
		System.out.println(arg0);
		
	}

	@Override
	public void open(IPackage arg0) {
		System.out.println(arg0);
		
	}

	@Override
	public void open(IPackageDefault arg0) {
		System.out.println(arg0);
		
	}

	@Override
	public void open(ISetter arg0) {
		System.out.println(arg0);
		
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unknownConstituentHandler(String arg0, IConstituent arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(IAggregation arg0) {
		System.out.println(arg0);
		
	}

	@Override
	public void visit(IAssociation arg0) {
		System.out.println(arg0);
		
	}

	@Override
	public void visit(IComposition arg0) {
		System.out.println(arg0);
		
	}

	@Override
	public void visit(IContainerAggregation arg0) {
		System.out.println(arg0);
		
	}

	@Override
	public void visit(IContainerComposition arg0) {
		System.out.println(arg0);
		
	}

	@Override
	public void visit(ICreation arg0) {
		System.out.println(arg0);
		
	}

	@Override
	public void visit(IField arg0) {
		System.out.println(arg0);
		
	}

	@Override
	public void visit(IMethodInvocation arg0) {
		System.out.println(arg0);
		
	}

	@Override
	public void visit(IParameter arg0) {
		System.out.println(arg0);
		
	}

	@Override
	public void visit(IPrimitiveEntity arg0) {
		System.out.println(arg0);
		
	}

	@Override
	public void visit(IUseRelationship arg0) {
		System.out.println(arg0);
		
	}

	@Override
	public Object getResult() {
		// TODO Auto-generated method stub
		return null;
	}

}

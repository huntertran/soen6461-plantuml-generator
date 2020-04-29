package plantumlgenerator.visitor;

import java.util.Iterator;

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
import padl.kernel.IFirstClassEntity;
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
import plantumlgenerator.utils.StringUtils;

abstract class PlantUmlWalker {

    protected final StringBuffer buffer = new StringBuffer();
    protected final StringBuffer relationships = new StringBuffer();
    protected int indent = 0;

    public void close(IAbstractModel arg0) {
        StringUtils.addNewLine(buffer);

        this.buffer.append(this.relationships.toString());

        StringUtils.addNewLine(buffer);
        StringUtils.addNewLine(buffer);

        this.buffer.append("@enduml");
    }

    public void close(IClass arg0) {
        System.out.print("Close ");
        System.out.println(arg0);
        StringUtils.addNewLine(buffer);
        StringUtils.addTabs(this.indent, buffer);
        this.buffer.append("}");
    }

    public void close(IConstructor arg0) {
        System.out.print("Close ");
        System.out.println(arg0);

    }

    public void close(IDelegatingMethod arg0) {
        System.out.print("Close ");
        System.out.println(arg0);

    }

    public void close(IGetter arg0) {
        System.out.print("Close ");
        System.out.println(arg0);

    }

    public void close(IGhost arg0) {
        System.out.print("Close ");
        System.out.println(arg0);
        StringUtils.addNewLine(buffer);
        StringUtils.addTabs(this.indent, buffer);
        this.buffer.append("}");
    }

    public void close(IInterface arg0) {
        System.out.print("Close ");
        System.out.println(arg0);
        StringUtils.addNewLine(buffer);
        StringUtils.addTabs(this.indent, buffer);
        this.buffer.append("}");
    }

    public void close(IMemberClass arg0) {
        System.out.print("Close ");
        System.out.println(arg0);
    }

    public void close(IMemberGhost arg0) {
        System.out.print("Close ");
        System.out.println(arg0);
    }

    public void close(IMemberInterface arg0) {
        System.out.print("Close ");
        System.out.println(arg0);
    }

    public void close(IMethod arg0) {
        System.out.print("Close ");
        System.out.println(arg0);
    }

    public void close(IPackage arg0) {
        System.out.print("Close ");
        System.out.println(arg0);

        StringUtils.addNewLine(buffer);
        this.indent--;
        StringUtils.addTabs(this.indent, buffer);
        this.buffer.append("}");
    }

    public void close(IPackageDefault arg0) {
        System.out.print("Close ");
        System.out.println(arg0);

        StringUtils.addNewLine(buffer);
        this.indent--;
        StringUtils.addTabs(this.indent, buffer);
        this.buffer.append("}");
    }

    public void close(ISetter arg0) {
        System.out.print("Close ");
        System.out.println(arg0);
    }

    public String getName() {
        return "PlantUmlVisitor";
    }

    public void open(IAbstractModel arg0) {
        this.buffer.append("@startuml test");
        StringUtils.addNewLine(buffer);
        StringUtils.addNewLine(buffer);
        this.buffer.append("hide empty members");
        StringUtils.addNewLine(buffer);
        this.buffer.append("skinparam linetype ortho");
        StringUtils.addNewLine(buffer);
    }

    public void open(IClass arg0) {
        System.out.print("Open ");
        System.out.println(arg0);

        String className = String.valueOf(arg0.getName());

        StringUtils.addNewLine(buffer);
        StringUtils.addNewLine(buffer);
        StringUtils.addTabs(this.indent, this.buffer);
        this.buffer.append("class " + className + " {");
        StringUtils.addNewLine(buffer);
        
        int test = arg0.getNumberOfConstituents();

        StringUtils.addNewLine(relationships);

        Iterator<?> iterator = arg0.getIteratorOnInheritedEntities();
        if (iterator.hasNext()) {
            while (iterator.hasNext()) {

                IFirstClassEntity entity = (IFirstClassEntity) iterator.next();

                if (entity instanceof Object) {
                    continue;
                }

                StringUtils.addNewLine(relationships);
                this.relationships.append(className);
                // extends relationship

                this.relationships.append(" --^ ");
                this.relationships.append(entity.getName());
                if (iterator.hasNext()) {
                    StringUtils.addNewLine(relationships);
                }
            }
        }

        iterator = arg0.getIteratorOnImplementedInterfaces();
        if (iterator.hasNext()) {
            while (iterator.hasNext()) {
                StringUtils.addNewLine(relationships);
                this.relationships.append(className);
                // implement relationship
                this.relationships.append(" ..^ ");
                this.relationships.append(((IFirstClassEntity) (iterator.next())).getName());
                if (iterator.hasNext()) {
                    StringUtils.addNewLine(relationships);
                }
            }
        }
    }

    public void open(IConstructor arg0) {
        System.out.print("Open ");
        System.out.println(arg0);

    }

    public void open(IDelegatingMethod arg0) {
        System.out.print("Open ");
        System.out.println(arg0);

    }

    public void open(IGetter arg0) {
        System.out.print("Open ");
        System.out.println(arg0);

    }

    public void open(IGhost arg0) {
        System.out.print("Open ");
        System.out.println(arg0);

        StringUtils.addNewLine(buffer);
        StringUtils.addTabs(this.indent, this.buffer);
        this.buffer.append("class " + String.valueOf(arg0.getName()) + " {");
        StringUtils.addNewLine(buffer);
    }

    public void open(IInterface arg0) {
        System.out.print("Open ");
        System.out.println(arg0);

        String interfaceName = String.valueOf(arg0.getName());

        StringUtils.addNewLine(buffer);
        StringUtils.addNewLine(buffer);
        StringUtils.addTabs(this.indent, this.buffer);
        this.buffer.append("interface " + interfaceName + " {");
        StringUtils.addNewLine(buffer);

        Iterator<?> iterator = arg0.getIteratorOnConstituents();
        if (iterator.hasNext()) {
            while (iterator.hasNext()) {
                IConstituent constituent = (IConstituent) iterator.next();
                System.out.println(constituent);
            }

        }

        StringUtils.addNewLine(relationships);

        iterator = arg0.getIteratorOnInheritingEntities();
        if (iterator.hasNext()) {
            while (iterator.hasNext()) {

                IFirstClassEntity entity = (IFirstClassEntity) iterator.next();

                StringUtils.addNewLine(relationships);
                this.relationships.append(entity.getName());
                // extends relationship
                this.relationships.append(" --^ ");
                this.relationships.append(interfaceName);
                if (iterator.hasNext()) {
                    StringUtils.addNewLine(relationships);
                }
            }
        }
    }

    public void open(IMemberClass arg0) {
        System.out.print("Open ");
        System.out.println(arg0);
    }

    public void open(IMemberGhost arg0) {
        System.out.print("Open ");
        System.out.println(arg0);

    }

    public void open(IMemberInterface arg0) {
        System.out.print("Open ");
        System.out.println(arg0);
    }

    public void open(IMethod arg0) {
        System.out.print("Open ");
        System.out.println(arg0);

    }

    public void open(IPackage arg0) {
        System.out.print("Open ");
        System.out.println(arg0);

        StringUtils.addNewLine(buffer);
        StringUtils.addTabs(this.indent, buffer);
        this.buffer.append("package " + String.valueOf(arg0.getName()) + " {");
        this.indent++;
    }

    public void open(IPackageDefault arg0) {
        System.out.print("Open ");
        System.out.println(arg0);

        StringUtils.addNewLine(buffer);
        StringUtils.addTabs(this.indent, buffer);
        this.buffer.append("package " + String.valueOf(arg0.getName()) + " {");
        this.indent++;

    }

    public void open(ISetter arg0) {
        System.out.print("Open ");
        System.out.println(arg0);

    }

    public void reset() {
        System.out.print("RESET");
        this.buffer.setLength(0);
        this.indent = 0;
    }

    public void unknownConstituentHandler(String arg0, IConstituent arg1) {
        // TODO Auto-generated method stub

    }

    public void visit(IAggregation arg0) {
        System.out.print("Visit ");
        System.out.println(arg0);

    }

    public void visit(IAssociation arg0) {
        System.out.print("Visit ");
        System.out.println(arg0);

    }

    public void visit(IComposition arg0) {
        System.out.print("Visit ");
        System.out.println(arg0);

    }

    public void visit(IContainerAggregation arg0) {
        System.out.print("Visit ");
        System.out.println(arg0);

    }

    public void visit(IContainerComposition arg0) {
        System.out.print("Visit ");
        System.out.println(arg0);

    }

    public void visit(ICreation arg0) {
        System.out.print("Visit ");
        System.out.println(arg0);

    }

    public void visit(IField arg0) {
        System.out.print("Visit ");
        System.out.println(arg0);

    }

    public void visit(IMethodInvocation arg0) {
        System.out.print("Visit ");
        System.out.println(arg0);

    }

    public void visit(IParameter arg0) {
        System.out.print("Visit ");
        System.out.println(arg0);

    }

    public void visit(IPrimitiveEntity arg0) {
        System.out.print("Visit ");
        System.out.println(arg0);

    }

    public void visit(IUseRelationship arg0) {
        System.out.print("Visit ");
        System.out.println(arg0);

    }

    public Object getResult() {
        // TODO Auto-generated method stub
        return null;
    }

}

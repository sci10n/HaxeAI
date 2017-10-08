package se.sciion.quake2d.ai.behaviour;

import static guru.nidi.graphviz.model.Factory.*;
import guru.nidi.graphviz.attribute.Color;
import guru.nidi.graphviz.attribute.Shape;
import guru.nidi.graphviz.attribute.Style;

import guru.nidi.graphviz.model.Label;
import guru.nidi.graphviz.model.Node;

public class InverterNode extends DecoratorNode {
    private static int inverterNodeId = 0;

    public InverterNode(BehaviourNode behaviour) {
        super(behaviour);
    }

    @Override
    protected void onEnter() {
    	setStatus(BehaviourStatus.RUNNING);
    }

    @Override
    protected BehaviourStatus onUpdate() {
        setStatus(child.tick());
        if(child.getStatus() == BehaviourStatus.SUCCESS) {
        	setStatus(BehaviourStatus.FAILURE);
        } else if(child.getStatus() == BehaviourStatus.FAILURE) {
        	setStatus(BehaviourStatus.SUCCESS);
        }

        return getStatus();
    }

    @Override
    public Node toDotNode() {
        return node("inverter" + inverterNodeId++)
               .with(Shape.DIAMOND)
				.with(Style.FILLED, Color.rgb(getColor()).fill(), Color.BLACK.radial())
               .with(Label.of("Inverter"))
               .link(child.toDotNode());
    }

}
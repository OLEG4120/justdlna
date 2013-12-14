package su.litvak.justdlna.model;

import org.teleal.cling.support.model.DIDLObject;
import org.teleal.cling.support.model.container.Container;
import org.teleal.cling.support.model.item.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class ContainerNode extends ContentNode {
    private Container container;

    public ContainerNode(String id) {
        super(id);
    }

    public final Container getContainer() {
        if (container == null) {
            container = createContainer();
        }
        return container;
    }

    abstract Container createContainer();
    public abstract List<? extends ContainerNode> getContainers();
    public abstract List<ItemNode> getItems();

    public final int getChildCount() {
        return getContainers().size() + getItems().size();
    }

    public List<Container> getContainers(int from, int to) {
        List<? extends ContainerNode> containers = getContainers().subList(from, to);
        List<Container> result = new ArrayList<Container>(containers.size());
        for (ContainerNode containerNode : containers) {
            result.add(containerNode.getContainer());
        }
        return result;
    }

    public List<Item> getItems(int from, int to) {
        List<ItemNode> items = getItems().subList(from, to);
        List<Item> result = new ArrayList<Item>(items.size());
        for (ItemNode itemNode : items) {
            result.add(itemNode.getItem());
        }
        return result;
    }

    @Override
    public void setParent(ContainerNode parent) {
        super.setParent(parent);
        parent.getContainer().addContainer(getContainer());
        parent.getContainer().setChildCount(parent.getContainer().getChildCount().intValue() + 1);
        getContainer().setParentID(parent.getId());
    }
}
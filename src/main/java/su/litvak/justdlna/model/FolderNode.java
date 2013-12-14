package su.litvak.justdlna.model;

import org.teleal.cling.support.model.DIDLObject;
import org.teleal.cling.support.model.WriteStatus;
import org.teleal.cling.support.model.container.Container;
import su.litvak.justdlna.provider.ContentProvider;

import java.io.File;

public class FolderNode extends ContainerNode {
    final File folder;
    final String title;
    ContentProvider contentProvider;

    public FolderNode(ContainerNode parent, String id, String title, File folder) {
        super(parent, id);
        this.folder = folder;
        this.title = title;
    }

    @Override
    Container createContainer() {
        final Container container = new Container();
        container.setClazz(new DIDLObject.Class("object.container"));
        container.setId(id);
        container.setTitle(title);
        container.setRestricted(true);
        container.setWriteStatus(WriteStatus.NOT_WRITABLE);
        container.setChildCount(Integer.valueOf(0));
        return parent.addChild(container);
    }

    @Override
    public ContentProvider getContentProvider() {
        return contentProvider == null ? parent.getContentProvider() : contentProvider;
    }

    public void setContentProvider(ContentProvider contentProvider) {
        this.contentProvider = contentProvider;
    }

    public File getFolder() {
        return folder;
    }
}

package workaround;

import org.apache.xerces.dom.NodeImpl;

public class NodeImplSubclass extends NodeImpl {
    @Override
    public short getNodeType() {
        return 0;
    }

    @Override
    public String getNodeName() {
        return null;
    }
}

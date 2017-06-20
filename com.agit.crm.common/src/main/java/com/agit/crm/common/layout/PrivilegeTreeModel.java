package com.agit.crm.common.layout;

import com.agit.crm.common.dto.usermanagement.PrivilegeDTO;
import java.util.List;
import org.zkoss.zul.AbstractTreeModel;

/**
 *
 * @author bayutridewanto
 */
public class PrivilegeTreeModel extends AbstractTreeModel<PrivilegeDTO> {

    public PrivilegeTreeModel(List<PrivilegeDTO> tree) {
        super(tree.get(0));//root
    }

    @Override
    public boolean isLeaf(PrivilegeDTO node) {
        return (getChildCount(node) == 0);
    }

    @Override
    public PrivilegeDTO getChild(PrivilegeDTO node, int index) {
        if (node.getChildren() != null || !node.getChildren().isEmpty()) {
            return node.getChildren().get(index);
        } else {
            return null;
        }
    }

    @Override
    public int getChildCount(PrivilegeDTO node) {
        if (node.getChildren() != null || !node.getChildren().isEmpty()) {
            return node.getChildren().size();
        } else {
            return 0;
        }
    }

}

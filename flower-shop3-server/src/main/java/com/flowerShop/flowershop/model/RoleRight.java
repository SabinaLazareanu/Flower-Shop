package com.flowerShop.flowershop.model;

import javax.persistence.Embeddable;

@Embeddable
public class RoleRight {
    
    private Role role;
    private Right right;
    
    public RoleRight(Role role, Right right) {
        this.role = role;
        this.right = right;
    }
    
    public Role getRole() {
        return role;
    }
    
    public void setRole(Role role) {
        this.role = role;
    }
    
    public Right getRight() {
        return right;
    }
    
    public void setRight(Right right) {
        this.right = right;
    }
}

package pl.kwojcik.project_lab.user.model;

import java.util.List;

public enum AppRole {

    ADMIN(AppPermission.ORDER_VIEW, AppPermission.PRODUCT_MODIFY, AppPermission.PRODUCT_READ, AppPermission.ADMIN_USER_CREATE),
    CUSTOMER(AppPermission.PRODUCT_READ, AppPermission.ORDER_VIEW, AppPermission.ORDER_MODIFY)
    ;

    private final List<AppPermission> permissions;

    AppRole(AppPermission... permissions) {
        this.permissions = List.of(permissions);
    }

    public List<AppPermission> getPermissions() {
        return permissions;
    }
}

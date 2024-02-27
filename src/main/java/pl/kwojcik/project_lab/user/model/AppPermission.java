package pl.kwojcik.project_lab.user.model;

public enum AppPermission {


    ADMIN_USER_CREATE,
    PRODUCT_READ,
    PRODUCT_MODIFY,
    ORDER_VIEW,
    ORDER_MODIFY,
    ;

    public static final String ROLE_ADMIN_USER_CREATE = "ROLE_ADMIN_USER_CREATE";
    public static final String ROLE_PRODUCT_READ = "ROLE_PRODUCT_READ";
    public static final String ROLE_PRODUCT_MODIFY = "ROLE_PRODUCT_MODIFY";
    public static final String ROLE_ORDER_VIEW = "ROLE_ORDER_VIEW";
    public static final String ROLE_ORDER_MODIFY = "ROLE_ORDER_MODIFY";

    public String getRole() {
        return "ROLE_" + this.name();
    }

}

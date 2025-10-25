

public enum Role implements GrantedAuthority{
    CLIENTE;
    ADMIN;
    @Override
    public String getAuthority() {
        return "ROLE_" + this.name();
    }
}
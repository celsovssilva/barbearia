
@Data
public class JwtResponse {
    private String token;
    private String tipo = "Bearer";
    private String email;
    private String senha;
    private String role;
}
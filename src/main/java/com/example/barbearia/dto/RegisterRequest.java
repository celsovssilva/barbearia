@Data
public class RegisterRequest {
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    private String telefone;

    private int idade;

    @Email(message = "Email deve ser válido")
    @NotBlank(message = "Email é obrigatório")
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    private String senha;
}

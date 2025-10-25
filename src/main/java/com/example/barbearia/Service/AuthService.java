
@Service
@RequiredArgsConstructor
public class AuthService{
    private final AuthenticationManager authenticationManager;
    private final clienteRepository clienteRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public JwtResponse authenticateUser(LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getSenha())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);
        ClienteModel cliente = (ClienteModel) authentication.getPrincipal();

        return new JwtResponse(jwt,
                cliente.getEmailCliente(),
                cliente.getSenhaCliente(),
                cliente.getRole().name());
    }
    public ClienteModel register(RegisterRequest registerRequest){
        if(clienteRepository.findyByEmailCliente(registerRequest.getEmail()).isPresent()){
            throw new RuntimeException("Email ja esta em uso");
        }
        ClienteModel cliente = new ClienteModel();
        cliente.setEmailCliente(registerRequest.getEmail());
        cliente.setSenhaCliente(passwordEncoder.encode(registerRequest.getSenha()));
        cliente.setRole(Role.CLIENTE);
        return clienteRepository.save(cliente);
    }
}

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final ClienteRepository clienteRepository;
    @Override
public userdetails loadUserByUsername(String email) throws UsernameNotFounndException{
    ClienteModel cliente = clienteRepository.findByEmailCliente(email)
            .orElseThrow(() -> new UsernameNotFoundException("Usuario nao encontrado com email: " + email));
    return cliente;
    }
}
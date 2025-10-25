
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request){
        JwtResponse jwtResponse = authService.authenticateUser(request);
        return ResponseEntity.ok(jwtResponse);
    }
    @PostMapping("/register")
    public ResponseEntity<ClienteModel> register(@RequestBody RegisterRequest request){
        ClienteModel cliente = authService.register(request);
        return ResponseEntity.ok(cliente);
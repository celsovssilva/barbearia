
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
private final JwtProvider jwtProvider;
private final UserDetailsService userDetailsService;

@Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
    try{
    String token = getTokenFromRequest(request);
    if (StringUtils.hasText(token) && jwtProvider.validateToken(token)){
        String email = jwtProvider.getEmailFromToken(token);
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities()
        );
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    } catch (Exception e){
        // Log the exception if needed
    }
    filterChain.doFilter(request, response);
}
private String getTokenFromRequest(HttpServletRequest request){
    String bearerToken = request.getHeader("Authorization");
    if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")){
        return bearerToken.substring(7);
    }
    return null;
}
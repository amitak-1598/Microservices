package com.gateway.config;



//@Component
public class AuthenticationFilter {
//implements GlobalFilter, Ordered {

//    private final WebClient.Builder webClientBuilder;
//
//    public AuthenticationFilter(WebClient.Builder webClientBuilder) {
//        this.webClientBuilder = webClientBuilder;
//    }
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        String path = exchange.getRequest().getPath().toString();
//        
//        // Skip authentication for /auth routes
//        if (path.startsWith("/auth")) {
//            return chain.filter(exchange);
//        }
//
//        String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
//        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//            return exchange.getResponse().setComplete();
//        }
//
//        String token = authHeader.substring(7);
//        return webClientBuilder.build()
//            .post()
//            .uri("http://localhost:8085/auth/validate-token")
//            .bodyValue(Map.of("token", token))
//            .retrieve()
//            .onStatus(HttpStatusCode::is4xxClientError, response -> Mono.error(new RuntimeException("Unauthorized")))
//            .toBodilessEntity()
//            .flatMap(response -> chain.filter(exchange));
//    }
//
//    @Override
//    public int getOrder() {
//        return -1; // Ensure this filter executes first
//    }
}

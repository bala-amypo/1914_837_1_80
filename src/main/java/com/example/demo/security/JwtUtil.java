// package com.example.demo.security;

// import com.example.demo.entity.UserAccount;
// import io.jsonwebtoken.*;
// import io.jsonwebtoken.security.Keys;

// import java.security.Key;
// import java.util.Date;
// import java.util.HashMap;
// import java.util.Map;

// public class JwtUtil {

//     private Key key;
//     private final long expirationMillis = 1000 * 60 * 60; // 1 hour

//     public void initKey() {
//         this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//     }

//     // Used in t60
//     public String generateToken(Map<String, Object> claims, String subject) {
//         return Jwts.builder()
//                 .setClaims(claims)
//                 .setSubject(subject)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
//                 .signWith(key)
//                 .compact();
//     }

//     // Used in t61–74
//     public String generateTokenForUser(UserAccount user) {
//         Map<String, Object> claims = new HashMap<>();
//         claims.put("userId", user.getId());
//         claims.put("email", user.getEmail());
//         claims.put("role", user.getRole());

//         return Jwts.builder()
//                 .setClaims(claims)
//                 .setSubject(user.getEmail())
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
//                 .signWith(key)
//                 .compact();
//     }

//     public Claims parseToken(String token) {
//         return Jwts.parserBuilder()
//                 .setSigningKey(key)
//                 .build()
//                 .parseClaimsJws(token)
//                 .getBody();
//     }

//     public String extractUsername(String token) {
//         return parseToken(token).getSubject();
//     }

//     public Long extractUserId(String token) {
//         Object id = parseToken(token).get("userId");
//         if (id instanceof Integer) {
//             return ((Integer) id).longValue();
//         }
//         return (Long) id;
//     }

//     public String extractRole(String token) {
//         return (String) parseToken(token).get("role");
//     }

//     public boolean isTokenValid(String token, String username) {
//         try {
//             String extracted = extractUsername(token);
//             return extracted.equals(username);
//         } catch (Exception ex) {
//             return false;
//         }
//     }
// }

package com.ctd.finalbackend1.config.auth.filters;

import com.ctd.finalbackend1.security.components.JwtUtil;
import com.ctd.finalbackend1.security.entity.UserRoles;
import com.ctd.finalbackend1.security.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class PacienteFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.isUserInRole(UserRoles.ROLE_USER.name())) { // <- si soy USER

            Usuario user = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); // <- obtengo el usuario
            String[] parts = request.getRequestURI().split("/"); // <- obtengo el id del paciente
            /*if (parts[2].equals(user.getPaciente().getId().toString())) { // <- si el id del paciente es el mismo que el del usuario
                filterChain.doFilter(request, response); // <- pasa el filtro
            } else { // <- si no es el mismo
                response.sendError(403); // <- error 403
                // sin enbargo no se que pasa :/ cuando tenga mas tiempo me pondre a debugear e investigar
            }
             */
        }
        filterChain.doFilter(request, response);
    }
}

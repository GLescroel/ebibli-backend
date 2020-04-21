package com.ebibli.infrastructure.rest;


import com.ebibli.domain.LivreClient;
import com.ebibli.domain.UtilisateurClient;
import com.ebibli.infrastructure.rest.livre.LivreClientApi;
import com.ebibli.infrastructure.rest.livre.RestLivreClient;
import com.ebibli.infrastructure.rest.utilisateur.RestUtilisateurClient;
import com.ebibli.infrastructure.rest.utilisateur.UtilisateurClientApi;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients
public class RestConfig {

    @Bean
    public UtilisateurClient restUtilisateur(UtilisateurClientApi utilisateurClientApi) {
        return new RestUtilisateurClient(utilisateurClientApi);
    }

    @Bean
    public LivreClient restLivre(LivreClientApi livreClientApi) {
        return new RestLivreClient(livreClientApi);
    }

    @Bean
    public CustomErrorDecoder customErrorDecoder() {
        return new CustomErrorDecoder();
    }
}

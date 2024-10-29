package com.agrobyte.ApiMobileAgrobyte.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(unique = true)
    private String email;
    private String senha;

    @ManyToOne
    @JoinTable(name = "tb_usuario_perfil",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "perfil_id"))
    private Set<Perfil> perfis = new HashSet<>();

    public void addPerfil(Perfil perfil){
        perfis.add(perfil);
    }

    public boolean hasPerfil(String perfilNome){
        for (Perfil perfil : perfis){
            if(perfil.getAuthority().equals(perfilNome)){
                return true;
            }
        }
        return false;
    }

}

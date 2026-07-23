package com.projectstore.rtdias3d.dtoS;

public class RegisterDTO {

        private String nome;

        private String email;

        private String senha;


        public RegisterDTO() {
        }


        public String getNome() {
            return nome;
        }


        public void setNome(String nome) {
            this.nome = nome;
        }


        public String getEmail() {
            return email;
        }


        public void setEmail(String email) {
            this.email = email;
        }


        public String getSenha() {
            return senha;
        }


        public void setSenha(String senha) {
            this.senha = senha;
        }
}

public class Usuario {
    private Integer id;
    private String nome;
    private String email;

    public Usuario(String nome, String email) {
        setNome(nome);
        setEmail(email);
    }

    public Usuario(Integer id, String nome, String email) {
        this.id = id;
        setNome(nome);
        setEmail(email);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Erro de validação: O nome não pode ser vazio.");
        }
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty() || !email.contains("@")) {
            throw new IllegalArgumentException("Erro de validação: Email inválido.");
        }
        this.email = email;
    }

    @Override
    public String toString() {
        return "ID: " + this.id +
                " - Nome: " + this.nome +
                " - Email: " + this.email;
    }
}
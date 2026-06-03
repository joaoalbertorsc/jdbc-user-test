public class Main {

    public static void main(String[] args) {

        UsuarioService usuarioService = new UsuarioService();

        try {
            Usuario novoUsuario = new Usuario("João Silva", "joao@email.com");

            usuarioService.inserirUsuario(novoUsuario);

            usuarioService.listarUsuarios();

            usuarioService.atualizarEmail(1, "silva@email.com");

            usuarioService.listarUsuarios();

            // usuarioService.excluirUsuario(1);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
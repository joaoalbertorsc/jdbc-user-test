import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    private static final String URL = "jdbc:mysql://localhost:3306/exercicio-jdbc-ebac";
    private static final String USER = "root";
    private static final String PASSWORD = "root123";

    public void inserirUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, email) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());

            int linhas = stmt.executeUpdate();
            System.out.println("Usuário inserido com sucesso. Linhas afetadas: " + linhas);

        } catch (SQLException e) {
            System.out.println("Erro ao inserir usuário " + usuario.getNome() + ": " + e.getMessage());
        }
    }

    public void atualizarEmail(int id, String novoEmail) {
        String sql = "UPDATE usuarios SET email = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoEmail);
            stmt.setInt(2, id); // Setting the ID parameter

            int linhas = stmt.executeUpdate();

            if (linhas > 0) {
                System.out.println("Email atualizado com sucesso. Linhas afetadas: " + linhas);
            } else {
                System.out.println("Aviso: Nenhum usuário encontrado com o ID: " + id);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o ID " + id + ": " + e.getMessage());
        }
    }

    public void excluirUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int linhas = stmt.executeUpdate();

            if (linhas > 0) {
                System.out.println("Usuário removido com sucesso. Linhas afetadas: " + linhas);
            } else {
                System.out.println("Aviso: Nenhum usuário encontrado para exclusão com o ID: " + id);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao excluir usuário com ID " + id + ": " + e.getMessage());
        }
    }

    public void listarUsuarios() {
        String sql = "SELECT id, nome, email FROM usuarios";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            List<Usuario> usuarios = new ArrayList<>();
            while (rs.next()) {
                usuarios.add(
                        new Usuario(
                                rs.getInt("id"),
                                rs.getString("nome"),
                                rs.getString("email")
                        ));
            }

            System.out.println("\n=== LISTA DE USUÁRIOS ===");
            usuarios.forEach(System.out::println);
            System.out.println("=========================\n");
        } catch (SQLException e) {
            System.out.println("Erro ao listar usuários: " + e.getMessage());
        }

    }
}
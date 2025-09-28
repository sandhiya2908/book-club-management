import javax.swing.*;

public class BookClubManagement {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new UserManagementModule();
        });
    }
}
